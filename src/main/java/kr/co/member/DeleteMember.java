package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.main.Command;

public class DeleteMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		new MemberDAO().deleteMember(id, pw);
		
		HttpSession session = request.getSession(false);
		
		request.setAttribute("session", session);
		
		
		return new CommandAction(true, "home.do");
		

	}

}
