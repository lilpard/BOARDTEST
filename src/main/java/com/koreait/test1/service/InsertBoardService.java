package com.koreait.test1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.test1.dao.BoardDAO;

public class InsertBoardService implements BoardService {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.insertBoard(writer, title, content);
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<script>");
				out.println("alert('삽입 성공')");
				out.println("location.href='selectBoardList.do'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('삽입 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
