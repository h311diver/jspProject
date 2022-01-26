package kr.co.member;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.MemberDAO;

import kr.co.domain.CommandAction;

import kr.co.domain.PageTO;
import kr.co.main.Command;

public class ListMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int curPage = 1;
		
		String sCurPage = request.getParameter("curPage");
		if(sCurPage != null && !sCurPage.equals("")) {
			curPage = Integer.parseInt(sCurPage);
			
		}
		
		
		PageTO to1 = new MemberDAO().pageListMember(curPage);
		
		request.setAttribute("to1", to1);
		
		request.setAttribute("listMember", to1.getListMember());
		
		
		
		return new CommandAction(false, "member/listMember.jsp");

	}

}
