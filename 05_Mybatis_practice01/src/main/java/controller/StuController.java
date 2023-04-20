package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.StuListService;
import service.StuService;


@WebServlet("*.do")

public class StuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StuController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String URI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = URI.substring(contextPath.length());
		
		StuService service = null;
		ActionForward af = null;
		
		switch(urlMapping) {
		case "/list.do":
			service = new StuListService();
			break;
		}
		
		if(service != null) {
			af = service.execute(request, response);
		}
		
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getPath());
			}else {
				request.getRequestDispatcher(af.getPath()).forward(request, response);
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
