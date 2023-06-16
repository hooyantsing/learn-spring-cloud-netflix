package xyz.hooy.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ExceptionStockController {

    @GetMapping("/timeout")
    public String timeout() throws InterruptedException {
        Thread.sleep(10 * 1000);
        return "no exception";
    }

    @GetMapping("/service-exception")
    public String serviceException() {
        int i = 1 / 0;
        return "no exception";
    }
}
