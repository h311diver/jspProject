package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.domain.CommandAction;
import kr.co.main.Command;

public class DeleteUIMember implements Command {

	



	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		
		request.setAttribute("id", id);

		
		

		return new CommandAction(false, "member/deleteMember.jsp");

	}

}
