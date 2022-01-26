package kr.co.information;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.InformationDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.InformationDTO;
import kr.co.main.Command;

public class UpdateInformation implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		
		String tilte = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		InformationDTO idto = new InformationDTO(num, writer, tilte, content, null, 0, 0, 0, 0);
		
		new InformationDAO().updateNotice(idto);
		
		
		return new CommandAction(true, "readInformation.do?num="+num);
	}

}
