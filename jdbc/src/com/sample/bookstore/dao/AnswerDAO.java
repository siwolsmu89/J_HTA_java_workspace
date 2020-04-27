package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Answer;

public class AnswerDAO {

	public Answer resultSetToAnswer(ResultSet rs) throws SQLException {
		Answer answer = new Answer();
		
		answer.setNo(rs.getInt("answer_no"));
		answer.setContent(rs.getString("answer_content"));
		answer.setQuestionNo(rs.getInt("question_no"));
		answer.setRegisteredDate(rs.getDate("answer_registered_date"));
		
		return answer;
	}
	
	public void addAnswer(Answer answer) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.addAnswer"));
		
		pstmt.setString(1, answer.getContent());
		pstmt.setInt(2, answer.getQuestionNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Answer getAnswer(int questionNo) throws SQLException {
		Answer answer = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.getAnswer"));
		pstmt.setInt(1, questionNo);		
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			answer = resultSetToAnswer(rs);
		}
		
		return answer;
	}
	
	public void removeAnswer(int questionNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.removeAnswer"));
		pstmt.setInt(1, questionNo);
		
		pstmt.executeUpdate();
	
		pstmt.close();
		connection.close();
	}
	
}
