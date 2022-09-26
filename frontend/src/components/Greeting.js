import React, { useState, useEffect } from "react";
import "./Greeting.css";
const Greeting = () => {
  const [loginData, setLoginData] = useState("");
  useEffect(() => {
    localStorage.getItem("name")
      ? setLoginData(localStorage.getItem("name"))
      : setLoginData("");
  }, [loginData]);
  return (
    <div className="greeting">
      <div className="welcome_message">
        {loginData ? (
          <h1> Welcome {loginData} To our Authentication App </h1>
        ) : (
          <h1> Welcome Guest To our Authentication App </h1>
        )}
      </div>
    </div>
  );
};

export default Greeting;
