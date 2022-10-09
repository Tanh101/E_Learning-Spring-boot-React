package com.crossguild.elearning.dto.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Long id;
    private Boolean isCorrect;
    private String text;
    private Long questionId;
}
