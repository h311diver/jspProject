package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PostingDTO;
import kr.co.main.Command;

public class UpdateUIPosting implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		PostingDTO pdto = new PostingDAO().updateuiPosting(num);
		
		request.setAttribute("pdto", pdto);
		
		return new CommandAction(false, "posting/updatePosting.jsp");
	}

}
