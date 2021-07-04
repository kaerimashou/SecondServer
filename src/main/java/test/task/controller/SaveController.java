package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.model.DocumentPOJO;
import test.task.service.implementation.AppServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/save")
public class SaveController {

    private final AppServiceImpl appServiceImpl;


    @Autowired
    public SaveController(AppServiceImpl appServiceImpl) {
        this.appServiceImpl = appServiceImpl;
    }

    @PostMapping("/upload")
    public void saveToDb(@RequestBody List<DocumentPOJO> list) {
        appServiceImpl.save(list);
//        list.forEach(System.out::println);
    }
}
