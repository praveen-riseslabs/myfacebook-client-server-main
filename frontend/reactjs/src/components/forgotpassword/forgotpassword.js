import React, { useState } from "react";
import "./forgotpassword.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Forgotpassword() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const registerUser = () => {
    axios
      .post("http://localhost:4000/api/v1/forgot/password", {
        email
      })
      .then(function(response) {
        if(response.status == 200) {
          alert("OTP Sent your email address");
          navigate('/resetpassword')
        } else {
          alert("We are unable to send OTP this time or registed email id not found in our system.");
        }
      })
      .catch(function(error) {
        alert("We are unable to send OTP this time or registed email id not found in our system.");
      });
  };
  return (
    <div className="forgotpassword-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-4 col-lg-4">
            <div className="bg-color">
              <div className="">
                <h5>Forgot Password?</h5>
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
                  <div className="row">
                    <div className="col-md-6">
                      <button
                        type="button"
                        className="btn btn-secondary btn-md btn-block"
                        onClick={() => navigate("/login")}
                      >
                        Cancel
                      </button>
                    </div>
                    <div className="col-md-6">
                      <button
                        type="button"
                        className="btn btn-primary btn-md btn-block"
                        onClick={() => registerUser()}
                      >
                        Submit
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Forgotpassword;
