package kr.co.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.NoticeDAO;

import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;

import kr.co.main.Command;

public class ReadNotice implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		NoticeDTO ndto = new NoticeDAO().readNotice(num);
		
		String content = ndto.getContent();
		content = content.replace(System.lineSeparator(), "<br>");
		
		ndto.setContent(content);
		
		
		request.setAttribute("ndto", ndto);
		
		
		
		return new CommandAction(false, "notice/readNotice.jsp");
	}

}
