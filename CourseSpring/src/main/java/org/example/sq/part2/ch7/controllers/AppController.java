package org.example.sq.part2.ch7.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AppController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Requst mapping test.!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> test1(@PathVariable long id) {
        return  ResponseEntity.ok("The id you have sent a path variable : " + id);
    }

    @GetMapping("/id")
    public ResponseEntity<?> test2(@RequestParam long id) {
        return  ResponseEntity.ok("The id you have sent a request param : " + id);
    }

    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", "red");
        return "home";
    }

    @RequestMapping("/home1")
    public String home2(
            @RequestParam(required = true) String username,
            @RequestParam(required = true) String color,
            Model page) {
        page.addAllAttributes(Map.of("username",username, "color", color));
        return "home";
    }
}
