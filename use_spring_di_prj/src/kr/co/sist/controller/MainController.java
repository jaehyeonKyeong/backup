package kr.co.sist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day0914.DeptDomain;
import day0914.MyBatisService;

@SuppressWarnings("serial")
public class MainController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext ac=new ClassPathXmlApplicationContext
				("day0914/applicationContext.xml");
		
		MyBatisService mbs=ac.getBean(MyBatisService.class);
		
		List<DeptDomain> list=mbs.searchDept();
		request.setAttribute("list", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("day0914/dept_list.jsp");
		rd.forward(request, response);
		
		
		
	}//doPost

}//class
