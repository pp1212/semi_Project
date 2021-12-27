package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.QnADAO;
import com.sist.vo.QnAVO;
import javax.servlet.jsp.*;
public class InsertQnAOKAction implements SistAction {
	
	public QnADAO dao;
	public InsertQnAOKAction() {
		dao = new QnADAO();
	}
	

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		QnAVO b = new QnAVO();
		int qna_no = dao.getNextNo();
		
		
		b.setQna_no(qna_no);
		b.setQna_title(request.getParameter("qna_title"));
		b.setQna_content(request.getParameter("qna_content"));
		b.setCust_id(request.getParameter("cust_id"));
		System.out.println(request.getParameter("qna_title"));
		
		
		int re = dao.insertQnA(b);
		String viewPage = "";
		if(re == 1) {
			viewPage = "insertQnAOK.jsp";
		}else {
			viewPage = "error_QnA.jsp";
			request.setAttribute("msg_QnA", "문의등록에 실패하였습니다");
		}
		return viewPage;
	}

}
