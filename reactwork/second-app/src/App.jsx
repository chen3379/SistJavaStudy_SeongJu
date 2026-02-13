import { useState } from "react";
import "./App.css";
import OneApp from "./components/OneApp";
import TwoApp from "./components/TwoApp";
import ThreeApp from "./components/ThreeApp";
import FourApp from "./components/FourApp";
import FiveApp from "./components/FiveApp";

function App() {
  const [index, setIndex] = useState(4);

  return (
    <>
      <div>
        <b>컴포넌트 선택하기: </b>
        <select
          name="App"
          id=""
          value={index}
          onChange={(e) => {
            setIndex(Number(e.target.value));
          }}
        >
          <option value="1">OneApp</option>
          <option value="2">TwoApp</option>
          <option value="3">ThreeApp</option>
          <option value="4">FourApp</option>
          <option value="5">FiveApp</option>
        </select>
        {index === 1 ? (
          <OneApp />
        ) : index === 2 ? (
          <TwoApp />
        ) : index === 3 ? (
          <ThreeApp />
        ) : index === 4 ? (
          <FourApp />
        ) : (
          <FiveApp />
        )}
      </div>
    </>
  );
}

export default App;
