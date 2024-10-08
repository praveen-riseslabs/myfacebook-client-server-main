import React, {useState} from "react";
import "./registration.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Registration() {
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [phonenumber, setPhonenumber] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const registerUser = () => {
    axios.post('http://localhost:4000/api/v1/create', {
      firstname,
      lastname,
      email,
      phonenumber,
      password  
    })
    .then(function (response) {
      if(response.status == 200) {
        alert("user created successfully")
        navigate("/login");
      } else {
       alert("Fail to create user");
      }
      
    })
    .catch(function (error) {
      alert("Fail to create user");
    });
  }
  function handleClick() {
    navigate("/login");
  }
  return (
    <div className="registration-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-4 col-lg-4">
            <div className="bg-color">
              <div className="">
                <h5>Registration</h5>
              </div>
              <div className="content-center">
                <div className="form-group">
                  <label htmlFor="first-name">First Name</label>
                  <input
                    type="text"
                    className="form-control"
                    id="first-name"
                    placeholder="First Name"
                    onChange={(e)=> setFirstname(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="last-name">Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    id="last-name"
                    placeholder="Last Name"
                    onChange={(e)=> setLastname(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="email-id">Email</label>
                  <input
                    type="text"
                    className="form-control"
                    id="email-id"
                    placeholder="Email"
                    onChange={(e)=> setEmail(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="phone-id">Phone</label>
                  <input
                    type="number"
                    className="form-control"
                    id="phone-id"
                    placeholder="Phone"
                    onChange={(e)=> setPhonenumber(e.target.value)}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password-id">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password-id"
                    placeholder="Password"
                    onChange={(e)=> setPassword(e.target.value)}
                  />
                </div>
                <div className="row">
                  <div className="col col-md-6"><button
                    type="button"
                    className="btn btn-secondary btn-md btn-block"
                    onClick={()=> handleClick()}
                  >
                    Cancel
                  </button></div>
                  <div className="col col-md-6"><button
                    type="button"
                    className="btn btn-primary btn-md btn-block"
                    onClick={() => registerUser()}
                  >
                    Submit
                  </button></div>
                  
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

export default Registration;
