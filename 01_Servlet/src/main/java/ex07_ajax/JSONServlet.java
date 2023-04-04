package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/*
 	Dynamic Web Project에서 외부 라이브러리(*.jar)를 사용하는 방법
 	
 	방법 1. CATALINA_HOME\lib 디렉터리에 사용할 라이브러리를 추가한다.
 	방법 2. 컨텍스트(프로젝트)에 사용할 라이브러리를 추가한다. (수업에서 사용할 방법)
 		src/main/webapp/WEB-INF/lib 디렉터리에 외부 라이브러리 추가
*/

@WebServlet("/JSONServlet")

public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JSONServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
			// 요청 인코딩
			request.setCharacterEncoding("UTF-8");
			
			// 요청 파라미터
			String name = request.getParameter("name");
			String strAge = request.getParameter("age");
			int age = 0;
			if(strAge != null && strAge.isEmpty() == false) {
				age = Integer.parseInt(strAge);
			}
			
			// 이름 예외 처리
			if(name.length() < 2 || name.length() > 6) {
				throw new NameHandleException(name + "은(는) 잘못된 이름입니다" , 601);
			}
			
			// 나이 예외 처리
			if(age < 0 || age > 100) {
				throw new AgeHandleException(age + "살은 잘못된 나이입니다", 600);
			}
			
			
			
			
			/* 내 방법
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 잘못된 나이입니다");
			}
			if(name.length() < 2 || name.length() > 6) {
				throw new RuntimeException(name + "은 잘못된 이름입니다");
			}
			*/
			
			// 응답할 JSON 데이터
			JSONObject obj = new JSONObject();
			obj.put("name", name);
			obj.put("age", age);
			// System.out.println(obj.toString()); // {"name": "마돈나", "age": 50}
			
			// 응답데이터 타입
			response.setContentType("application/json; charset=UTF-8");	// json 마임타입! 정해진것.
			
			// 출력 스트림 생성
			PrintWriter out = response.getWriter();
			
			// 출력
			String resData = obj.toString();
			out.println(resData);	// 텍스트 형식으로 된 JSON 데이터를 응답한다.
			out.flush();
			out.close();
			
		}catch(MyHandleException e) {
			
			response.setContentType("text/plain; charset=UTF-8");
			
			response.setStatus(e.getErrorCode());
			
			response.getWriter().println(e.getMessage());
			
		}
		
		/* 내 방법
		catch(RuntimeException e) {
			
			// 예외 상황에 따른 응답 만들기
			// 응답코드 	: 600 (임의로 작성)
			// 응답메시지 	: 예외 객체 e에 저장된 message 필드 값
			
			// 응답메시지 타입
			response.setContentType("application/json; charset=UTF-8");
			
			// 응답코드(status)
			if(e.getMessage().contains("나이")) {
				response.setStatus(600);
			}else {
				response.setStatus(601);
			}
			
			// 응답메시지(responseText)
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
			out.flush();
			out.close();
			
		}
		*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
