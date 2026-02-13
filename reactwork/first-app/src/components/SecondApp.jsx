import React, { useState } from "react";

const SecondApp = () => {
  const [message, setMessage] = useState("Happy Friday");
  const enterEvent = (e) => {
    if (e.key === "Enter") setMessage("");
  };
  return (
    <div>
      <h2 className="alert alert-secondary">SecondApp</h2>
      <h3 style={{ color: "red" }}>{message}</h3>
      <hr />
      <h4>메세지를 입력해 주세요</h4>
      <input
        type="text"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        onKeyUp={enterEvent}
      />
    </div>
  );
};

export default SecondApp;
