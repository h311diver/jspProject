package kr.co.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.NoticeDAO;

import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;

import kr.co.main.Command;

public class InsertNotice implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content =request.getParameter("content");
		
		
		
		NoticeDTO ndto = new NoticeDTO(0, writer, title, content, null, 0);
		new NoticeDAO().insertNotice(ndto);
		
			
		return new CommandAction(true, "listNotice.do");
	}
	

}
