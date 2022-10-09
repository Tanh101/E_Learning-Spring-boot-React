package com.crossguild.elearning.model.quiz;

import com.crossguild.elearning.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    private float point;

    private LocalDateTime completedDate;




}
