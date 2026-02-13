import React from "react";

const FiveSubApp2 = ({ flower, price, lineColor }) => {
  return (
    <div>
      <div className="line" style={{ borderColor: lineColor }}>
        {flower} 1송이 가격은 {price}원 입니다
      </div>
    </div>
  );
};

export default FiveSubApp2;
