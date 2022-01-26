package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class UpdateMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String sPhone = request.getParameter("phone");
		int phone = Integer.parseInt(sPhone);
		String role = request.getParameter("role");
		
		new MemberDAO().updateMember(new MemberDTO(id, pw, name, birthday, address, gender, email, phone, role));
		
		
		
		

		return new CommandAction(true, "home.do");
		
	}

}
