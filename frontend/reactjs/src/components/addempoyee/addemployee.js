import React, { useState, useEffect } from "react";
import "./addemployee.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function AddEmployeeRecords() {
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
                />
              </div>
            </div>
            <div className="row">
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
