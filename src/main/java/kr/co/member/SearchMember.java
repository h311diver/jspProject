package kr.co.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;
import kr.co.main.Command;

public class SearchMember implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int curPage = 1;

		String sCurPage = request.getParameter("curPage");
		if (sCurPage != null && !sCurPage.equals("")) {
			curPage = Integer.parseInt(sCurPage);
			if (curPage <= 1) {
				curPage = 1;
			}
		}
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		PageTO to = new MemberDAO().searchMember(criteria,keyword,curPage);
		
		request.setAttribute("to", to);
		
		request.setAttribute("listMember", to.getListMember());
		

		return new CommandAction(false, "member/searchListMember.jsp");
	}

}
