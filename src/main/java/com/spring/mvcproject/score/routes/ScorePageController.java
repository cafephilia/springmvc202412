package com.spring.mvcproject.score.routes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//성적관리에 필요한 JSP파일들을 포워딩하는 컨트롤러
@Controller
public class ScorePageController {

    @GetMapping("/score/page")
    public String scorePage(){
        return "score/score-page";
    }
}
