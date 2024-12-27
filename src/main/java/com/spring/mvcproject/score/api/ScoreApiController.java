package com.spring.mvcproject.score.api;

import com.spring.mvcproject.score.dto.request.ScoreCreateDto;
import com.spring.mvcproject.score.entity.Score;
import com.spring.mvcproject.score.routes.ScorePageController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreApiController {
    private Map<Long, Score> scoreStore = new HashMap<>();

    private Long nextId = 1L;
    public ScoreApiController() {
        Score s1 = new Score(nextId++, "김말복", 100, 88, 75);
        Score s2 = new Score(nextId++, "박수포자", 55, 95, 15);
        Score s3 = new Score(nextId++, "김마이클", 4, 100, 40);
        Score s4 = new Score(nextId++,"세종대왕",100,0,90);

        scoreStore.put(s1.getId(), s1);
        scoreStore.put(s2.getId(), s2);
        scoreStore.put(s3.getId(), s3);
        scoreStore.put(s4.getId(), s4);
    }

    // 전체 성적정보 조회
    @GetMapping
    public List<Score> scoreList(
            @RequestParam(required = false,defaultValue = "id") String sort
    ){
        return new ArrayList<>((scoreStore.values()))
                .stream()
                .sorted(getScoreComparator(sort))
                .collect(Collectors.toList());
    }

    private Comparator<Score> getScoreComparator(String sort) {
        Comparator<Score> comparing = null;
        switch(sort){
            case "id":
                comparing = Comparator.comparing(score -> score.getId());
                break;
            case "name":
                comparing = Comparator.comparing(score -> score.getName());
                break;
        }
        return comparing;
    }

    @PostMapping
    public ResponseEntity<?> createScore(
            @RequestBody @Valid ScoreCreateDto dto
            , BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err->{
                errorMap.put(err.getField(),err.getDefaultMessage());
            });
            return ResponseEntity
                    .badRequest()
                    .body(errorMap)
                    ;
        }

        Score score = new Score(dto);
        score.setId(nextId);
        scoreStore.put(nextId++,score);
        return ResponseEntity.ok().body("성적 정보 생성 완료! "+score);
    }
    @DeleteMapping("/{id}")
    public String deleteScore(
            @PathVariable Long id
    ){
        scoreStore.remove(id);
        return "성적 삭제됨";
    }

}
