import React from "react";
import { Link } from "react-router-dom";
import "./Register.css";
import { Button } from "@mui/material";

const Register = () => {
  const handleRegistration = () => {
    // Handle Registration Part
  };
  return (
    <div className="app__register">
      <Link to="/">
        <img className="register__logo" src="header-logo.png" alt="logo" />
      </Link>
      <div className="register__container">
        <div className="register__container__form">
          <h1>REGISTER</h1>
          <form action="#">
            <h5>Full Name</h5>
            <input type="text" placeholder="Full Name" required />
            <h5>Email</h5>
            <input type="email" placeholder="Email" required />
            <h5>Password</h5>
            <input type="password" placeholder="Password" required />
            <h5>Confirm Password</h5>
            <input type="password" placeholder="Confirm Password" required />
            <Button
              type="submit"
              onClick={handleRegistration()}
              className="login__button"
              variant="contained"
            >
              Register
            </Button>
          </form>
          <p>
            Already a User ? <a href="/login">Sign In</a>{" "}
          </p>
        </div>
        <div className="register__container__logo">
          <img className="logo" src="header-logo.png" alt="logo" />
          <div className="register__container__welcome">
            <p> Welcome to Authentication App</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
