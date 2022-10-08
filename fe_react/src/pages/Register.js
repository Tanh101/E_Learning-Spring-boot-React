import React from 'react'
import { Link, useNavigate } from 'react-router-dom'
import loginBackground from "../images/login-background.jpg";

function Register() {
    const navigate = useNavigate();
    const registerSubmit = () => {
        navigate('/')
    }
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
                                Register
                            </span>

                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                                <span className="label-input100">Username</span>
                                <input className="input100" type="text" name="username" placeholder="Type your username" />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>
                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is reauired">
                                <span className="label-input100">Email</span>
                                <input className="input100" type="email" name="email" placeholder="Type your username" />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>

                            <div className="wrap-input100 validate-input" data-validate="Password is required">
                                <span className="label-input100">Password</span>
                                <input className="input100" type="password" name="pass" placeholder="Type your password" />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>

                            <div className="text-center p-t-8 p-b-31">
                                <Link to="/login">
                                    Already have account ? Login
                                </Link>
                            </div>

                            <div className="container-login100-form-btn">
                                <div className="wrap-login100-form-btn">
                                    <div className="login100-form-bgbtn"></div>
                                    <button className="login100-form-btn">
                                        Register
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <div id="dropDownSelect1"></div>
        </div>

    )
}

export default Register