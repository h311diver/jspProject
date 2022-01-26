package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PostingDTO;
import kr.co.main.Command;

public class ReplyPosting implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPnum = request.getParameter("pnum");
		int pnum = Integer.parseInt(sPnum);
		
		
		String sCurPage = request.getParameter("curPage");
		
		
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostingDTO pdto = new PostingDTO(0, writer, title, content, null, 0, 0, 0, 0);
		
		new PostingDAO().replyPosting(pdto, pnum);
		
		
			
		return new CommandAction(true, "listPosting.do?curPage="+sCurPage);
	}

}
