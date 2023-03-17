package ex05_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RedirectServlet1")

public class RedirectServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RedirectServlet1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리다이렉트 첫 번째 서블릿에는 파라미터 확인 가능하지만 두 번째 서블릿으로 이동시 파라미터가 끊긴다.
		// 즉, 파라미터는 첫 번째 서블릿에만 확인이 가능하다.
		
		// 리다이렉트 이전(첫 번째 요청)의 파라미터 확인
		// 첫 번째 요청 : /01_Servlet/RedirectServlet1?model=Tv
		
		String model = request.getParameter("model");
		System.out.println("RedirectServlet1 : " + model);
		
		// redirect를 이용해서 다른 서블릿(다른 서버 경로)으로 이동하기
		response.sendRedirect("/01_Servlet/RedirectServlet2"); // ?model=Tv << 추가해주면 2번째 서블릿에도 파라미터 확인이 가능하다.
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
