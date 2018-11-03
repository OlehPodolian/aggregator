package oleg.podolian.demo.controller;

import oleg.podolian.demo.model.Currency;
import oleg.podolian.demo.service.CurrencyService;
import oleg.podolian.demo.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/aggregator")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final ParsingService parsingService;

    @Autowired
    public CurrencyController(CurrencyService currencyService,
                              ParsingService parsingService) {
        this.currencyService = currencyService;
        this.parsingService = parsingService;
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
//            boolean result = parsingService.parse(file)
            if (true) {
//                return; ok
            } else {
//                bad file
            }
        }
//        return ResponseEntity.ok();
    }

    @GetMapping("/currencies/{bank}")
    @ResponseBody
    public List<Currency> currencies(@PathVariable String bank) {
        return Collections.emptyList();
//        return currencyService.fi
    }
}
