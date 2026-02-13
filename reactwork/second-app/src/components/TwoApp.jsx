import React from "react";
import { Alert } from "@mui/material";
import img1 from "../components/image/만화이미지/01.png";
import img2 from "../components/image/만화이미지/02.png";
import img3 from "../components/image/만화이미지/03.png";
import img4 from "../components/image/만화이미지/04.png";
import img5 from "../components/image/만화이미지/05.png";

const TwoApp = () => {
  //배열 변수 선언
  const names = ["김구라", "김민지", "유재석", "김민희", "이정재"];

  //반복문 변수에 저장 후 출력해도 된다
  const nameList = names.map((name) => <li>{name}</li>);

  //색상을 배열로
  const colors = ["red", "pink", "gray", "green", "blue", "orange"];

  //이미지 배열변수에 넣기
  const imgArr = [img1, img2, img3, img4, img5];
  return (
    <div>
      <Alert severity="info">TwoApp 입니다</Alert>

      <div>
        <h3>map 반복문 연습</h3>
        <ol>{nameList}</ol>
        <hr />
        <ul>
          {
            //반복문을 return에 직접 준다
            names.map((name, index) => (
              <b style={{ marginLeft: "10px" }}>
                {index}:{name}
              </b>
            ))
          }
        </ul>

        <hr />

        {colors.map((color, index) => (
          <div className="box" style={{ backgroundColor: color }}>
            {index}:{color}
          </div>
        ))}

        <hr />

        {imgArr.map((img) => (
          <img src={img} style={{ width: 100 }} />
        ))}
      </div>
    </div>
  );
};

export default TwoApp;
