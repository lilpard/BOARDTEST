package com.koreait.test1.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.koreait.test1.dto.Board;

@Repository
public interface BoardDAO {
	public ArrayList<Board> selectBoardList();
	public int selectBoardCount(); 
	public int insertBoard(String writer, String title, String content);
	public Board selectByIdx(int idx);
	public int updateBoard(String title, String content, int idx); 
	public int deleteBoard(int idx);
}
