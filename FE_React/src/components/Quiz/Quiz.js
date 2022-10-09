import "./Quiz.css";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCheckCircle,
  faCircleXmark,
} from "@fortawesome/free-solid-svg-icons";
import RequestHttp from "../../requestHttp";
import Swal from "sweetalert2";
function Quiz() {
  let { request } = RequestHttp();
  const [questions, setQuestions] = useState();
  const [currentQuestion, setCurrentQuestion] = useState(1);
  const [questionNumber, setQuestionNumber] = useState();
  const [checkSelected, setCheckSelected] = useState(false);
  const [myAnswer, setMyAnswer] = useState();
  const [score, setScore] = useState(0);
  useEffect(() => {
    request.get(`/quiz/questions/all`).then((res) => {
      setQuestions(res.data);
      setQuestionNumber(res.data.length);
    });
  }, []);
  const SaveMark = () => {
    
  };
  const Select = (index, isCorrect) => {
    if (!checkSelected) {
      const answer = document.getElementsByClassName(`quiz-icon${index}`)[0];
      answer.classList.add("check");
      setMyAnswer(index);
      setCheckSelected(true);
      if (isCorrect == true) setScore(score + 1);
    }
  };
  const Next = () => {
    if (checkSelected) {
      if (currentQuestion < questionNumber) {
        setCurrentQuestion(currentQuestion + 1);
        const answer = document.getElementsByClassName(
          `quiz-icon${myAnswer}`
        )[0];
        answer.classList.remove("check");
        setCheckSelected(false);
      } else {
        Swal.fire({
          icon: "success",
          title: "Congratulation!",
          text: `My Score ${score}`,
          showDenyButton: true,
          confirmButtonText: "Save",
          denyButtonText: "Do it again",
        }).then((result) => {
          if (result.isConfirmed) {
            SaveMark();
          } else if (result.isDenied) {
            setCurrentQuestion(1);
            setScore(0);
            const answer = document.getElementsByClassName(
              `quiz-icon${myAnswer}`
            )[0];
            answer.classList.remove("check");
            setCheckSelected(false);
          }
        });
      }
    }
  };
  const renderAnswer = () => {
    return questions[currentQuestion - 1].answers?.map((item, index) => {
      return (
        <span
          className={`option option${index + 1}`}
          key={index}
          onClick={() => Select(index + 1, item.correct)}
        >
          <label>
            <div className={`quiz-icon${index + 1}`}>
              {item.correct ? (
                <FontAwesomeIcon className="tick" icon={faCheckCircle} />
              ) : (
                <FontAwesomeIcon className="cross" icon={faCircleXmark} />
              )}
            </div>
            {item.text}
          </label>
        </span>
      );
    });
  };
  return (
    <div className="wrapper">
      <div className="game-quiz-container">
        <div className="game-details-container">
          <h1>
            Question : <span id="question-number">{currentQuestion}</span> /{" "}
            {questionNumber}
          </h1>
        </div>

        <div className="game-question-container">
          <h1 id="display-question">
            {questions ? questions[currentQuestion - 1].text : "loading"}
          </h1>
        </div>

        <div className="game-options-container">
          {questions ? renderAnswer() : "loading"}
        </div>

        <div className="next-button-container">
          <button onClick={Next}>Next Question</button>
        </div>
      </div>
    </div>
  );
}

export default Quiz;
