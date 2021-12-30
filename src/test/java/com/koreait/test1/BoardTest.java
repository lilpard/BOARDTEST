package com.koreait.test1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfig;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanConfig.class})
public class BoardTest {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test
	public void insertTest() {
		String writer = "테스터";
		String title = "테스트 제목";
		String content = "테스트 내용";
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.insertBoard(writer, title, content);
		if(result > 0) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
	}

	@Test
	public void selectTest() {
		int idx = 9999;
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		Board board = boardDAO.selectByIdx(idx);
		System.out.println(board);
	}
	
	@Test
	public void updateTest() {
		int idx = 9999;
		String title = "테스트 제목";
		String content = "테스트 내용";
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.updateBoard(title, content, idx);
		if(result > 0) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	}
	
	@Test
	public void deleteTest() {
		int idx = 9999;
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.deleteBoard(idx);
		if(result > 0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
	}
}
