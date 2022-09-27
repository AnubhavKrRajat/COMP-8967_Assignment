import React, { useState, useEffect } from "react";
import { Button } from "@mui/material";
import { Link, useNavigate } from "react-router-dom";

import Header from "./Header";
import "./Profile.css";
function Profile() {
  const [err, setErr] = useState("");

  const [fullname, setfullname] = useState(localStorage.getItem("name"));
  const [bio, setbio] = useState(localStorage.getItem("bio"));
  const [phone, setphone] = useState(localStorage.getItem("phone"));
  const [email, setemail] = useState(localStorage.getItem("email"));
  const [password1, setPassword1] = useState("");
  const [password2, setPassword2] = useState("");
  let navigate = useNavigate();

  useEffect(() => {
    
  }, []);

  const handleUpdate = async (e) => {
    e.preventDefault();

    if (password1 !== password2) return setErr("password are not matching");
    try {
      console.log("sending request");
      let resp = await fetch(
        "https://internship-project-auth.herokuapp.com/UpdateUser",
        {
          method: "PUT",
          headers: { "content-type": "application/json" },
          body: JSON.stringify({
            name: fullname,
            password: password1,
            bio:bio,
            phone:phone,
            email: email,
          }),
        }
      );
      if (resp.status === 200) {
        alert("Updated Successfull");
        return navigate("/login");
      } else {
        alert("Update Unsuccessfull");
      }
      console.log(resp, resp.status);
      return setErr(`invalid request ${resp}`);
    } catch (e) {
      console.log(err);
      alert(`error: ${e.message}`)
      setErr(`error: ${e.message}`);
    }

    
  };
  return (
    <div>
      <Header />
      <div className="container m-4 p-3 d-flex justify-content-center">
        <div className="card p-4">
          <form onSubmit={handleUpdate} action="#">
            <div className="row">
              <div className="col-md-6">
                <img alt="Image" src="https://picsum.photos/200/300" height="150" width="150" />
                <h5>Full Name</h5>
                <input type="text" value={fullname} onChange={(e) => setfullname(e.target.value)}  />
                <h5>Bio</h5>
                <input type="text" value={bio} onChange={(e) => setbio(e.target.value)} />
              </div>

              <div className="col-md-6">
                <h5>Phone</h5>
                <input type="number" value={phone} onChange={(e) => setphone(e.target.value)} />
                <h5>Email</h5>
                <input type="text" value={email} onChange={(e) => setemail(e.target.value)} />
                <h5>Password</h5>
                <input
                  id="password"
                  minLength={8}
                  type="password"
                  placeholder="Password"
                  value={password1}
                  onChange={(e) => setPassword1(e.target.value)}
                  required
                />
                <h5>Confirm Password</h5>
                <input
                  id="password2"
                  type="password"
                  minLength={8}
                  placeholder="Confirm Password"
                  value={password2}
                  onChange={(e) => setPassword2(e.target.value)}
                  required
                />
              </div>
            </div>
            <div className="edit__btn">
              <Button
                type="submit"
                classNameName="edit__button"
                variant="contained"
              >
                Update
              </Button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Profile;
