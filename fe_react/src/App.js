import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import CardKanji from "./components/CardKanji/CardKanji";
import CreateSlide from "./components/CreateSlide/CreateSlide";
import DefaultLayout from "./components/Layout/DefaultLayout/DefaultLayout";
import MultiCardKaji from "./components/MultiCardKanji/MultiCardKanji";
import Quiz from "./components/Quiz/Quiz";
import AddLesson from "./pages/AddLesson/AddLesson";
import Admin from "./pages/Admin/Admin";
import Home from "./pages/Home";
import Lesson from "./pages/Lesson";
import Login from "./pages/Login";
import Register from "./pages/Register";

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
          <Route path="/card" element={<CardKanji />}></Route>
          <Route path="/multiCard" element={<MultiCardKaji />}></Route>
          <Route path="/quiz" element={<Quiz />}></Route>
          <Route path="/admin" element={<Admin />}></Route>

        </Routes>
      </div>
    </Router>
  );
}

export default App;
