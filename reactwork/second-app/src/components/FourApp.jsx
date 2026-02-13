import React, { useState } from "react";
import { Alert } from "@mui/material";

const FourApp = () => {
  const [boards, setBoards] = useState([
    {
      no: 1,
      writer: "김민지",
      subject: "안녕 오늘은 리액트",
      photo: "s2",
    },

    {
      no: 2,
      writer: "최미나수",
      subject: "금요일 오후",
      photo: "s3",
    },
    {
      no: 3,
      writer: "임수빈",
      subject: "오늘 저녁 뭐 먹지",
      photo: "s5",
    },
  ]);
  return (
    <div>
      <Alert severity="error">FourApp 입니다</Alert>
      <table className="table table-bordered" style={{ width: "400px;" }}>
        <caption align="top">
          <b>배열객체출력</b>
        </caption>
        <thead>
          <tr className="table-secondary">
            <th width="60">번호</th>
            <th width="100">사진</th>
            <th width="160">제목</th>
            <th width="120">작성자</th>
          </tr>
        </thead>
        <tbody>
          {boards.map((row, index) => (
            <tr key={index}>
              <td>{row.no}</td>
              <td>
                <img
                  src={`../image/flower_ani/${row.photo}.JPG`}
                  style={{ width: "50px" }}
                />
              </td>
              <td>{row.writer}</td>
              <td>{row.subject}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FourApp;
