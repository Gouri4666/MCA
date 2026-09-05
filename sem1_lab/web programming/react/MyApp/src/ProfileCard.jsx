import React from "react";

const ProfileCard = ({ image, name, bio }) => {
  return (
    <div className="card text-center" style={{ width: "18rem" }}>
      <img
        src={image}
        className="card-img-top rounded-circle mt-3"
        alt="Profile"
        style={{ width: "120px", height: "120px", margin: "0 auto" }}
      />

      <div className="card-body">
        <h5 className="card-title">{name}</h5>
        <p className="card-text">{bio}</p>

        <button className="btn btn-primary">Follow</button>
      </div>
    </div>
  );
};

export default ProfileCard;
