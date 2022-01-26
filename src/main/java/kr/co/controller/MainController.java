package kr.co.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.co.domain.CommandAction;
import kr.co.information.DeleteInformation;
import kr.co.information.InsertInformation;
import kr.co.information.ListInformation;
import kr.co.information.ReadInformation;
import kr.co.information.ReplyInformation;
import kr.co.information.ReplyUIInformation;
import kr.co.information.SearchInformation;
import kr.co.information.UpdateInformation;
import kr.co.information.UpdateUIInformation;
import kr.co.information.WriteUIInformation;
import kr.co.main.Command;
import kr.co.main.HomeMain;
import kr.co.member.DeleteMember;
import kr.co.member.DeleteUIMember;
import kr.co.member.IdCheckMember;
import kr.co.member.InsertMember;
import kr.co.member.InsertUIMember;
import kr.co.member.ListMember;
import kr.co.member.LoginMember;
import kr.co.member.LoginUIMember;
import kr.co.member.LogoutMember;
import kr.co.member.MyCountMember;
import kr.co.member.MyPageMember;
import kr.co.member.ReadMember;
import kr.co.member.ReadSimpleMember;
import kr.co.member.SearchMember;
import kr.co.member.UpdateMember;
import kr.co.member.UpdateRoleMember;
import kr.co.member.UpdateUIMember;
import kr.co.notice.DeleteNotice;
import kr.co.notice.InsertNotice;
import kr.co.notice.ListNotice;
import kr.co.notice.ReadNotice;
import kr.co.notice.UpdateNotice;
import kr.co.notice.UpdateUINotice;
import kr.co.notice.WriteUINotice;
import kr.co.posting.DeletePosting;
import kr.co.posting.InsertPosting;
import kr.co.posting.ListPosting;
import kr.co.posting.ReadPosting;
import kr.co.posting.ReplyPosting;
import kr.co.posting.ReplyUIPosting;
import kr.co.posting.SearchPosting;
import kr.co.posting.UpdatePosting;
import kr.co.posting.UpdateUIPosting;
import kr.co.posting.WriteUIPosting;


@WebServlet("*.do")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MainController() {}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		Map<String, Command> menus = new HashMap<String, Command>();
		
		
		menus.put("/home.do", new HomeMain());
		menus.put("/idcheck.do", new IdCheckMember());
		
		menus.put("/listPosting.do",  new ListPosting());
		menus.put("/writeuiPosting.do", new WriteUIPosting());
		menus.put("/insertPosting.do", new InsertPosting());
		menus.put("/readPosting.do", new ReadPosting());
		menus.put("/updateuiPosting.do", new UpdateUIPosting());
		menus.put("/updatePosting.do", new UpdatePosting());
		menus.put("/deletePosting.do", new DeletePosting());
		menus.put("/replyuiPosting.do", new ReplyUIPosting());
		menus.put("/replyPosting.do", new ReplyPosting());
		menus.put("/searchPosting.do", new SearchPosting());
		
		menus.put("/insertuiMember.do", new InsertUIMember());
		menus.put("/insertMember.do", new InsertMember());
		menus.put("/listMember.do", new ListMember());
		menus.put("/readMember.do", new ReadMember());
		menus.put("/updateuiMember.do", new UpdateUIMember());
		menus.put("/updateMember.do", new UpdateMember());
		menus.put("/updateRoleMember.do", new UpdateRoleMember());
		menus.put("/deleteuiMember.do", new DeleteUIMember());
		menus.put("/deleteMember.do", new DeleteMember());
		menus.put("/loginuiMember.do", new LoginUIMember());
		menus.put("/loginMember.do", new LoginMember());
		menus.put("/logoutMember.do", new LogoutMember());
		menus.put("/readSimpleMember.do", new ReadSimpleMember());
		menus.put("/searchMember.do", new SearchMember());
		menus.put("/myPageMember.do", new MyPageMember());
		menus.put("/myCountMember.do", new MyCountMember());
		
		menus.put("/listNotice.do",  new ListNotice());
		menus.put("/writeuiNotice.do", new WriteUINotice());
		menus.put("/insertNotice.do", new InsertNotice());
		menus.put("/readNotice.do", new ReadNotice());
		menus.put("/updateuiNotice.do", new UpdateUINotice());
		menus.put("/updateNotice.do", new UpdateNotice());
		menus.put("/deleteNotice.do", new DeleteNotice());
		

		

		menus.put("/information.do", new ListInformation());
		menus.put("/writeuiInformation.do", new WriteUIInformation());
		menus.put("/insertInformation.do", new InsertInformation());
		menus.put("/listInformation.do", new ListInformation());
		menus.put("/searchInformation.do", new SearchInformation());
		menus.put("/readSimpleInformation.do", new ReadSimpleMember());
		menus.put("/searchInformation.do", new SearchInformation());
		menus.put("/replyuiInformation.do", new ReplyUIInformation());
		menus.put("/replyInformation.do", new ReplyInformation());
		menus.put("/readInformation.do", new ReadInformation());
		menus.put("/updateuiInformation.do", new UpdateUIInformation());
		menus.put("/updateInformation.do", new UpdateInformation());
		menus.put("/deleteInformation.do", new DeleteInformation());
		
		
		
		
		
		
		
		
		
		kr.co.main.Command menu = menus.get(sp);
		
		
		if(menu != null) {
			CommandAction action= menu.execute(request, response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}else {
			
			response.getWriter().append("서비스 준비중입니다.");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
