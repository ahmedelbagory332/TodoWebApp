package com.springboot.TodoWebApp.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;


@Controller
@RequestMapping("api/todoApp/")
// SessionAttributes to hold the value which stored in key (name) to transfer to another page
// we write SessionAttributes on page where we want to take value and in page where we want to display the value
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

// private Logger logger = LoggerFactory.getLogger(getClass());
//    @RequestMapping("login")
//    public String login(@RequestParam String name, ModelMap model) {
//        // ModelMap to send data to jsp file
//        model.put("name",name);
//        logger.debug("name is : " + name);
//        return "login";
//    }

    @RequestMapping("/login")
    public String handleLoginRequest(@RequestParam(required = false) String name, @RequestParam(required = false) String password, ModelMap model, RedirectAttributes redirectAttributes) {
        // Check if the request is a POST request
        if (name != null || password != null) {
           if (authenticationService.authenticate(name, password)) {
                model.put("name", name);
                redirectAttributes.addFlashAttribute("name", name);
                return "redirect:/api/todoApp/welcome";
            } else {
                model.put("errorMessage", "Invalid Credentials! Please try again.");
                return "login";
            }

        }

        return "login";
    }

    @RequestMapping("/welcome")
    public String handleWelcomeRequest(@ModelAttribute("name") String name) {
        return "welcome";
    }


}

