package kr.co.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.NoticeDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.NoticeDTO;
import kr.co.main.Command;

public class UpdateUINotice implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sNum = request.getParameter("num");
		int num = Integer.parseInt(sNum);
		
		NoticeDTO ndto = new NoticeDAO().updateuiNotice(num);
		
		request.setAttribute("ndto", ndto);
		
		return new CommandAction(false, "notice/updateNotice.jsp");
	}

}
