package milletshop.millet.controller;

import milletshop.millet.service.active.ActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/active")
public class ActiveMqController {

    @Autowired
    private ActiveMqService activeMqService;

    @GetMapping("/page")
    public String getMsg(){
        String msg = "自动转换的消息";
        activeMqService.sendMsg(msg);
        return "hello";
    }
}
