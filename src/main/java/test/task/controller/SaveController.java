package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import test.task.model.Document;
import test.task.service.implementation.AppServiceImpl;

import java.util.Arrays;

@Controller
@RequestMapping("/save")
public class SaveController {

    private final AppServiceImpl appServiceImpl;

    @Autowired
    public SaveController(AppServiceImpl appServiceImpl) {
        this.appServiceImpl = appServiceImpl;
    }

    @PostMapping("/upload")
    public String saveToDb(@RequestBody Document[] list, Model model) {
        appServiceImpl.save(Arrays.asList(list));
        return "redirect:/save";
    }
}
