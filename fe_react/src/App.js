import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CardKanji from "./components/CardKanji/CardKanji";
import CreateSlide from "./components/CreateSlide/CreateSlide";
import DefaultLayout from "./components/Layout/DefaultLayout/DefaultLayout";
import MultiCardKaji from "./components/MultiCardKanji/MultiCardKanji";
import CreateQuiz from "./components/Quiz/CreateQuiz";
import Quiz from "./components/Quiz/Quiz";
import AddLesson from "./pages/AddLesson/AddLesson";
import Admin from "./pages/Admin/Admin";
import Home from "./pages/Home";
import Lesson from "./pages/Lesson";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ShowScore from "./pages/ShowScore/ShowScore";

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route
            path="/"
            element={
              <DefaultLayout>
                <Home />
              </DefaultLayout>
            }
          />
          <Route
            path="/restaurant/:id"
            element={
              <DefaultLayout>
                <Lesson />
              </DefaultLayout>
            }
          />
          <Route
            path="/create"
            element={
              <DefaultLayout>
                <CreateSlide />
              </DefaultLayout>
            }
          />
          <Route
            path="/createlesson"
            element={
              <DefaultLayout>
                <AddLesson />
              </DefaultLayout>
            }
          />
          <Route path="/login" element={<Login />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route
            path="/multiCard"
            element={
              <DefaultLayout>
                <MultiCardKaji />
              </DefaultLayout>
            }
          ></Route>
          <Route
            path="/quiz"
            element={
              <DefaultLayout>
                <Quiz />
              </DefaultLayout>
            }
          ></Route>
          <Route path="/createquiz" element={<CreateQuiz />}></Route>
          <Route path="/admin" element={<Admin />}></Route>
          <Route
            path="/showscore"
            element={
              <Admin>
                <ShowScore />
              </Admin>
            }
          ></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
