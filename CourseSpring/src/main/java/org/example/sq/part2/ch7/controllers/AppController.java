package org.example.sq.part2.ch7.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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



}
