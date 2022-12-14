import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import RequestHttp from "../requestHttp";
import "./Login.css"
import "./util.css"
import loginBackground from "../images/login-background.jpg";

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
            axios.post("http://localhost:8080/api/auth/login", _formData).then((res) => {
                console.log(res.data);
                if (res.status === 200) {
                    localStorage.setItem("token", res.data.token);
                    console.log(res.data);
                    navigate("/");
                }
            });
        }
    };
    return (
        <div className="Login" style={{
            width: "100vw",
            height: "100vh",
            backgroundImage: `url(${loginBackground})`,
            backgroundRepeat: "no-repeat",
            backgroundSize: "cover",
            backgroundPosition: "center",
        }}>
            <div className="limiter">
                <div className="container-login100" >

                    <div className="wrap-login100 p-l-30 p-r-30 p-t-35 p-b-30">
                        <Link to="/" className="tx2 previous">
                            Back
                        </Link>
                        <form className="login100-form validate-form">

                            <span className="login100-form-title p-b-49">
                                Login
                            </span>

                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                                <span className="label-input100">Username</span>
                                <input className="input100" type="text" name="username" placeholder="Type your username" onChange={(e) => {setUsername(e.target.value)}}/>
                                <span className="focus-input100" data-symbol=""></span>
                            </div>

                            <div className="wrap-input100 validate-input" data-validate="Password is required">
                                <span className="label-input100">Password</span>
                                <input className="input100" type="password" name="pass" placeholder="Type your password" onChange={(e) => {setPassword(e.target.value)}}/>
                                <span className="focus-input100" data-symbol=""></span>
                            </div>

                            <div className="text-right p-t-8 p-b-31">
                                <Link to="#">
                                    Forgot password?
                                </Link>
                            </div>

                            <div className="container-login100-form-btn">
                                <div className="wrap-login100-form-btn">
                                    <div className="login100-form-bgbtn"></div>
                                    <button className="login100-form-btn" onClick={loginSubmit}>
                                        Login
                                    </button>
                                </div>
                            </div>
                            <div className="flex-col-c p-t-155">
                                <Link to="/register" className="txt2">
                                    Register
                                </Link>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <div id="dropDownSelect1"></div>
        </div>

    );
}

export default Login;
