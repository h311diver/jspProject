package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.main.Command;

public class MyCountMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int amount = 0;
		
		amount = new MemberDAO().myCountMember(id);
		
		request.setAttribute("amount", amount);
		
		return new CommandAction(false, "member/myCountMember.jsp");
	}

}
