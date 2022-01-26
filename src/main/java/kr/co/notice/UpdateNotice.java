package kr.co.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.NoticeDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;

import kr.co.main.Command;

public class UpdateNotice implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		
		String tilte = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		NoticeDTO ndto = new NoticeDTO(num, writer, tilte, content, null, 0);
		
		new NoticeDAO().updateNotice(ndto);
		
		
		return new CommandAction(true, "readNotice.do?num="+num);
	}

}
