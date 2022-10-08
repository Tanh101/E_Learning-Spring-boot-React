import { Button } from "bootstrap";
import { Link } from "react-router-dom";
import "./Navbar.css";
import { useEffect } from "react";

function Navbar() {
  useEffect(() => {
    document.querySelector('.navbar').classList.remove('mask-custom');
  });
  const contents = [
    {
      name: "Home",
      href: "/",
    },
    {
      name: "List",
      href: "/list",
    },
    {
      name: "Create",
      href: "/addLesson",
    },
  ];
  const renderContent = () => {
    return contents.map((item, index) => {
      return (
        <li key={index} className="nav-item">
          <Link className="nav-link" to={item.href} style={{ color: "#fff" }}>
            {item.name}
          </Link>
        </li>
      );
    });
  };

  return (
    <header>
      <nav className="navbar navbar-expand-lg navbar-light fixed-top shadow-0">
        <div className="container">
          <a className="navbar-brand" href="#!">
            <span style={{ color: "#33FF99", fontWeight: "bold" }}>
              Restaurant
            </span>
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-mdb-toggle="collapse"
            data-mdb-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i className="fas fa-bars"></i>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto">{renderContent()}</ul>
            <ul className="navbar-nav d-flex flex-row">
              <li className="nav-item me-3 me-lg-0">
                <Link
                  className="btn btn-outline-success"
                  to="/register"
                  style={{ margin: "5px", width: "100px" }}
                >
                  Register
                </Link>
              </li>
              <li className="nav-item me-3 me-lg-0">
                <Link
                  className="btn btn-success"
                  to="/login"
                  style={{ margin: "5px", width: "100px" }}
                >
                  Login
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
