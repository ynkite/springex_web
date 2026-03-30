package com.example.springex_web.controller;


import com.example.springex_web.dto.PageRequestDTO;
import com.example.springex_web.dto.TodoDTO;
import com.example.springex_web.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
//    @RequestMapping("/list")
//    public void list(Model model){
//        log.info("todo list........");
//        model.addAttribute("dtoList", todoService.getAll());
//    }
    //    @RequestMapping(value ="/register", method= RequestMethod.GET) //GETMAPPING

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info(pageRequestDTO);
        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register() {
        log.info("todo register........");
    }

//    @PostMapping("/register")
//    public void registerPost(TodoDTO todoDTO) {
//        log.info("POST todo register..........");
//        log.info(todoDTO);
//    }

//    @PostMapping("/register")
//    public String registerPost(TodoDTO todoDTO , RedirectAttributes redirectAttributes) {
//        log.info("POST todo register..........");
//        log.info(todoDTO);
//        return "redirect:/todo/list";
//    }
    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO ,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST todo register..........");
        if(bindingResult.hasErrors()) {
            log.info("has error.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info(todoDTO);
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

//    @GetMapping("/read")
//    public void read(Long tno, Model model){
    @GetMapping({"/read", "/modify"})
        public void read(Long tno, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }

    @PostMapping ("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {
        log.info("-----------------remove-------------------");
        log.info("tno: " + tno);
        todoService.remove(tno);
        return "redirect:/todo/list";
    }
    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            log.info("has error.............");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        return "redirect:/todo/list";
    }

}

