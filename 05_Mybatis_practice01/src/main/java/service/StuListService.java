package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.StuDTO;
import repository.StuDAO;

public class StuListService implements StuService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<StuDTO> studentList = StuDAO.getInstance().getStuList();
		
		request.setAttribute("studentList", studentList);
		
		
		return new ActionForward("stu/list.jsp", false);
	}

}
