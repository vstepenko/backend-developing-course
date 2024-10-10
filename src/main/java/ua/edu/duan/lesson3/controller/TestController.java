package ua.edu.duan.lesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.edu.duan.lesson3.service.FunWithTransactionService;
import ua.edu.duan.lesson3.service.TestService;

@Controller
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TestController {

    private TestService testService;

    private  FunWithTransactionService funWithTransactionService;

    @Autowired
    public void setTestService(TestService testService, FunWithTransactionService funWithTransactionService) {
        this.testService = testService;
        this.funWithTransactionService = funWithTransactionService;
    }

    @GetMapping(path ="/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String hello() {
        return testService.helloWorld();
    }


    @PostMapping(path = "/buy-car")
    @ResponseBody
    public void buy(){
        funWithTransactionService.buy();
    }

}
