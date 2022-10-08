import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";


function RequestHttp() {
  const getToken = () => {
    return localStorage.getItem("token");
  };
  const [token, setToken] = useState(getToken());
  const saveToken = (token) => {
    localStorage.setItem("token", JSON.stringify(token));
    setToken(token);
  };

  const request = axios.create({
    baseURL: "http://127.0.0.1:8080/api",
    headers: {
      "Authorization": `Bearer ${token}`,
    },
  });
  return {
    setToken: saveToken,
    token,
    getToken,
    request,
  };
}

export default RequestHttp;
