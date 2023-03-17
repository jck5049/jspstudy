package practice05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Practice05_2")

public class Practice05_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Practice05_2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");	// 파라미터 값이 한글이면 필수로 해줘야 하는 작업!
		
		String model = request.getParameter("model");
		System.out.println("Practice05_2 : " + model);
		
		// 프로젝트 서블릿 실제 경로 확인.
		System.out.println(request.getServletContext().getRealPath("practice05"));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
