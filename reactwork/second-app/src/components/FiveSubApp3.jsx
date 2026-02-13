import React from "react";

const FiveSubApp3 = (props) => {
  return (
    <div>
      <button type="button" className="btn btn-info" onClick={props.incre}>
        증가
      </button>
      <button type="button" className="btn btn-danger" onClick={props.decre}>
        감소
      </button>
    </div>
  );
};

export default FiveSubApp3;
