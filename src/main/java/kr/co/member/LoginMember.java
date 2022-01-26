package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class LoginMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
	
		
		MemberDTO login = new MemberDAO().loginMember(id, pw);
		
		if(login == null) {
			return new CommandAction(true, "loginuiMember.do");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		
		return new CommandAction(true, "/");
	}

}
