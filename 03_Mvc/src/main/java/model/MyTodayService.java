package model;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MyTodayService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("today", new Date(System.currentTimeMillis()));
		// return "view/output.jsp"; => "view/output.jsp" 경로로 today 결과값을 보낸다.
		
		// 어디로 어떻게 갈 것인가?
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("view/output.jsp");
		actionForward.setRedirect(false);	// false가 forward 한다는 뜻
		return actionForward;
				
	}

}
