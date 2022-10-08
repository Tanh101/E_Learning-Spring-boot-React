import React, { useState } from "react";
import QuizItem from "./QuizItem";
import "./CreateQuiz.css";

function CreateQuiz() {
  const [quizzes, setQuizzes] = useState();
  const addQuizHandle = () => {};
  return (
    <div className="quiz-create">
      {quizzes.map((quiz, index) => {
        return (
          <div className="item" key={index}>
            <QuizItem
              question={quiz.question}
              answers={quiz.question.answers}
            />
          </div>
        );
      })}
      <div className="add-quiz">
        <button
          type="button"
          className="btn btn-outline-primary"
          onClick={addQuizHandle}
        >
          Add
        </button>
      </div>
    </div>
  );
}

export default CreateQuiz;
