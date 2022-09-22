import React from "react";
import { Button } from "@mui/material";

import Header from "./Header";
import "./Profile.css";
function Profile() {
  const data = {
    name: "Firstname lastname",
    bio: "Description",
    phone: 1234567899,
    email: "abc@gmail.com",
  };
  const edit = (e) => {
    // e.preventDefault();
    // Do the edit logic here
  };
  return (
    <div>
      <Header />
      <div className="container m-4 p-3 d-flex justify-content-center">
        <div className="card p-4">
          <form action="#">
            <div className="row">
              <div className="col-md-6">
                <img
                  src="https://picsum.photos/200/300"
                  height="150"
                  width="150"
                />
                <h5>Full Name</h5>
                <input type="text" value={data.name} />
                <h5>Bio</h5>
                <input type="text" value={data.bio} />
              </div>

              <div className="col-md-6">
                <h5>Phone</h5>
                <input type="number" value={data.phone} />
                <h5>Email</h5>
                <input type="text" value={data.email} />
                <h5>Password</h5>
                <input type="password" value={data.pass} />
                <h5>Confirm Password</h5>
                <input type="password" placeholder="Confirm password" />
              </div>
            </div>
            <div className="edit__btn">
              <Button
                type="submit"
                onClick={edit()}
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
