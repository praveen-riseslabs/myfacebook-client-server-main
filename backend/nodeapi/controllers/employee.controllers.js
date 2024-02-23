import Employee from "../models/employee.model.js";
// Retrieve and return all Employees from the database.
export const findAll = (req, res) => {
  Employee.find()
    .then(Employees => {
      res.send(Employees);
    })
    .catch(err => {
      res.status(500).send({
        message:
          err.message || "Something went wrong while getting list of Employees."
      });
    });
};
// Create and Save a new Employee
export const addEmployeeRecord = (req, res) => {
  // Validate request
  if (!req.body) {
    return res.status(400).send({
      message: "Please fill all required field"
    });
  }
  const Employee = new Employee({
    empId: req.body.empId,
    firstname: req.body.firstname,
    lastname: req.body.lastname,
    phone: req.body.phone,
    designation: req.body.designation,
    phone: req.body.phone,
    primaryskill: req.body.primaryskill
  });
  // Save Employee in the database
  Employee.save().then(data => {
      res.send(data);
    }).catch(err => {
      res.status(500).send({
        message: err.message || "Something went wrong while creating new Employee."
      });
    });
};

