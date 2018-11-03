package oleg.podolian.demo.controller;

import oleg.podolian.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/aggregator")
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable ("name") String name) {
        System.out.println("method hello was invoked!");
//        currencyService.equals()
        return "Hello " + name;
    }

    @PostMapping("/file/upload")
    public void upload(@RequestBody MultipartFile file) {
        if (file == null) {
            System.out.println("Not found");
//        return ResponseEntity.ok();
        } else {
            System.out.println(file.getOriginalFilename());
        }
//        return ResponseEntity.ok();
    }
}
