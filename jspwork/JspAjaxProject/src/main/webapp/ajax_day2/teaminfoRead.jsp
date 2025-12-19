<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>title</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style type="text/css">
.a{
border: 1px solid gray;
margin: 10px 10px;
width: 220px;
height:220px;
float: left;
background-color: lightGray;
font-family: Dongle;
}
</style>
</head>
<body>
<button type="button" class="btn btn-info" id="btn1">TeamToXml</button>
<button type="button" class="btn btn-info" id="btn2">InfoToJson</button>
<div id="result"></div>

<script type="text/javascript">

$("#btn1").click(function() {
      var s = "";
  
  $.ajax({
    type:"get",
    url:"teamToXml.jsp",
    dataType:"xml",
    success: function(res) {
      
      $(res).find("team").each(function(i,ele) {
        var e=$(ele);
        s+="num: "+e.attr("num")+"<br>";
        s+="name: "+e.find("name").text()+"<br>" ;
        s+="driver: "+e.find("driver").text()+"<br>";
        s+="addr: "+e.find("addr").text()+"<br>";
        s+="writeday: "+e.find("writeday").text();
        s+="<br>------------------------<br>";
      })
      $("#result").html(s);
      
    }
  })
  
})

$("#btn2").click(function() {
      var t= "";

  $.ajax({
    type:"get",
    url:"infoToJson.jsp",
    dataType:"json",
    success: function(res) {
      $.each(res, function(i, e) {
        t+="<div class='a'>num: "+e.num+"<br>";
        t+="name: "+e.name+"<br>" ;
        t+="hp: "+e.hp+"<br>";
        t+="age: "+e.age+"<br>";
        t+="<img width=80 src='"+e.photo+"'></div>";
      })
      $("#result").html(t);
    }
  })
})
</script>



</body>
</html>