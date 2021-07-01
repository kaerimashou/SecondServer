package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.task.model.Document;
import test.task.service.AppService;

import java.util.Arrays;

@Controller
@RequestMapping("/save")
public class SaveController {


    private final AppService appService;

    @Autowired
    public SaveController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/upload")
    public String saveToDb(@RequestBody Document[] list, Model model) {
        appService.save(Arrays.asList(list));
        return "redirect:/save";
    }
}
