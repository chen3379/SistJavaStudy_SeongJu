//var: 함수형변수
//let: 영역형변수(영역별로 다른 메모리 갖는다)

var a = 1;
let b = 2;

function myVarTest() {
  var a = 3;
  let b = 4;

  if (true) {
    var a = 5; //7번행의 a값을 덮어쓴다 (3 -> 5)
    let b = 6; //line 8의 b와 전혀 다른 변수
    console.log(a); //5
    console.log(b); //6
  }
  console.log(a); //5
  console.log(b); //4
}

console.log(a);
console.log(b);
//1
//2
myVarTest();
//3
//4

//const: 상수
const p = 3.1458;
const pp = {
  name: "송혜교",
  addr: "제주시",
};

console.log("이름: " + pp.name);
console.log("주소: " + pp.addr);

//객체타입일 경우에는 멤버는 변경 가능
pp.name = "김민";
pp.addr = "서울시";
console.log("이름: " + pp.name);
console.log("주소: " + pp.addr);

//비교연산자
let x = 6;
let v = "6";
console.log(x == v); //값으로만 비교하므로 true
console.log(x === v); //타입까지 일치해야 true이므로 false

console.log(`x의 타입은 ${typeof x}입니다`);
console.log(`v의 타입은 ${typeof v}입니다`);
