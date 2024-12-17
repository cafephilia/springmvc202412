package com.spring.mvcproject.chap2_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ResponseController {
    @GetMapping("/pet")
    public String pet(){
        return "pet";
    }
    @GetMapping("/show/html")
    @ResponseBody
    public String html(){
        return """
                <html>
                <body>
                <h1>야 나는 자바야</h1>
                </body>
                </html>
                """;
    }
    @GetMapping("/json/hobbies")
    @ResponseBody
    public List<String> hobbies(){
        return List.of("수영","농구","낮잠","탁구");
    }
    @GetMapping("/json/my-cat")
    @ResponseBody
    public Map<String,Object> myCat(){
        return Map.of(
                "name", "나옹이",
                "age", 3,
                "injection", false
        );
    }

}
