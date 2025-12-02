package org.example.sq.part2.ch9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
public class LoginController {

    @Autowired
    LoginProcessor loginProcessor;
    @Autowired
    LoggedUserManagementService loggedUserManagementService;
    @Autowired
    CounterService counterService;

    @GetMapping("/")
    public String loginGet(){
        System.out.println("Here");
        return "login_ch9";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            org.springframework.ui.Model model){

        loginProcessor.setPassword(password);
        loginProcessor.setUsername(username);

        if (loginProcessor.login()) {
            model.addAttribute("message","You are now logged in.");
            counterService.increment();
            return "redirect:/home";
        } else {
            model.addAttribute("message", "Login failed!");
        }
        return "login_ch9";
    }

    @GetMapping("/home")
    public String home(
            @RequestParam(required = false) String logout,
            Model model) {
        if (logout != null){
            loggedUserManagementService.setUsername(null);
        }

        String username =
                loggedUserManagementService.getUsername();
        if (username == null) {
            return "login_ch9";
        }
        model.addAttribute("username",username);
        model.addAttribute("counter",counterService.getCounter());
        return "main_ch9";
    }

}
