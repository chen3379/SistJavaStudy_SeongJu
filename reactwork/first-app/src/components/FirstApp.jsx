import React from "react";
import "./MyStyle.css";
import img1 from "../image/만화이미지/01.png";
import img2 from "../image/만화이미지/02.png";

const FirstApp = () => {
  //스타일을 변수에 저장
  const styleImg1 = {
    width: "200px",
    border: "5px inset gray",
    marginTop: "20px",
  };

  let hello = <h4>Hello React</h4>;

  return (
    <div>
      <h2 className=" line">FirstApp</h2>
      <div
        style={{
          fontSize: 30,
          color: "green",
          marginLeft: 100,
          fontFamily: "Dongle",
        }}
      >
        안녕 리액트
        <br />
        <img src={img1} alt="" style={styleImg1} />
        <img
          src={img2}
          alt=""
          style={{
            width: "200px",
            border: "3px dotted silver",
            borderRadius: "30px",
            marginLeft: "50px",
          }}
        />
      </div>
      <br></br>
      <img src="../a.png" alt="" />
      {hello}
      {hello}
      {hello}
    </div>
  );
};

export default FirstApp;
