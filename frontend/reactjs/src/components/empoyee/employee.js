import React, { useState, useEffect } from "react";
import "./employee.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function GetEmployeeRecords() {
  const navigate = useNavigate();
  useEffect(()=> {
    axios.get("http://localhost:4000/api/v1/getemployee", {
        email
      }).then(function(response) {
        if(response.status == 200) {
          alert("OTP Sent your email address");
          navigate('/resetpassword')
        } else {
          alert("We are unable to send OTP this time or registed email id not found in our system.");
        }
      }).catch(function(error) {
        alert("We are unable to send OTP this time or registed email id not found in our system.");
      });
  }, [])

  return (
    <div className="employee-main">
         <table>
            <tr>
                <td>Emp Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Designation</td>
                <td>Primary Skills</td>
            </tr>
             <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
  );
}

export default GetEmployeeRecords;
