import express from 'express';
import {genrateRandomToken} from '../controllers/employee.controllers.js'
const forgotRouter = express.Router()
forgotRouter.post('/employee', genrateRandomToken);
forgotRouter.post('/employee', genrateRandomToken);

export default forgotRouter;