package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Quiz (`create_date`, `title`, `user_id`) VALUES (:createDate, :text, :userId);", nativeQuery = true)
    Integer addNewQuiz(@Param("createDate") LocalDateTime createDate, @Param("text") String text, @Param("userId") Long userId);
}
