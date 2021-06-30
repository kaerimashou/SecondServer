package test.task.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import test.task.model.Document;
import test.task.repository.DocumentRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan("test.task")
@EnableJpaRepositories("test.task.repository")
@EntityScan("test.task.model")
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    private final DocumentRepository documentRepository;

    @Autowired
    public DemoApplication(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate)throws Exception{
//        return args->{
//            List<Document> list=restTemplate.getForObject("http://localhost:8090/rest/all", ArrayList.class);
//            for (Document d:
//                 list) {
//                log.info(String.valueOf(d.toString()));
//                documentRepository.save(d);
//            }
//        };
//    }

}
