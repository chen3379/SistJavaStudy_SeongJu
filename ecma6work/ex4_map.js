var numbers = [1, 2, 3, 4, 5];

var numproc = numbers.map(function (num) {
  return num * num;
});

console.log(numproc);

var colors = ["red", "green", "blue", "white", "black"];
colors.map((color, index) => {
  console.log(color, index);
});
