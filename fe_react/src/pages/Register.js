import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import loginBackground from "../images/login-background.jpg";
import RequestHttp from '../requestHttp';

function Register() {
    let { request } = RequestHttp();
    const navigate = useNavigate();
    const [dataForm, setDataForm] = useState({
        "fullName": "",
        "username": "",
        "email": "",
        "password": "",
        "roles": ""
    });
    const registerSubmit = (e) => {
        e.preventDefault()
        const _dataForm = new FormData();
        _dataForm.append("fullName", dataForm.username);
        _dataForm.append("username", dataForm.username);
        _dataForm.append("email", dataForm.email);
        _dataForm.append("password", dataForm.password);
        _dataForm.append("roles", dataForm.roles);
        console.log(_dataForm);
        request.post("/auth/register", _dataForm).then((res) => {
            if (res.status === 200) {
                console.log(res);
            }
        });
        // navigate('/')
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

                    <div className="wrap-login100 p-l-30 p-r-30 p-t-30 p-b-30">
                        <Link to="/" className="tx2 previous">
                            Back
                        </Link>
                        <form className="login100-form validate-form">

                            <span className="login100-form-title p-b-15">
                                Register
                            </span>

                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                                <span className="label-input100">Full Name</span>
                                <input className="input100" type="text" name="fullName" placeholder="Type your full name"
                                    onChange={(e) => setDataForm({ ...dataForm, "fullName": e.target.value })} />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>
                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                                <span className="label-input100">Username</span>
                                <input className="input100" type="text" name="username" placeholder="Type your username"
                                    onChange={(e) => setDataForm({ ...dataForm, "username": e.target.value })} />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>
                            <div className="wrap-input100 validate-input m-b-23" data-validate="Username is required">
                                <span className="label-input100">Email</span>
                                <input className="input100" type="email" name="email" placeholder="Type your email"
                                    onChange={(e) => setDataForm({ ...dataForm, "email": e.target.value })} />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>

                            <div className="wrap-input100 validate-input" data-validate="Password is required">
                                <span className="label-input100">Password</span>
                                <input className="input100" type="password" name="pass" placeholder="Type your password"
                                    onChange={(e) => setDataForm({ ...dataForm, "password": e.target.value })} />
                                <span className="focus-input100" data-symbol=""></span>
                            </div>
                            <div className="p-t-20 dis-flex" >
                                <div className='m-l-50 m-r-50'>
                                    <input className="input10" type="radio" name="radio-role"
                                        onChange={(e) => setDataForm({ ...dataForm, "roles": "ROLE_TEACHER" })} />
                                    <label htmlFor="radio-role" className="label-input100">Teacher</label>
                                </div>
                                <div className='m-l-50 m-r-50'>
                                    <input className="input10" type="radio" name="radio-role"
                                        onChange={(e) => setDataForm({ ...dataForm, "roles": "ROLE_USER" })} />
                                    <label htmlFor="radio-role" className="label-input100">Student</label>
                                </div>
                            </div>



                            <div className="container-login100-form-btn p-t-20">
                                <div className="wrap-login100-form-btn">
                                    <div className="login100-form-bgbtn"></div>
                                    <button className="login100-form-btn" onClick={registerSubmit}>
                                        Register
                                    </button>
                                </div>
                            </div>
                            <div className="text-center p-t-8 p-b-15">
                                <Link to="/login">
                                    Already have account ? Login
                                </Link>
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