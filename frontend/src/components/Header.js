import React from "react";
import "./Header.css";
import KeyIcon from "@mui/icons-material/Key";
import Login from "./Login";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import { Button } from "@mui/material";
import { BrowserRouter as Router, Link } from "react-router-dom";

const Header = () => {
  return (
    <div className="header">
      <img className="header__logo" src="header-logo.png" alt="" />
      <div className="header__appNameSection">
        <p className="header__name">User Authentication App</p>
        <KeyIcon className="header__keyIcon" />
      </div>
      <div className="header__options">
        <div className="header__option">
          <AccountCircleIcon />
          <span className="header__option__userName"> Guest </span>
        </div>
        <div className="header__option">
          <Link to="/login" className="header__link">
            <Button variant="contained">
              Login
            </Button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default Header;
