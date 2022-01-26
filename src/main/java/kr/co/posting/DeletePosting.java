package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.main.Command;

public class DeletePosting implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		String sCurPage = request.getParameter("curPage");
		new PostingDAO().deletePosting(num);
		


		
		
		
		return new CommandAction(true, "listPosting.do?curPage="+sCurPage);
	}

}
