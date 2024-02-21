import express from 'express';
import {ValidateUser} from '../controllers/login.controllers.js'
const loginRouter = express.Router()
//const loginController = require('../controllers/login.controllers');
// Create a new user
loginRouter.post('/login', ValidateUser);

export default loginRouter;