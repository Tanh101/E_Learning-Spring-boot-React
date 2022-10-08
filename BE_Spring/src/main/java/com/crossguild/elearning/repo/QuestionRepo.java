package com.crossguild.elearning.repo;

import com.crossguild.elearning.dto.quiz.QuestionDTO;
import com.crossguild.elearning.model.quiz.Answer;
import com.crossguild.elearning.model.quiz.Question;
import com.crossguild.elearning.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Question (`id`, `text`, `user_id`) VALUES (:id, :text, :userId);", nativeQuery = true)
    Integer addNewQuestion(@Param("id") Long id, @Param("text") String text, @Param("userId") Long userId);
}
