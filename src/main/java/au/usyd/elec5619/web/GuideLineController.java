package au.usyd.elec5619.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import au.usyd.elec5619.service.GuideCategoryManager;
import au.usyd.elec5619.service.GuideManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GuideLineController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    private GuideManager guideManager;
    private GuideCategoryManager guideCategoryManager;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("guideCategories", this.guideCategoryManager.getGuideCategories());
        myModel.put("guides", this.guideManager.getGuides());

        return new ModelAndView("guidelines", "model", myModel);
    }

    public void setGuideManager(GuideManager guideManager) {
        this.guideManager = guideManager;
    }
    
    public void setGuideCategoryManager(GuideCategoryManager guideCategoryManager) {
        this.guideCategoryManager = guideCategoryManager;
    }
    
    
}