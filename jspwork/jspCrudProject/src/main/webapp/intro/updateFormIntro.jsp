<%@page import="java.util.StringTokenizer"%>
<%@page import="intro.IntroDto"%>
<%@page import="intro.IntroDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Nanum+Myeongjo&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">
  function goFocus(hp) {
	if(hp.value.length==4)
		frm.hp3.focus();
}
</script>
</head>
<%
String num=request.getParameter("num");
IntroDao dao=new IntroDao();
IntroDto dto=dao.getOneIntro(num);
%>
<body>
<div style="width: 600px; margin: 100px 150px;">
    <form action="updateaction.jsp" method="post" name="frm">
    <input type="hidden" name="num" value="<%=num%>">
       <table class="table table-bordered">
         <tr>
           <th style="text-align: center;"
           class="table-secondary">이름</th>
           <td>
             <input type="text" name="name" class="form-control"
             value="<%=dto.getName()%>">
           </td>
         </tr>
         <tr>
           <th style="text-align: center;"
           class="table-secondary">생년월일</th>
           <td>
              <input type="date" name="birthday" class="form-control"
              style="width: 200px;" value="<%=dto.getBirthday() %>">
           </td>
         </tr>
         <tr>
           <th style="text-align: center;"
           class="table-secondary">전화번호</th>
           <td class="input-group">
             <select size="1" name="hp1" class="form-control"
              style="width: 60px;">
                 <%
                 
                 //하이픈을 구분자로 분리
                 StringTokenizer st=new StringTokenizer(dto.getHp(),"-");
                 String hp1=st.nextToken();
                 String hp2=st.nextToken();
                 String hp3=st.nextToken();
                 
                 
                 String [] hpstr={"02","010","017","032","019"};
                 for(int i=0;i<hpstr.length;i++)
                 {
                	 if(hp1.equals(hpstr[i]))
                	 {%>
                		 <option value="<%=hpstr[i]%>" selected="selected"><%=hpstr[i]%></option>
                	 <%}else{%>
                		 <option value="<%=hpstr[i]%>"><%=hpstr[i]%></option>
                	 <%}
                 }
;                 %>
             </select>
             &nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
             <input type="text" name="hp2" class="form-control"
              value="<%=hp2 %>" onkeyup="goFocus(this)">
              &nbsp;&nbsp;<b>-</b>&nbsp;&nbsp;
              <input type="text" name="hp3" class="form-control"
              value="<%=hp3%>">
           </td>
         </tr>
         
         <tr>
           <th style="text-align: center;"
           class="table-secondary">출신지역</th>
           <td>
             <label><input type="radio" name="hometown" value="서울" <%=dto.getHometown().equals("서울")?"checked":"" %>>서울&nbsp;</label>
             <label><input type="radio" name="hometown" value="경기" <%=dto.getHometown().equals("경기")?"checked":"" %>>경기&nbsp;</label>
             <label><input type="radio" name="hometown" value="강원" <%=dto.getHometown().equals("강원")?"checked":"" %>>강원&nbsp;</label>
             <label><input type="radio" name="hometown" value="제주" <%=dto.getHometown().equals("제주")?"checked":"" %>>제주&nbsp;</label>
             <label><input type="radio" name="hometown" value="경상" <%=dto.getHometown().equals("경상")?"checked":"" %>>경상&nbsp;</label>
             <label><input type="radio" name="hometown" value="전라" <%=dto.getHometown().equals("전라")?"checked":"" %>>전라&nbsp;</label>
           </td>
         </tr>
         
         <tr>
           <th style="text-align: center;"
           class="table-secondary">취미</th>
           <td>
             <label><input type="checkbox" name="hobby" value="영화감상" 
             <%=dto.getHobby().contains("영화감상")?"checked":"" %>>영화감상&nbsp;</label>
             <label><input type="checkbox" name="hobby" value="등산" 
             <%=dto.getHobby().contains("등산")?"checked":"" %>>등산&nbsp;</label>
             <label><input type="checkbox" name="hobby" value="축구" 
             <%=dto.getHobby().contains("축구")?"checked":"" %>>축구&nbsp;</label>
             <label><input type="checkbox" name="hobby" value="요리"
             <%=dto.getHobby().contains("요리")?"checked":"" %>>요리&nbsp;</label>
             <label><input type="checkbox" name="hobby" value="게임"
             <%=dto.getHobby().contains("게임")?"checked":"" %>>게임&nbsp;</label>
             <label><input type="checkbox" name="hobby" value="그림"
             <%=dto.getHobby().contains("그림")?"checked":"" %>>그림&nbsp;</label>
           </td>
         </tr>
         
         <tr>
           <th style="text-align: center;"
           class="table-secondary">MBTI</th>
           <td>
             <select name="mbti" class="form-control"
              style="width: 120px;">
              <%
              String [] mstr={"ESTP","ENFJ","ESTJ","ISTJ","INFP","ISFJ"};
              
              for(int i=0;i<mstr.length;i++)
              {
            	  if(dto.getMbti().equals(mstr[i]))
            	  {%>
            		  <option value="<%=mstr[i]%>" selected="selected"><%=mstr[i]%></option>
            	  <%}else
            	  {%>
            		  <option value="<%=mstr[i]%>" ><%=mstr[i]%></option>
            	  <%}
              }
              %>
              
                
             </select>
           </td>
         </tr>
         <tr>
            <th style="text-align: center;"
           class="table-secondary">하고싶은말</th>
           <td>
             <textarea style="width: 500px; height: 80px;"
             name="free" required="required" 
             placeholder="자신의 성향이나 성격등을 자유롭게 말해보아요~~~"
             class="form-control"><%=dto.getFree() %></textarea>
              
           </td>
         </tr>
         
         <tr>
           <td colspan="2" align="center">
             <button type="submit" class="btn btn-success"
             style="width: 100px;">수정완료</button>
             <button type="button" class="btn btn-success"
             style="width: 100px;" onclick="location.href='introList.jsp'">뒤로가기</button>
           </td>
         </tr>
         
       </table>
    </form>
</div>
</body>
</html>