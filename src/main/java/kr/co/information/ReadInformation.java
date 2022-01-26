package kr.co.information;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.InformationDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.InformationDTO;
import kr.co.main.Command;

public class ReadInformation implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		InformationDTO idto = new InformationDAO().readInformation(num);
		
		String content = idto.getContent();
		content = content.replace(System.lineSeparator(), "<br>");
		
		idto.setContent(content);
		
		request.setAttribute("idto", idto);
		
		return new CommandAction(false, "information/readInformation.jsp");
	}

}
