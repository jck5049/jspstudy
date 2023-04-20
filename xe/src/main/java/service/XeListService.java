package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.XeDAO;

public class XeListService implements IXeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("xeList", XeDAO.getInstance().list());
		
		return new ActionForward("xe/list.jsp", false);
	}

}
