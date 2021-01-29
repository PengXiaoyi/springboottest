package com.checkpeng.springboottest.aspect;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aspect")
public class AspectController {

    @GetMapping("runFunc")
    public String runFunc() {
        System.out.println("test");
        return "111";
    }
}
