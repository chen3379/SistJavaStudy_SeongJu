import React, { useState } from "react";

const ThirdApp = () => {
  const [name, setName] = useState("이민지");
  const [age, setAge] = useState(25);

  return (
    <div>
      <h2 className="alert alert-danger">ThirdApp</h2>
      <b style={{ fontSize: "40px", fontFamily: "Dongle" }}>
        이름: {name}
        <br></br>
        나이: {age}
      </b>
      <br></br>
      <button
        type="button"
        onClick={() => {
          (setName("김민지"), setAge(30));
        }}
      >
        이름, 나이 변경
      </button>
      <br />
      <br />
      <button
        type="button"
        onClick={() => {
          (setName(null), setAge(0));
        }}
      >
        초기화(빈칸,0)
      </button>
    </div>
  );
};

export default ThirdApp;
