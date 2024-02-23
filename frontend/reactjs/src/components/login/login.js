import React, { useState } from "react";
import "./login.scss";
import axios from "axios";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const registerUser = () => {
    axios
      .post("http://localhost:4000/api/v1/user/login", {
        email,
        password
      })
      .then(function(response) {
        if(response.status == 200) {
          navigate("/addemployee");
        } else {
          alert("Unable to login this time, please try again later");
        }
      })
      .catch(function(error) {
        alert("Unable to login this time, please try again later");
      });
  };
  return (
    <div className="login-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-4 col-lg-4">
            <div className="bg-color">
              <div className="">
                <h5>Login</h5>
              </div>
              <div className="content-center">
                <div className="form-group">
                  <label htmlFor="email-id">Email</label>
                  <input
                    type="text"
                    className="form-control"
                    id="email-id"
                    placeholder="Email"
                    onChange={e => setEmail(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password-id">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password-id"
                    placeholder="Password"
                    onChange={e => setPassword(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <button
                    type="button"
                    className="btn btn-primary btn-md btn-block"
                    onClick={() => registerUser()}
                  >
                    Login
                  </button>
                  <div className="sign-up">
                    <Link to="/registration">Sign UP</Link>
                  </div>
                  <div className="forgot-password">
                    <Link to="/forgotpassword">Forgot Password?</Link>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div />
    </div>
  );
}

export default Login;
