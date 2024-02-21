import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.css';
import './global.scss';
import Registration from './components/registration/registration';
import Login from './components/login/login';
import Forgotpassword from './components/forgotpassword/forgotpassword';
import ResetPassword from './components/resetpassword/resetpassword';
import { BrowserRouter, Routes, Route } from "react-router-dom";


export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route>
          <Route path="/login" element={<Login />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/forgotpassword" element={<Forgotpassword />}/>
          <Route path="/resetpassword" element={<ResetPassword />}/>
          <Route path="*" element={<Login />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
