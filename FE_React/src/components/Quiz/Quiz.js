import "./Quiz.css";
import API from "../../requestHttp";
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCheckCircle,
  faCircleXmark,
} from "@fortawesome/free-solid-svg-icons";
function Quiz() {
  const [question, setQuestion] = useState();
  const [answers, setAnswers] = useState();
  const [currentQuestion, setCurrentQuestion] = useState(1);
  console.log(currentQuestion);
  useEffect(() => {
    API.get(`/question:${currentQuestion}`).then((res) => {
      setQuestion(res.data);
      setAnswers(res.data.answers);
    });
  }, []);
  const Select = (index) => {
    const answer = document.getElementsByClassName(`quiz-icon${index}`)[0];
    answer.classList.add("check");
  };
  const Next = () => {
    setCurrentQuestion(currentQuestion + 1);
  };
  const renderAnswer = () => {
    return answers?.map((item, index) => {
      return (
        <span
          className={`option option${index + 1}`}
          key={index}
          onClick={() => Select(item.isCorrect, index + 1)}
        >
          <label>
            <div className={`quiz-icon${index + 1}`}>
              {item.isCorrect ? (
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
            Score : <span id="player-score"></span> / 10
          </h1>
          <h1>
            Question : <span id="question-number"></span> / 10
          </h1>
        </div>

        <div className="game-question-container">
          <h1 id="display-question">{question ? question.text : "loading"}</h1>
        </div>

        <div className="game-options-container">{renderAnswer()}</div>

        <div className="next-button-container">
          <button onClick={Next}>Next Question</button>
        </div>
      </div>
    </div>
  );
}

export default Quiz;
