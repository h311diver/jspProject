package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PostingDTO;
import kr.co.main.Command;

public class UpdatePosting implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sCurPage = request.getParameter("curPage");
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		
		
		String tilte = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PostingDTO pdto = new PostingDTO(num, writer, tilte, content, null, 0, 0, 0, 0);
		
		new PostingDAO().updatePosting(pdto);
		
		
		return new CommandAction(true, "readPosting.do?num="+num+"&curPage="+sCurPage);
	}

}
