package com.checkpeng.springboottest.aspect;

import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("aspect")
public class AspectController {

    @GetMapping("runFunc")
    public void runFunc() {
        System.out.println("test");
    }
}
