package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.CustomerDAO;
import com.sist.vo.CustomerVO;

public class Find_idAction implements SistAction {
	
	public CustomerDAO dao;
	public Find_idAction() {
		dao = new CustomerDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		return "find_id.jsp";
	}

}
