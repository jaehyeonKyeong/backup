package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.CpEmp;
import kr.co.sist.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired
	private EmpService es;
	
	@RequestMapping(value="search_emp.do", method=GET)
	public String searchEmp(Model model) throws SQLException {
		List<CpEmp> list=es.searchAllEmp();
		model.addAttribute("emp_list",list);
		return "day0928/search_emp.jsp";
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView searchError(SQLException se) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("err/err");
		mav.addObject("err_msg",se);
		return mav;
	}
}//class
