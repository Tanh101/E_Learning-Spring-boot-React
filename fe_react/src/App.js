import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import DefaultLayout from "./components/Layout/DefaultLayout/DefaultLayout";
import AddLesson from "./pages/AddLesson/AddLesson";
import Home from "./pages/Home";
import Lesson from "./pages/Lesson";
import Login from "./pages/Login";
import Register from "./pages/Register";
import SlideEdit from "./pages/SlideEdit";

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
            path="/addLesson"
            element={
              <DefaultLayout>
                <AddLesson />
              </DefaultLayout>
            }
          />
          <Route path="/login" element={<Login />}></Route>
          <Route path="/register" element={<Register />}></Route>
          <Route
            path="/slide/edit"
            element={
              <DefaultLayout>
                <SlideEdit />
              </DefaultLayout>
            }
          />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
