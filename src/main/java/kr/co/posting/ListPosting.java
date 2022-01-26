package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PageTO;
import kr.co.main.Command;

public class ListPosting implements Command{

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
		
		return new CommandAction(false, "posting/listPosting.jsp");
	}
	
	

}
