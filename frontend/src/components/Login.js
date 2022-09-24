import { Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import "./Login.css";

const Login = () => {
  const handleLogin = (e) => {
    // e.preventDefault();
    // Do the Login logic here
  };
  const handleOauth = (e) => {
    //Handles the Oauth
  };
  return (
    <div className="app__login">
      <Link to="/">
        <img className="login__logo" src="header-logo.png" alt="logo" />
      </Link>
      <div className="login__container">
        <div className="login__container__email">
          <h1>Login</h1>
          <form action="#">
            <h5>Email</h5>
            <input type="email" placeholder="Email" />
            <h5>Password</h5>
            <input type="password" placeholder="Password" />
            <Button
              type="submit"
              onClick={handleLogin()}
              className="login__button"
              variant="contained"
            >
              Sign In
            </Button>
          </form>
          <p>
            Having Trouble Signing In ? <a href="/register">Forgot Password</a>{" "}
            ?
          </p>
          <span>Or</span>
          <p>
            {" "}
            New User ? <a href="/register">Create a Account</a>{" "}
          </p>
        </div>
        <div className="login__container__oAuth">
          <div className="login__container__divider">
            <div className="vl"></div>
            <h5> Or </h5>
            <div className="vl"></div>
          </div>
          <div className="login__google">
            <Button
              type="submit"
              onClick={handleOauth()}
              className="login__button__google"
              variant="outlined"
            >
              <img
                className="google_icon"
                src="https://www.freepnglogos.com/uploads/google-logo-png/google-logo-png-google-icon-logo-png-transparent-svg-vector-bie-supply-14.png"
                alt=""
              />
              Sign In with Google
            </Button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
