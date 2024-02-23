import React, { useState, useEffect } from "react";
import "./addemployee.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function AddEmployeeRecords() {
  const [email, setEmail] = useState("");
  const [empId, setEmpId] = useState("");
  const [firstname, setFirstname] = useState("");
  const [lastname, setLastname] = useState("");
  const [designation, setDesignation] = useState("");
  const [skillset, setSkillset] = useState("");
  const [phone, setPhone] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    // axios
    //   .get("http://localhost:4000/api/v1/getemployee", {
    //    // email
    //   })
    //   .then(function(response) {
    //     if (response.status == 200) {
    //       alert("OTP Sent your email address");
    //       navigate("/resetpassword");
    //     } else {
    //       alert(
    //         "We are unable to send OTP this time or registed email id not found in our system."
    //       );
    //     }
    //   })
    //   .catch(function(error) {
    //     alert(
    //       "We are unable to send OTP this time or registed email id not found in our system."
    //     );
    //   });
  }, []);

  const AddEmployee = () => {
    if(!email.length &&
      !phone.length &&
      !firstname.length &&
      !lastname.length &&
      !designation.length &&
      !skillset.length &&
      !empId.length) {
         alert("alert fields are mandatory");
         return false;
      }
    const token = JSON.parse(localStorage.getItem('userinfo')).data.token
    axios.defaults.headers.common = {
        'Authorization': 'Bearer ' + token
    };
    axios
    .post("http://localhost:4000/api/v1/emp/addEmpDetails", {
      email,
      phone,
      firstname,
      lastname,
      designation,
      skillset,
      empId
    })
    .then(function(response) {
      if(response.status == 200) {
        localStorage.setItem('userinfo', JSON.stringify(response))
        navigate("/addemployee");
      } else {
        alert("Unable to login this time, please try again later");
      }
    })
    .catch(function(error) {
      alert("Unable to login this time, please try again later");
    });
  }

  return (
    <div className="addemployee-main">
      <div className="justify-content-md-center ">
        <div className="bg-color">
          <div className="row">
            <div className="col-md-6">
              <div className="form-group">
                <label for="empid">Emp Id</label>
                <input
                  type="text"
                  className="form-control"
                  id="empid"
                  placeholder="Enter emp Id"
                  onChange={e => setEmpId(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="firstname">First Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="firstname"
                  placeholder="Enter First Name"
                  onChange={e => setFirstname(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="lastname">Last Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="lastname"
                  placeholder="Enter Last Name"
                  onChange={e => setLastname(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="email">Email</label>
                <input
                  type="text"
                  className="form-control"
                  id="email"
                  placeholder="Enter Email"
                  onChange={e => setEmail(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="phone">Phone</label>
                <input
                  type="text"
                  className="form-control"
                  id="phone"
                  placeholder="Enter Phone Number"
                  onChange={e => setPhone(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="designatrion">Designation</label>
                <input
                  type="text"
                  className="form-control"
                  id="designatrion"
                  placeholder="Enter Designation"
                  onChange={e => setDesignation(e.target.value)}
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="form-group">
                <label for="primaryskills">Primary Skills</label>
                <input
                  type="text"
                  className="form-control"
                  id="primaryskills"
                  placeholder="Enter primary skill"
                  onChange={e => setSkillset(e.target.value)}
                />
              </div>
            </div>
            <div className="row">
              <div className="col-md-6">
                <div className="form-group">
                    <button className="btn btn-secondary" onClick={()=>navigate("/showempdetails")}>Show Details</button>
                </div>
              </div>
              <div className="col-md-6">
                <div className="form-group">
                    <button className="btn btn-primary" onClick={()=>AddEmployee()}>Submit</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AddEmployeeRecords;
