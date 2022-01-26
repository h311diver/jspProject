package kr.co.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.dao.NoticeDAO;
import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;
import kr.co.domain.PageTO;

public class HomeMain implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int curPage = 1;

		
		String sCurPage = request.getParameter("curPage");
		if(sCurPage != null && !sCurPage.equals("")) {
			curPage = Integer.parseInt(sCurPage);
			
		}
		
		
		PageTO to = new PostingDAO().pageListPosting(curPage);
		
		request.setAttribute("to", to);
		
		request.setAttribute("listPosting", to.getListPosting());
		
		
		
	
		
		
		PageTO to1 = new MemberDAO().pageListMember(curPage);
		
		request.setAttribute("to1", to1);
		
		request.setAttribute("listMember", to1.getListMember());
		
		
		
		
		
		
		
		List<NoticeDTO> listNotice = new NoticeDAO().listNotice();
		
		request.setAttribute("listNotice", listNotice);
		
		
		return new CommandAction(false, "main/home.jsp");
	}
	

}
