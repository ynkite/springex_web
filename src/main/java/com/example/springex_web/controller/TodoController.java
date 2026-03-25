package com.example.springex_web.controller;


import com.example.springex.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2

public class TodoController {
    @RequestMapping("/list")
    public void list(Model model) {
        log.info("todo list............");
    }

    //@RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("register")
    public void register() {
        log.info("todo register........");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("POST todo register............");
        log.info(todoDTO);
    }

}
