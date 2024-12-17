package com.spring.mvcproject.score.entity;

import lombok.*;

//학생 한명의 성적정보를 저장
@Getter @Setter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Score {
    private Long id;
    private String name;
    private int kor, eng, math;
}
