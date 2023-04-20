package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.XeDTO;
import repository.XeDAO;

public class XeDetailService implements IXeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 상세보기할 게시글의 번호 xeNo 
		int xeNo = Integer.parseInt(request.getParameter("xeNo"));
		
		// xeNo값을 가진 레코드(행, 데이터)를 DB에서 가져온다.
		XeDTO xe = XeDAO.getInstance().detail(xeNo);
		
		
		request.setAttribute("xe", xe);
		
		
		return new ActionForward("xe/detail.jsp", false);
	}

}
