package test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.task.model.DocumentPOJO;
import test.task.model.ReportProjection;
import test.task.service.implementation.AppServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/save")
public class SaveController {

    private final AppServiceImpl appService;

    @Autowired
    public SaveController(AppServiceImpl appService) {
        this.appService = appService;
    }

    @PostMapping("/upload")
    public void saveToDb(@RequestBody List<DocumentPOJO> list) {
        appService.save(list);
    }

    @GetMapping("/statistics")
    public Map<String, Object> getStatistics() {
        return appService.getStatistics();
    }

    @GetMapping("/report/{id}")
    public ReportProjection getReport(@PathVariable Long id) {
        return appService.getParticipantInfo(id);
    }

    @GetMapping("/report")
    public List<ReportProjection> getReportAll() {
        return appService.getAllParticipantInfo();
    }
}
