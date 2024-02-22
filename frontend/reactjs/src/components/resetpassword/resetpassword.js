import React, {useState} from "react";
import "./resetpassword.scss";
import axios from "axios";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom";

function ResetPassword() {
  const [confirmPassword, setConfirmPassword] = useState('');
  const [password, setPassword] = useState('');
  const [otp, setOtp] = useState('');
  const navigate = useNavigate();
 
  const registerUser = () => {
    if(confirmPassword !== password) {
      alert("password and confirm didn't match");
      return false;
    }
    axios.post('http://localhost:4000/api/v1/reset/password', {
      otp,
      password  
    })
    .then(function (response) {
      if(response.status == 200) {
        alert("Successfully reset the password!");
        navigate('/login')
      } else {
        alert("unable to reset the password");
      }
      //console.log(response);
    })
    .catch(function (error) {
      alert("unable to reset the password");
    });
  }
  return (
    <div className="resetpassword-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-4 col-lg-4">
            <div className="bg-color">
              <div className="">
                <h5>Reset your password</h5>
              </div>
              <div className="content-center">
                <div className="form-group">
                  <label htmlFor="Otp-id">OTP</label>
                  <input
                    type="text"
                    className="form-control"
                    id="Otp-id"
                    placeholder="OTP"
                    onChange={(e) => setOtp(e.target.value)}
                  />
                </div>
              <div className="content-center">
                <div className="form-group">
                  <label htmlFor="email-id">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="email-id"
                    placeholder="Password"
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password-id">Confirm Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password-id"
                    placeholder="Confirm Password"
                    onChange={(e) => setConfirmPassword(e.target.value)}
                  />
                </div>
                <div className="form-group">
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
  );
}

export default ResetPassword;
