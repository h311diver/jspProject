package kr.co.information;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;
import kr.co.main.Command;

public class ReplyUIInformation implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
				
		request.setAttribute("num", num);
		
		
		return new CommandAction(false, "information/replyInformation.jsp");
	}

}
