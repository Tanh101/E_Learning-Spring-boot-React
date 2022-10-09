import { Link } from "react-router-dom";
import Navbar from "../../components/Navbar/Navbar";
import "./Admin.css";
function Admin({ children }) {
  return (
    <div className="wrapper-admin">
      <Navbar />
      <div className="container-admin">
        <aside className="wrapper-sidebar">
          <div className="sidebar-admin">
            <div className="sidebar-admin-item">
              <Link
                to="/admin"
                style={{ width: "200px", color: "white" }}
                className="btn btn-info btn-lg btn-block"
              >
                Admin
              </Link>
            </div>
            <div className="sidebar-admin-item">
              <Link
                to="/showscore"
                style={{ width: "200px", color: "white" }}
                className="btn btn-info btn-lg btn-block"
              >
                Show Score
              </Link>
            </div>
            <div className="sidebar-admin-item">
              <Link
                to="/createquiz"
                style={{ width: "200px", color: "white" }}
                className="btn btn-info btn-lg btn-block"
              >
                Create Quiz
              </Link>
            </div>
          </div>
        </aside>
        <div className="content-admin">
          {children ? children : "Welcome to Admin"}
        </div>
      </div>
    </div>
  );
}

export default Admin;
