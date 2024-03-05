package com.board;

import java.sql.*;
import java.time.*;
import java.util.*;

public class MemberDao {

    // DB에 접속하여 Connection 객체를 반환
    private Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/project2", "root", "mysql");

        return conn;
    }


    // 멤버 인원수 얻기
    public int getNumRecords() {
        int numRecords = 0;

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select count(*) from member");
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return numRecords;
    }

    // 멤버 리스트 읽기
    public ArrayList<MemberDto> selectList(int start, int listSize) {

        ArrayList<MemberDto> dtoList = new ArrayList<MemberDto>();

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(
                    "select * from member order by memberno desc limit %d, %d",
                    start, listSize));
        ) {
            while (rs.next()) {

                // 새 DTO 객체를 만들고 멤버 데이터를 이 객체에 저장
                MemberDto dto = new MemberDto();

                dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setPw(rs.getString("pw"));
                dto.setName(rs.getString("name"));

                // 이 DTO 객체를 ArrayList에 추가
                dtoList.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dtoList;
    }

    // 지정된 멤버 번호를 가진 레코드 읽기
    public MemberDto selectOne(int memberno) {

        MemberDto dto = new MemberDto();

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select * from member where memberno=" + memberno);
        ) {
            if (rs.next()) {

                // 글 데이터를 DTO에 저장
            	dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setPw(rs.getString("pw"));
                dto.setName(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
    
 // 지정된 멤버 id, pw를 가진 레코드 읽기
    public MemberDto selectMember(String id, String pw) {

        MemberDto dto = new MemberDto();
        String sql = "select * from member where id=? and pw=?";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = 
            		conn.prepareStatement(sql);
        ) {
        	pstmt.setString(1, id);
        	pstmt.setString(2, pw);
        	ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                // 글 데이터를 DTO에 저장
            	dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setPw(rs.getString("pw"));
                dto.setName(rs.getString("name"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    // DTO에 담긴 내용으로 새로운 레코드 저장
    public void insertOne(MemberDto dto) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(
                    "insert into member " +
                    "(id, pw, name)" +
                    "values ('%s', '%s', '%s')",
                    dto.getId(), dto.getPw(), dto.getName()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // DTO에 담긴 내용으로 멤버 데이터 업데이트
    public void updateOne(MemberDto dto) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(
                    "update member set pw='%s', name='%s' where memberno=%d",
                    dto.getPw(), dto.getName(), dto.getMemberno()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // 지정된 멤버 번호의 레코드 삭제
    public void deleteOne(int memberno) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("delete from member where memberno=" + memberno);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}