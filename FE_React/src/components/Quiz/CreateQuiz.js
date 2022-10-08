import React, { useState } from 'react'
import QuizItem from './QuizItem'
import './CreateQuiz.css'

const [quizzes, setQuizzes] = useState(

)

function CreateQuiz() {
    const addQuizHandle = () {

    }
    return (
        <div className='quiz-create'>
            {quizzes.map((quiz, index) => {
                return (
                    <div className='item' key={index}>
                        <QuizItem
                            question={quiz.question}
                            answers={quiz.question.answers}
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

export default CreateQuiz