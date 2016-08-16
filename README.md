# CookingChallenge
A Java Spring project
#Great-Ful Cooking - ELEC5619

This project aims to build an engaging and personalised resource for young and middle aged people to learn about healthy eating habits and to allow their creativity to produce healthy, tasty and unique foods for themselves and the community to enjoy.

###The Concept
This product will be a website that works on desktop browsers and mobiles for the user. There are three distinct features this product provides to support the theme of healthy eating. These include the Challenge System where users will participate in an admin/user generated cooking challenge (with certain ingredients and rules that need to be followed) and submit their recipes and videos of the recipes. These submissions will be required to be within a particular guidelines for safe and healthy eating. The Cookbook is another feature of this project where there will be a large list of user submitted recipes with certain restrictions as they have to be within a recommended dietary range (i.e. recipes with high amounts of sugar will not be allowed). The last major feature is the Healthy Eating/Cooking Guides where information about what constitutes healthy diets and tutorials/guides on how to safely cook a healthy meal.

The information about what the Challenges are, the recipes in the cookbook and the healthy eating/cooking guides are available to all users without registration. However to customise user settings/notifications from google calendar about upcoming events as well as voting, reviewing or entering submissions to the challenge system will require a user to be registered and logged in. The user will also be required to log in to submit recipes and guides and their reviews for these parts as well.



###Aims 

* Development of a desktop browser-based interface which contains information about healthy food, balancing diets and tutorials on healthy cooking

* Development of a cooking competition that engages people to create healthy, tasty and unique dishes given a particular set of ingredients or rules  

* Development of a community based review system to evaluate and review dishes based on their healthiness and tastiness
Use an agile product design approach (frequent iterations and user feedback)  

**Target Population: Australians aged 15-39** 

Project scope: The individual sub-project described here will include the Submission system for the Challenge system (including submitting/validating an entry and voting on submitted entries) and the user profile (personalisation of profile and navigation of other user profiles). 


1. User profile system, where the user can personalise their profile and navigate/view to other user profiles
 
2. Challenge System will be developed that consists of a user created cooking challenge focusing on healthy ingredients/guidelines for all users of this application. The winner of the previous challenge will set the next challenge, as a fun incentive for the users to create unique, tasty healthy dishes. 

3. A Cookbook will be developed featuring healthy recipes for the users to try, where it will be a compilation of user submissions

4. A healthy eating and good practices guide which focuses on providing guides/tutorials on what constitutes a healthy diet and good ways to cook food. 

Other features included in the sub-projects includes creating controls and moderation of user content, SSO (single-sign on) into the site for access to some features such as voting on submissions, reviewing foods/recipes and making favourites lists of different recipes and challenges the user liked. This project will also include a user history where the user can check what they have done on the site.


## Quality Management Guideline

To ensure a high quality product, we created unit tests before writing the code with Test First Development. Tests should all follow these guidelines to ensure their standards and set quality standards for the unit tests that we design.

### Domain Tests
Domain tests should test all the different set and get methods of a domain, ensuring that the getters and setters have been properly implemented. In addition, any other functions (such as a comparator, or functions that the domain has) should all have tests to properly check their behaviour

### Manager Tests
The Manager tests should all test the business logic of our system. To do this, a Simple Manager which is independent of hibernate should be created and 



As a type of prototype and as part of the development process, each of us created MockUps of the system we planned to create, and made a table of all the different components of this project. We also designed the MVC model in a diagram which showed the way the domains, managers and controllers will interact with one another.



# Individual components: Healthy Eating & Practices Guides (Cooking Guidelines) #

It is important to cook safely and store food and ingredients properly. Cooking Guides page provides the following features that help users keep safe and clean when cooking. 

![8.PNG](https://bitbucket.org/repo/nBzXnB/images/3989292380-8.PNG)

# Category 

Each guide is classified in a category. There would be about 4 different categories, for example: safety guide, vegetable preservation etcetera. Users need to choose an appropriate category in which their guide will be defined.

![1.PNG](https://bitbucket.org/repo/nBzXnB/images/3276630-1.PNG)

#Guide

The users will be provided the add, edit and delete guide. Working in these sections, the user will have chance to user the editor ( see the image below) which allows users have a document similar toHTML format

![9.PNG](https://bitbucket.org/repo/nBzXnB/images/3472538384-9.PNG)

# Commenting 

Users are encouraged to share their reviews on any guide as the reviews are important as they indicate the quality of the guides. 

![2.PNG](https://bitbucket.org/repo/nBzXnB/images/263999427-2.PNG)

# Favoriting 

Users could favourite any guide, this function is similar to the Like button on Facebook.

![3.PNG](https://bitbucket.org/repo/nBzXnB/images/2759278462-3.PNG)

 Later this will allow users to view the guides they favourite.

![4.PNG](https://bitbucket.org/repo/nBzXnB/images/2881199632-4.PNG)


# Searching 

The contents of guides includes some **keywords**. When users add a new guide, the system find the keywords in the contents of the guide,  and then add those keywords to the database. The searching function helps users find their desired guides on the **keyword** and this will be displayed by default in descending order on the number of likes. When users type some first characters, the page will shows them all suggested keywords.

![5.PNG](https://bitbucket.org/repo/nBzXnB/images/3854729335-5.PNG)

# Recommendation 

 As each guide are related to a particular topic or ingredient, it is convenient to suggest users the related recipes that they could practice using the guide. This function will compare the similarities between guide contents ( cousin similarity) and choose top 5 to suggest to users.

![6.PNG](https://bitbucket.org/repo/nBzXnB/images/1064604866-6.PNG)

# Admin Ability 

Besides all of the features for normal users, the admins are able to edit and delete any guides, comments.

![7.PNG](https://bitbucket.org/repo/nBzXnB/images/1021685968-7.PNG)

In this project, I also take responsibility to implement User Login with Spring Security. With the User Login page the traditional way in which the user enters username and password within their respective fields is implemented. 

