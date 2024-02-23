import React, { useState, useEffect } from "react";
import "./employee.scss";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function GetEmployeeRecords() {
  const navigate = useNavigate();
  const [data, setData] = useState([]);
  const token = JSON.parse(localStorage.getItem('userinfo')).data.token
  axios.defaults.headers.common = {
      'Authorization': 'Bearer ' + token
  };
  useEffect(()=> {
    axios.get("http://localhost:4000/api/v1/emp/getEmployeeDetails").then(function(response) {
        if(response.status == 200) {
            setData(response.data);
        //  alert("OTP Sent your email address");
        //  navigate('/resetpassword')
        } else {
        //  alert("We are unable to send OTP this time or registed email id not found in our system.");
        }
      }).catch(function(error) {
        //alert("We are unable to send OTP this time or registed email id not found in our system.");
      });
  }, [])

  return (
    <div className="employee-main">
         <table border="1">
            <tr>
                <td>Emp Id</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Email</td>
                <td>Phone</td>
                <td>Designation</td>
                <td>Primary Skills</td>
            </tr>
             {data.map((item) => {return (<tr>
                <td>{item.empId}</td>
                <td>{item.firstname}</td>
                <td>{item.lasttname}</td>
                <td>{item.email}</td>
                <td>{item.phone}</td>
                <td>{item.designation}</td>
                <td>{item.primaryskill}</td>
            </tr>)})}
        </table>
        <div className="row">
        <div className="col-md-6">
                <div className="form-group">
                    <button className="btn btn-secondary" onClick={()=>navigate("/addemployee")}>Add new record</button>
                </div>
              </div>
        </div>
    </div>
  );
}

export default GetEmployeeRecords;
