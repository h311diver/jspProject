package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class IdCheckMember implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDTO mdto = new MemberDAO().readMember(id);
		
		request.setAttribute("mdto", mdto);
		
		return new CommandAction(false, "main/idcheck.jsp");
		
		
		
		
		
	}
	

}
