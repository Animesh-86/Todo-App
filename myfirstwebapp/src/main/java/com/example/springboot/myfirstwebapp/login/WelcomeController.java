package com.example.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController { // LoginController

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {

        model.put("name", getLoggedinUsername());
        return "welcome";   // jsp file name
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public String gotoLoginPage(ModelMap model) {
//
//        model.put("name", "Animesh");
//        return "welcome";   // jsp file name
//    }

//    @RequestMapping(value="login", method = RequestMethod.POST)
//    public String gotoWelcomePage(
//            @RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if(authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            //model.put("password", password);
//            return "welcome";
//        } // jsp file name
//        model.put("error", "Invalid username or password");
//        return "login";
//    }

//    @RequestMapping(value="login", method = RequestMethod.GET)
//    public String gotoLoginPage() {
//        return "login";   // jsp file name
//    }
//
//    @RequestMapping(value="login", method = RequestMethod.POST)
//    public String gotoWelcomePage(
//            @RequestParam String name, @RequestParam String password, ModelMap model) {
//
//        if(authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            //model.put("password", password);
//            return "welcome";
//        } // jsp file name
//        model.put("error", "Invalid username or password");
//        return "login";
//    }



//    public Logger getLogger() {
//        return logger;
//    }
//
//    public void setLogger(Logger logger) {
//        this.logger = logger;
//    }
}
