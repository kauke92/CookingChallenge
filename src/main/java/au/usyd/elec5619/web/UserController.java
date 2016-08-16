package au.usyd.elec5619.web;


import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import au.usyd.elec5619.domain.Recipe;
import au.usyd.elec5619.domain.User;
import au.usyd.elec5619.domain.UserRole;
import au.usyd.elec5619.service.UserManager;
import au.usyd.elec5619.service.LoggedUserDetails;

@Controller
@RequestMapping(value="/user")
public class UserController {

	protected final Log logger = LogFactory.getLog(getClass());

	private String getLoggedInUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//	User user = ((LoggedUserDetails) SecurityContextHolder
	//			.getContext().getAuthentication().getPrincipal()).getUser();
		if("[ROLE_ANONYMOUS]".equals(auth.getAuthorities().toString()) || !auth.isAuthenticated()) {
			return null;
		}
		return auth.getName();
	}

	@Resource(name="userManager")
	private UserManager userManager;

	@RequestMapping(value="/")
	public String addUser(Model uiModel) {
		User user = new User();
		uiModel.addAttribute("user", user);

		return "user/add";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result, @RequestParam String action, Model m) {
		if(action.equals("Cancel")) {
		} else {
			if(result.hasErrors()) {
				return "user/add";
			}
			if(this.userManager.checkUsername(user.getUsername())) {
				result.rejectValue("username", "unique");
				return "user/add";
			}
			Date date = new Date();
			user.setDatecreated(date.toString());
		//	Set<UserRole> roleSet = new HashSet<UserRole>();
		//	UserRole role = new UserRole();
		//	role.setRole("user");
		//	role.setUser(user);
		//	roleSet.add(role);
			//System.out.println(role);
		//	user.setUserRole(roleSet);
			this.userManager.addUser(user);
		//	System.out.println(user);
		}
		//	long id = user.getId();

		return "redirect:/loginPage";
	}
	
	
	@RequestMapping(value="/users")
	public String searchUsers(Model uiModel) {
		List<User> users = this.userManager.getUsers();
		uiModel.addAttribute("users", users);
		List<String> checkList = new ArrayList<String>();
		checkList.add("checked");
		checkList.add("checked");
		checkList.add("checked");
		checkList.add("checked");
		uiModel.addAttribute("checkedlist", checkList);
		return "user/users";
	}

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String searchUsers(String search, String [] cbox, @RequestParam String action, Model uiModel) {
		Set<User> users = new HashSet<User>();
		System.out.println(search);
		List<String> checkList = new ArrayList<String>();
		String usernamebox = " ";
		String firstnamebox = " ";
		String lastnamebox = " ";
		String locationbox = " ";
		if(cbox != null) {
			for(int i = 0; i < cbox.length; i++) {
				if(cbox[i].equals("username")) {
					usernamebox = "checked";
					users.addAll(this.userManager.searchUsers(search, "username"));
				}
				if(cbox[i].equals("firstname")) {
					firstnamebox = "checked";
					users.addAll(this.userManager.searchUsers(search, "firstname"));
				}
				if(cbox[i].equals("lastname")) {
					lastnamebox = "checked";
					users.addAll(this.userManager.searchUsers(search, "lastname"));
				}
				if(cbox[i].equals("location")) {
					locationbox = "checked";
					users.addAll(this.userManager.searchUsers(search, "location"));
				}
			}
			checkList.add(usernamebox);
			checkList.add(firstnamebox);
			checkList.add(lastnamebox);
			checkList.add(locationbox);
		} 
		else {
			checkList.add(" ");
			checkList.add(" ");
			checkList.add(" ");
			checkList.add(" ");
		}
		
		uiModel.addAttribute("users", users);
		uiModel.addAttribute("search", search);
		uiModel.addAttribute("checkedlist", checkList);
		return "user/users";
	}

	@RequestMapping(value="/profile")
	public String profileUser(Model model) {
		String userName = getLoggedInUsername();
		System.out.println(userName);
		if(userName == null) {
			return "loginPage";
		}
		User user = this.userManager.getUserByUsername(userName);
		user.setPassword("");
		user.setConfirmpassword("");
		model.addAttribute("user", user);
		return "user/profile";
	}



	@RequestMapping(value="/settings", method=RequestMethod.GET)
	public String editUser(Model model) {
		String userName = getLoggedInUsername();
		if(userName == null) {
			return "loginPage";
		}

		List<String> activeTabs = new ArrayList<String>();
		activeTabs.add("active");
		activeTabs.add("inactive");
		model.addAttribute("activeTab", activeTabs);
		
		List<String> activePanel = new ArrayList<String>();
		activePanel.add("tab-pane fade active in");
		activePanel.add("tab-pane fade in");
		model.addAttribute("activePanel", activePanel);
		
		User user = this.userManager.getUserByUsername(userName);
		user.setPassword("");
		user.setConfirmpassword("");
		model.addAttribute("user", user);	
		return "user/edit";
	}

	@RequestMapping(value="/settings", method=RequestMethod.POST)
	public String editUser(@Valid User user, BindingResult result, @RequestParam String action, Model model) {
		String userName = getLoggedInUsername();
		if(userName == null) {
			return "loginPage";
		}

		User loggedInUser = this.userManager.getUserByUsername(userName);
		if(loggedInUser.getId() != user.getId()) {
			result.rejectValue("id", "wrongUser");
			System.out.println("WRONG ID");
			return "user/edit";
		}
		if(action.equals("Cancel")) {
		} else {
			if(result.hasErrors()) {
				if(action.equals("password")) {
					if((result.getFieldError("password") == null) && (result.getFieldError("confirmpassword") == null) ) {
						loggedInUser.setPassword(user.getPassword());
						loggedInUser.setConfirmpassword(user.getConfirmpassword());
						
						this.userManager.updateUser(loggedInUser);
						user=loggedInUser;
						List<String> activeTabs = new ArrayList<String>();
						activeTabs.add("inactive");
						activeTabs.add("active");
						model.addAttribute("activeTab", activeTabs);
						List<String> activePanel = new ArrayList<String>();
						activePanel.add("tab-pane fade in");
						activePanel.add("tab-pane fade active in");
						model.addAttribute("activePanel", activePanel);
						model.addAttribute("user", user);
						//user.setPassword("");
						//user.setConfirmpassword("");
					} else {
						List<String> activeTabs = new ArrayList<String>();
						activeTabs.add("inactive");
						activeTabs.add("active");
						model.addAttribute("activeTab", activeTabs);
						List<String> activePanel = new ArrayList<String>();
						activePanel.add("tab-pane fade in");
						activePanel.add("tab-pane fade active in");
						model.addAttribute("activePanel", activePanel);
					}
				} 
				if(action.equals("account")) {
					if((result.getFieldError("firstname") == null) && (result.getFieldError("username") == null) && (result.getFieldError("emailaddress") == null) ) {
						loggedInUser.setFirstname(user.getFirstname());
						loggedInUser.setLastname(user.getLastname());
						loggedInUser.setDescription(user.getDescription());
						loggedInUser.setEmailaddress(user.getEmailaddress());
						loggedInUser.setLocation(user.getLocation());
						this.userManager.updateUser(loggedInUser);
						return "user/edit";
					} else {
						List<String> activeTabs = new ArrayList<String>();
						activeTabs.add("active");
						activeTabs.add("inactive");
						model.addAttribute("activeTab", activeTabs);
						List<String> activePanel = new ArrayList<String>();
						activePanel.add("tab-pane fade active in");
						activePanel.add("tab-pane fade in");
						model.addAttribute("activePanel", activePanel);
						
					}
				}
				return "user/edit";
			}
			/*			if(!loggedInUser.getUsername().equals(user.getUsername())) {
				System.out.println(loggedInUser.getUsername());
				System.out.println(user.getUsername());

				if(this.userManager.checkUsername(user.getUsername())) {
					result.rejectValue("username", "unique");
					return "user/edit";
				}
			}*/
			if(action.equals("password")) {
				System.out.println("passwordhere");
				loggedInUser.setPassword(user.getPassword());
				loggedInUser.setConfirmpassword(user.getConfirmpassword());
				
				List<String> activeTabs = new ArrayList<String>();
				activeTabs.add("inactive");
				activeTabs.add("active");
				model.addAttribute("activeTab", activeTabs);
				
				List<String> activePanel = new ArrayList<String>();
				activePanel.add("tab-pane fade in");
				activePanel.add("tab-pane fade active in");
				model.addAttribute("activePanel", activePanel);
			}
			if(action.equals("account")) {
				System.out.println("accounthere");
				List<String> activeTabs = new ArrayList<String>();
				activeTabs.add("active");
				activeTabs.add("inactive");
				model.addAttribute("activeTab", activeTabs);
				List<String> activePanel = new ArrayList<String>();
				activePanel.add("tab-pane fade active in");
				activePanel.add("tab-pane fade in");
				model.addAttribute("activePanel", activePanel);
				
				return "user/edit";
			}
			this.userManager.updateUser(loggedInUser);
			
		}
		return "redirect:/user/profile";
	}




	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser() {
		String userName = getLoggedInUsername();
		if(userName == null) {
			return "loginPage";
		}
		User loggedInUser = this.userManager.getUserByUsername(userName);
		this.userManager.deleteUser(loggedInUser.getId());
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/";
	}




	/*	@RequestMapping(value="/{id}/edituser/uploadimage", method=RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute("uploadItem", new File("C://demo.txt"));
		return "uploadimage";
	}
	 */
	/*	@RequestMapping(value="/{id}/edituser/uploadimage", method = RequestMethod.POST)
	public String create(@PathVariable("id") long id, UploadItem uploadItem, HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors,
			HttpSession session) {
		try {

			MultipartFile filea = uploadItem.getFileData();

			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (filea.getSize() > 0) {
				inputStream = filea.getInputStream();
				// File realUpload = new File("C:/");
				outputStream = new FileOutputStream("C:\\test111\\"
						+ filea.getOriginalFilename());
				System.out.println("====22=========");
				System.out.println(filea.getOriginalFilename());
				System.out.println("=============");
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					System.out.println("===ddd=======");
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				session.setAttribute("uploadFile", "C:\\test111\\"
						+ filea.getOriginalFilename());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user/" + id + "/profile";
	}

	 */

	/* @RequestMapping(value="/{id}/edituser/uploadimage/upload", method=RequestMethod.GET)
	public @ResponseBody String UploadInfo() {
		return "If you use post you can upload an image";
	}


	@RequestMapping(value="/{id}/profile/profileimage", method=RequestMethod.GET)
	public @ResponseBody byte[] showProfileImage(@PathVariable("id") long id) {
		Blob image = this.userManager.getUserById(id).getProfileimage();

		try {
			return image.getBytes(1, (int) image.length());
		} catch (SQLException e) {
			System.out.println("SQLImage exception");
		} catch (NullPointerException e) {
			System.out.println("Null pointer image exception");
		}
		return new byte[0];
	}


	@RequestMapping(value="/{id}/edituser/upload", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@PathVariable("id") long id, @RequestParam(value="name", required=false) String name,
			@RequestParam(value="file", required=false) File file) {
		try {
			if(file.isFile()) {
				userManager.storeUserImage(userManager.getUserById(id), read(file));
			}
		}
		catch (FileNotFoundException e) {
			return "Not found!";
		} catch (IOException e) {
			return "failed";
		} catch (NullPointerException e){
			return "Null";
		}
		return "you arrived!";
	}

	public long MAX_FILE_SIZE = 100000000;
	 */
	/*	public byte[] read(File file) throws IOException {
	    if (file.length() > MAX_FILE_SIZE) {
	       return new byte [0];
	    }

	    byte[] buffer = new byte[(int) file.length()];
	    InputStream ios = null;
	    try {
	        ios = new FileInputStream(file);
	        if (ios.read(buffer) == -1) {
	            throw new IOException(
	                    "EOF reached while trying to read the whole file");
	        }
	    } finally {
	        try {
	            if (ios != null)
	                ios.close();
	        } catch (IOException e) {
	        }
	    }
	    return buffer;
	}
	 */
	/*	private String saveDirectory = null;

//	@SuppressWarnings("null")
	@RequestMapping(value = "/{id}/edituser/uploadimage", method = RequestMethod.POST)
	public String save(
			@PathVariable("id") long id, @ModelAttribute("uploadItem") File file,
			Model map,HttpServletRequest request) throws IllegalStateException, IOException{

		//List<MultipartFile> files = uploadForm.getFiles();
		String fileUrl = new String();
		String fileName2 = null;
		fileName2 = request.getSession().getServletContext().getRealPath("/");
		saveDirectory = fileName2+"images\\";
		//System.out.println("user directory : "+System.getProperty("user.dir"));
		System.out.println("applied directory : " + saveDirectory);
		if(null != file) {
			String fileName = String.valueOf(id);
			System.out.println("applied directory : " + saveDirectory+fileName);
			if(!"".equalsIgnoreCase(fileName)){
				fileUrl= saveDirectory + fileName;
			}
			userManager.getUserById(id).setProfileimagelocation(fileUrl);
		}


		return "redirect:/user/" + id + "/profile";
	}*/


}