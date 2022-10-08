import { Button } from "bootstrap";
import { Link } from "react-router-dom";
import style from "./Navbar.css";

import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { hover } from "@testing-library/user-event/dist/hover";
import logo from "../../images/logo.png";
import ProfileMenu from "./ProfileMenu";
import RequestHttp from "../../requestHttp";

function Navbar() {
  const [user, setUser] = useState("user");
  let { request } = RequestHttp();
  useEffect(() => {
    document.querySelector(".navbar").classList.remove("mask-custom");
  });
  useEffect(() => {
    request.get("/auth/login").then((res) => {});
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
      href: "/create",
    },
    {
      name: "Card",
      href: "/multiCard",
    },
    {
      name: "Quiz",
      href: "/quiz",
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
      <nav className="navbar navbar-expand-lg navbar-light fixed-top mask-custom shadow-0 p-0">
        <div className="container">
          <Link className="navbar-brand" to="/">
            <img src={logo} style={{ height: "45px", padding: "2px" }} />
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-mdb-toggle="collapse"
            data-mdb-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            =
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto">
              {renderContent()}
              <li className="nav-item">
                <div className="searchbar">
                  <input
                    className="search_input"
                    type="text"
                    placeholder="Search..."
                  />
                  <button className="search_btn">
                    <FontAwesomeIcon icon={faSearch} />
                  </button>
                </div>
              </li>
            </ul>

            {!user ? (
              <ul className="navbar-nav d-flex flex-row">
                <li className="nav-item me-3 me-lg-0">
                  <Link
                    className="btn btn-outline-success"
                    to="/register"
                    style={{ margin: "0 5px", width: "100px" }}
                  >
                    Register
                  </Link>
                </li>
                <li className="nav-item me-3 me-lg-0">
                  <Link
                    className="btn btn-success"
                    to="/login"
                    style={{ margin: "0 5px", width: "100px" }}
                  >
                    Login
                  </Link>
                </li>
              </ul>
            ) : (
              <div className="navbar-nav d-flex flex-row">
                <ProfileMenu />
              </div>
            )}
          </div>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
