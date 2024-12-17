package com.spring.mvcproject.score.api;

import com.spring.mvcproject.score.entity.Score;
import com.spring.mvcproject.score.routes.ScorePageController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreApiController {
    private Map<Long, Score> scoreStore = new HashMap<>();

    private Long nextId = 1L;
    public ScoreApiController() {
        Score s1 = new Score(nextId++, "김말복", 100, 88, 75);
        Score s2 = new Score(nextId++, "박수포자", 55, 95, 15);
        Score s3 = new Score(nextId++, "김마이클", 4, 100, 40);

        scoreStore.put(s1.getId(), s1);
        scoreStore.put(s2.getId(), s2);
        scoreStore.put(s3.getId(), s3);
    }

    // 전체 성적정보 조회
    @GetMapping
    public List<Score> scoreList(){
        return new ArrayList<>((scoreStore.values()));
    }
    @PostMapping
    public String addScore(
            @RequestParam String name,
            @RequestParam int kor,
            @RequestParam int eng,
            @RequestParam int math
    ){
        Score newScore = new Score(nextId,name,kor,eng,math);
        scoreStore.put(nextId++,newScore);
        return "새 성적 등록됨";
    }
    @DeleteMapping
    public String deleteScroe(
            @RequestParam Long id
    ){
        scoreStore.remove(id);
        return "성적 삭제됨";
    }

}
