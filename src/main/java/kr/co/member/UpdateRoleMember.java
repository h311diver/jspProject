package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class UpdateRoleMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String role = request.getParameter("role");
		
		new MemberDAO().updateRoleMember(new MemberDTO(id, null, null, null, null, null, null, 0, role));
		
		
		
		

		return new CommandAction(true, "readMember.do?id="+id);
		
	}

}
