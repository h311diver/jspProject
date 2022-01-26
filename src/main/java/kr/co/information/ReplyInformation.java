package kr.co.information;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.InformationDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.InformationDTO;

import kr.co.main.Command;

public class ReplyInformation implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sPnum = request.getParameter("pnum");
		int pnum = Integer.parseInt(sPnum);
		
		
		String sCurPage = request.getParameter("curPage");
		
		
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		InformationDTO pdto = new InformationDTO(0, writer, title, content, null, 0, 0, 0, 0);
		
		new InformationDAO().replyInformation(pdto, pnum);
		
		
			
		return new CommandAction(true, "listInformation.do?curPage="+sCurPage);
		
		
		
	}

}
