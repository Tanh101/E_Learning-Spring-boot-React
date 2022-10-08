package com.crossguild.elearning.model.quiz;

import com.crossguild.elearning.model.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Question question;


}
