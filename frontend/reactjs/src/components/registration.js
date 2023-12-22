import React from "react";
import "./registration.scss";

function Registration() {
  return (
    <div className="registration-main">
      <div className="container align-middle">
        <div className="row justify-content-md-center">
          <div className="col col-md-5 col-lg-5">
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
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="last-name">Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    id="last-name"
                    placeholder="Last Name"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="email-id">Email</label>
                  <input
                    type="text"
                    className="form-control"
                    id="email-id"
                    placeholder="Email"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="phone-id">Phone</label>
                  <input
                    type="number"
                    className="form-control"
                    id="phone-id"
                    placeholder="Phone"
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password-id">Password</label>
                  <input
                    type="text"
                    className="form-control"
                    id="password-id"
                    placeholder="Password"
                  />
                </div>
                <div className="form-group">
                  <button
                    type="button"
                    className="btn btn-primary btn-md btn-block"
                  >
                    Submit
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

export default Registration;
