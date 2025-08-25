package com.example.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }
//    private Logger logger = LoggerFactory.getLogger(getClass());

    // Model transfers data controller to jsp
//    @RequestMapping("login")
//    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//        model.put("name", name);
//        logger.debug("Request param is {}", name);
//        logger.info("I want this printed a info level");
//        logger.warn("I want this printed a warn level");
//        System.out.println("Request param is  " + name);
//        return "login";   // jsp file name
//    }

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";   // jsp file name
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String gotoWelcomePage(
            @RequestParam String name, @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name, password)) {
            model.put("name", name);
            //model.put("password", password);
            return "welcome";
        } // jsp file name
        model.put("error", "Invalid username or password");
        return "login";
    }

//    public Logger getLogger() {
//        return logger;
//    }
//
//    public void setLogger(Logger logger) {
//        this.logger = logger;
//    }
}
