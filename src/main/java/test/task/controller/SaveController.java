package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import test.task.model.Document;
import test.task.repository.DocumentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/save")
public class SaveController {

    private final DocumentRepository repository;
    private final RestTemplate restTemplate;

    @Autowired
    public SaveController(RestTemplate restTemplate,DocumentRepository documentRepository) {
        this.restTemplate = restTemplate;
        this.repository=documentRepository;
    }

    @PostMapping("/upload")
    public int saveToDb(){
        Document[] list=restTemplate.getForObject("http://localhost:8090/rest/all",Document[].class);
        Arrays.stream(list).forEach(repository::save);
        return list.length;
    }

    @GetMapping()
    public String savedFiles(Model model){
        model.addAttribute("size",saveToDb());
        return "report";
    }
}
