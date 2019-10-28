package com.sylvie.controller;

import com.sylvie.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * employee controller
 */
@Controller
public class EmployeeController {

	/**
	 * Get all employees
	 * 1. 确定资源  /employees
	 * 2. 确定请求方式  GET
	 * 3. 确定返回结果（类型，头信息，状态码）员工集合, content-type=application/json, 200
	 * @return
	 */
	@RequestMapping("employees")
	@ResponseBody
	public List<Employee> list(){
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(1L, "admin"));
		list.add(new Employee(2L, "root"));
		return list;
	}
}
