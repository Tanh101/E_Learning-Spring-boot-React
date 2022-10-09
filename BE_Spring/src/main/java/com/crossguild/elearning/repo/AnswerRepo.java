package com.crossguild.elearning.repo;

import com.crossguild.elearning.model.quiz.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {
    List<Answer> getAnswerByQuestionId(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Answer (`id`, `is_correct`, `text`, `question_id`) VALUES (:id, :isCorrect, :text, :userId);",
            nativeQuery = true)
    Integer addNewAnswer(@Param("id") Long id, @Param("isCorrect") Boolean isCorrect,
                         @Param("text") String text, @Param("userId") Long userId);
}
