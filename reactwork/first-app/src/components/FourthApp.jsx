import React, { useState } from "react";

const FourthApp = () => {
  const [name, setName] = useState("");
  const [java, setJava] = useState(0);
  const [spring, setSpring] = useState(0);
  const [total, setTotal] = useState(0);
  const [avg, setAvg] = useState(0);

  return (
    <div>
      <h2 className="alert alert-warning">FourthApp</h2>

      <div className="inP">
        이름:
        <span>{name}</span>
        <input
          type="text"
          className="form-control"
          style={{ width: 100 }}
          onChange={(e) => {
            setName(e.target.value);
          }}
        />
        <br></br>
        자바점수:
        <span>{java}</span>
        <input
          type="text"
          className="form-control"
          style={{ width: 100 }}
          onChange={(e) => {
            setJava(e.target.value);
          }}
        />
        <br></br>
        스프링점수:
        <span>{spring}</span>
        <input
          type="text"
          className="form-control"
          style={{ width: 100 }}
          onChange={(e) => {
            setSpring(e.target.value);
          }}
        />
        <br></br>
        <button
          onClick={() => {
            setTotal(Number(java) + Number(spring));
            setAvg((Number(java) + Number(spring)) / 2);
          }}
        >
          결과확인
        </button>
      </div>
      <br></br>
      <div className="outP">
        이름: {name}
        <br></br> 자바점수: {java}
        <br></br>스프링점수: {spring}
        <br></br>총점: {total}
        <br></br>
        평균: {avg}
        <br></br>
      </div>
    </div>
  );
};

export default FourthApp;
