package kr.co.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.NoticeDAO;

import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;
import kr.co.main.Command;

public class ListNotice implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
		
		List<NoticeDTO> listNotice = new NoticeDAO().listNotice();
		
		
		
		
		request.setAttribute("listNotice",listNotice);
		

	
		
		
		return new CommandAction(false, "notice/listNotice.jsp");
	}

	

}
