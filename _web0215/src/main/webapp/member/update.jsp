 <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
     
 <%@ page import="java.sql.*" %>  
 <%@ page import="java.time.*" %>
  
 <%
     request.setCharacterEncoding("utf-8");
 
     // 전달받은 값 읽기
     int    num     = Integer.parseInt(request.getParameter("num"));
     String writer  = request.getParameter("writer" );
     String title   = request.getParameter("title"  );
     String content = request.getParameter("content");
 
     // 빈 칸이 하나라도 있으면 오류 출력하고 종료
     if (writer  == null || writer.length()  == 0 ||
         title   == null || title.length()   == 0 ||
         content == null || content.length() == 0) {
 %>      
         <script>
             alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
             history.back();
         </script>
 <%        
         return;
     }
 
     // 입력된 내용으로 게시글 데이터 업데이트
     Class.forName("com.mysql.cj.jdbc.Driver");
     try ( 
         Connection conn = DriverManager.getConnection(
        		 "jdbc:mysql://localhost:3306/project1", "root", "mysql");
         Statement stmt = conn.createStatement();            
     ) {
         // 현재 시간 얻기
         String curTime = LocalDate.now() + " " + 
                          LocalTime.now().toString().substring(0, 8);
         
         // 쿼리 실행
         stmt.executeUpdate(String.format(
                 "update board set writer='%s', title='%s', " +
                 "content='%s', regtime='%s' where num=%d",
                 writer, title, content, curTime, num));
     
     } catch(Exception e) {
         e.printStackTrace();
     }
     
     // 글 보기 화면으로 돌아감
     response.sendRedirect("view.jsp?num=" + num);
 %>     
 