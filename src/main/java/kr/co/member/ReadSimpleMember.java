package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.MemberDTO;
import kr.co.main.Command;

public class ReadSimpleMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MemberDAO mdao = new MemberDAO();
		MemberDTO mdto = mdao.readSimpleMember(id);
		
		request.setAttribute("mdto", mdto);
		
		return new CommandAction(false, "member/readSimpleMember.jsp");
	}

}
