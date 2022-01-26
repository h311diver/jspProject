package kr.co.posting;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.dao.PostingDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.PostingDTO;
import kr.co.main.Command;

public class InsertPosting implements Command{

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content =request.getParameter("content");
		
		
		
		
		for(int i=0;i<50;i++) {
		      
		      PostingDTO pdto = new PostingDTO(0, writer, title+i, content+i, null, 0, 0, 0, 0);
		      new PostingDAO().insertPosting(pdto);
		      }
			
			
		return new CommandAction(true, "listPosting.do");
	}
	

}
