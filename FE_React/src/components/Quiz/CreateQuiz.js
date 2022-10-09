import React, { useState } from 'react'
import QuizItem from './QuizItem'
import './CreateQuiz.css'



function CreateQuiz() {
    const initialQuizzes = [
        {
            "question": {
                "id": 1,
                "text": "どの大学が一東証ですか",
                "answers": [
                    {
                        "id": 1,
                        "text": "DUT",
                        "correct": true
                    },
                    {
                        "id": 2,
                        "text": "HUST",
                        "correct": false
                    },
                    {
                        "id": 3,
                        "text": "UIT",
                        "correct": false
                    },
                    {
                        "id": 4,
                        "text": "UET",
                        "correct": false
                    },
                ]
            },
        }
    ]
    const [quizzes, setQuizzes] = useState(initialQuizzes)
    const addQuizHandle = () => {
        setQuizzes((prevQuizzes) => [
            ...prevQuizzes,
            {
                "question": {
                    "id": 1,
                    "text": "どの大学が一東証ですか",
                    "answers": [
                        {
                            "id": 1,
                            "text": "DUT",
                            "correct": true
                        },
                        {
                            "id": 2,
                            "text": "HUST",
                            "correct": false
                        },
                        {
                            "id": 3,
                            "text": "UIT",
                            "correct": false
                        },
                        {
                            "id": 4,
                            "text": "UET",
                            "correct": false
                        },
                    ]
                }
            }
        ])
    }
    return (
        <div className='quiz-create'>
            {quizzes.map((quiz, index) => {
                return (
                    <div className='item' key={index}>
                        <QuizItem
                            question={quiz.question}
                            answers={quiz.question.answers}
                            onChange={setQuizzes}
                        />
                    </div>
                )
            })}
            <div className='add-quiz'>
                <button type="button" className="btn btn-outline-primary" onClick={addQuizHandle}>Add</button>
            </div>
        </div>
    )
}

export default CreateQuiz;
