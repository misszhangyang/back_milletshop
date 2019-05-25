package milletshop.millet.controller;

import milletshop.millet.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    AsyncService asyncService = null;

    @GetMapping("/page")
    public String asyncPage(){
        System.out.println("请求线程名称是："+ Thread.currentThread().getName());
        System.out.println("------------------");
        asyncService.generateReport();
        return "async";
    }
}
