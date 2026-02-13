import React, { useState } from "react";
import FiveSubApp from "./FiveSubApp";
import FiveSubApp2 from "./FiveSubApp2";
import FiveSubApp3 from "./FiveSubApp3";

const FiveApp = () => {
  const [number, setNumber] = useState(0);

  //증가
  const numberIncre = () => {
    setNumber(number + 1);
  };
  //감소
  const numberDecre = () => {
    setNumber(number - 1);
  };

  return (
    <div>
      <h3 className="alert alert-info">FiveApp_부모자식 컴포넌트 통신</h3>
      <FiveSubApp name="미미" age="22" />
      <FiveSubApp name="루루" age="55" />
      <FiveSubApp name="김지선" age="24" />
      <br />
      <br />
      <FiveSubApp2 flower="장미" price="15000" lineColor="green" />
      <FiveSubApp2 flower="튤립" price="11000" lineColor="pink" />
      <FiveSubApp2 flower="목화" price="35000" lineColor="beige" />
      <br />
      <br />
      <div className="number">{number}</div>
      <FiveSubApp3 incre={numberIncre} decre={numberDecre} />
    </div>
  );
};

export default FiveApp;
