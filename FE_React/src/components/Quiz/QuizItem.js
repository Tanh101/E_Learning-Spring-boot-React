import "./Quiz.css";
import "./QuizItem.css"
import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faCheckCircle,
    faCircleXmark,
} from "@fortawesome/free-solid-svg-icons";
import RequestHttp from "../../requestHttp";

function QuizItem(props) {
    useEffect(() => {
        setQuestion(props.question);
        setAnswers(props.answers);
    },[])
    let { request } = RequestHttp();
    const [question, setQuestion] = useState();
    const [answers, setAnswers] = useState();
    // const [currentQuestion, setCurrentQuestion] = useState(1);

    const renderAnswer = () => {
        return answers?.map((item, index) => {
            return (
                <span
                    className={`option option${index + 1}`}
                    key={index}
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

                <div className="game-question-container">
                    <h1 id="display-question">{question ? question.text : "loading"}</h1>
                </div>

                <div className="delete-btn">
                    <FontAwesomeIcon className="fa-times" icon={faCircleXmark} />
                </div>

                <div className="game-options-container">{renderAnswer()}</div>

            </div>
        </div>
    );
}

export default QuizItem;
