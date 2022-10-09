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
    let { request } = RequestHttp();
    const [question, setQuestion] = useState();
    const initAnswer = [
        {
            "id": 1,
            "text": "",
            "correct": false
        },
        {
            "id": 2,
            "text": "",
            "correct": false
        },
        {
            "id": 3,
            "text": "",
            "correct": false
        },
        {
            "id": 4,
            "text": "",
            "correct": false
        }
    ]
    const [answers, setAnswers] = useState(
        initAnswer
    );
    // const [currentQuestion, setCurrentQuestion] = useState(1);

    const handleInput = (e) => {
        console.log(e.target)

        console.log(answers);
        var answerTemp = answers;
        answers.map((answer, index) => {
            
        })
    }

    const renderAnswer = () => {
        return (
            <>
                <span
                    className={`option option1`}
                    key={1}
                >
                    <label>
                        <input type="text" className="input-answer" placeholder="Answer 1" onChange={handleInput}></input>
                    </label>
                </span>

                <span
                    className={`option option2`}
                    key={2}
                >
                    <label>
                        <input type="text" className="input-answer" placeholder="Answer 2"></input>
                    </label>
                </span>

                <span
                    className={`option option3`}
                    key={3}
                >
                    <label>
                        <input type="text" className="input-answer" placeholder="Answer 3"></input>
                    </label>
                </span>

                <span
                    className={`option option4`}
                    key={4}
                >
                    <label>
                        <input type="text" className="input-answer" placeholder="Answer 4"></input>
                    </label>
                </span>
            </>

        );

    };
    return (
        <div className="wrapper">
            <div className="game-quiz-container">

                <div className="game-question-container">
                    <input className="input-question" placeholder="Question"></input>
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
