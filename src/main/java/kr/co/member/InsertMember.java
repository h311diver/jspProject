package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class InsertMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String sPhone = request.getParameter("phone");
		int phone = Integer.parseInt(sPhone);
		String role = "guest";
	
		if(!pw1.equals(pw2)) {
			return new CommandAction(true, "insertuiMember.do");
		}
		
		
		
		for(int i=0;i<50;i++) {
		      
		      MemberDTO mdto = new MemberDTO(id+i, pw1, name+i, birthday, address, gender, email, phone, role);
		      new MemberDAO().insertMember(mdto);
		      }
		
		
		

	return new CommandAction(true, "home.do");
		
		
		
	}

}
