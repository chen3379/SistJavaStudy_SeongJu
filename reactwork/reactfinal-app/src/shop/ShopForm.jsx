import axios from "axios";
import React, { useState } from "react";

const ShopForm = () => {
  const [photo, setPhoto] = useState("");
  const [sangpum, setSangpum] = useState("");
  const [su, setSu] = useState("");
  const [dan, setDan] = useState("");

  //url 등록
  let uploadUrl = "http://localhost:9001/shop/upload"; //백엔드주소
  let photoUrl = "http://localhost:9001/save/"; //파일업로드주소
  let insertUrl = "http://localhost:9001/shop/insert";

  //fileChange시 호출 이벤트
  const uploadImage = (e) => {
    const uploadFile = e.target.files[0];
    const imageFile = new FormData();
    imageFile.append("uploadFile", uploadFile);

    axios({
      method: "post",
      url: uploadUrl,
      data: imageFile,
      headers: { "Content-Type": "multipart/form-data" },
    })
      .then((res) => {
        setPhoto(res.data);
      })
      .catch((err) => {
        alert(err);
      });
  };

  //추가하는 함수 이벤트..추가 후 성공 메세지
  const onInsert = () => {
    axios.post(insertUrl, { sangpum, su, dan }).then((res) => {
      //성공시 처리할 코드
      alert("성공");
    });
  };

  return (
    <div>
      <h1 className="alert alert-info">ShopForm</h1>

      <table
        className="table table-bordered"
        style={{ width: "600px", tableLayout: "fixed" }}
      >
        <tbody>
          <tr>
            <th style={{ width: "120px" }}>상품명</th>
            <td>
              <input
                type="text"
                className="form-control"
                style={{ width: "200px" }}
                onChange={(e) => {
                  setSangpum(e.target.value);
                }}
              />
            </td>
            <th>{sangpum}</th>
          </tr>

          <tr>
            <th style={{ width: "120px" }}>상품사진</th>
            <td>
              <input
                type="file"
                className="form-control"
                style={{ width: "250px" }}
                onChange={uploadImage}
              />
            </td>
            <th></th>
          </tr>

          <tr>
            <th style={{ width: "120px" }}>수량</th>
            <td>
              <input
                type="text"
                className="form-control"
                style={{ width: "200px" }}
                onChange={(e) => {
                  setSu(e.target.value);
                }}
              />
            </td>
            <th>{su}</th>
          </tr>

          <tr>
            <th style={{ width: "120px" }}>단가</th>
            <td>
              <input
                type="text"
                className="form-control"
                style={{ width: "200px" }}
                onChange={(e) => {
                  setDan(e.target.value);
                }}
              />
            </td>
            <th>{dan}</th>
          </tr>

          <tr style={{ height: "150px" }}>
            <td colSpan="2">
              <img
                src={photoUrl + photo}
                style={{ width: "120px", marginLeft: "120px" }}
              />
            </td>
            <td>
              <button
                type="button"
                className="btn btn-success"
                style={{ width: "120px", height: "120px", marginLeft: "30px" }}
                onClick={onInsert}
              >
                상품등록
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default ShopForm;
