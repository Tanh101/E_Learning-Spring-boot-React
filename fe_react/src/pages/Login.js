import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import RequestHttp from "../requestHttp";

function Login() {
  let { request } = RequestHttp();
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();
  const navigate = useNavigate();
  const loginSubmit = (e) => {
    e.preventDefault();
    if (username !== "" && password !== "") {
      const _formData = new FormData();
      _formData.append("username", username);
      _formData.append("password", password);
      request.post("/auth/login", _formData).then((res) => {
        if (res.status === 200) {
          localStorage.setItem("token", res.data.token);
          // navigate("/");
        }
      });
    }
  };
  return (
    <div className="Login" style={{ width: "100vw", height: "100vh" }}>
      <div className="container py-5">
        <div className="row justify-content-center d-flex">
          <div className="col-md-6">
            <div className="card">
              <div className="card-header">
                <h4 className="text-2xl font-bold leading-7 text-gray-900 sm:text-3xl sm:truncate">
                  Login
                  <Link
                    to={"/"}
                    className="btn btn-primary justify-center py-2 px-4 border float-end"
                  >
                    Back
                  </Link>
                </h4>
              </div>
              <div className="card-body">
                <form className="form-login" onSubmit={loginSubmit}>
                  <div className="grid grid-cols-2 gap-6">
                    <div className="col-span-3 sm:col-span-2">
                      <label className="block text-sm font-medium text-gray-700">
                        Username
                      </label>
                      <div className="my-1 flex rounded-md shadow-sm">
                        <input
                          name="username"
                          type="text"
                          className="form-control focus:ring-indigo-500 focus:border-indigo-500 flex-1 block w-full rounded-md sm:text-sm border-gray-300"
                          onChange={(e) => setUsername(e.target.value)}
                        />
                      </div>
                      <span className="text-sm font-medium text-danger">
                        {}
                      </span>
                      <label className="block text-sm font-medium text-gray-700">
                        Password
                      </label>
                      <div className="mt-1 flex rounded-md shadow-sm">
                        <input
                          name="password"
                          type="password"
                          className="form-control focus:ring-indigo-500 focus:border-indigo-500 flex-1 block w-full rounded-md sm:text-sm border-gray-300"
                          onChange={(e) => setPassword(e.target.value)}
                        />
                      </div>
                      <span className="text-sm font-medium text-danger">
                        {}
                      </span>
                      <div className="form-group ">
                        <button
                          type="submit"
                          className="btn btn-primary justify-center py-2 px-4 border mt-3 float-end"
                        >
                          Login
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
