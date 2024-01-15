import React, {useState, useEffect} from "react";
import "./login.scss";
import axios from "axios";

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const registerUser = () => {
    axios.post('http://localhost:8080/authenticate', {
      email,
      password  
    })
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.log(error);
    });
  }
  return (
    <div className="registration-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-5 col-lg-5">
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
                    onChange={(e) => setEmail(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password-id">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password-id"
                    placeholder="Password"
                    onChange={(e) => setPassword(e.target.value)}
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
