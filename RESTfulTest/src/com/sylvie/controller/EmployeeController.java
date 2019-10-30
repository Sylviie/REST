package com.sylvie.controller;

import com.sylvie.model.Employee;
import com.sylvie.model.Salary;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * employee controller
 */
/*@Controller
@ResponseBody   */
@RestController
@RequestMapping("employees")
public class EmployeeController {

	/**
	 * Get all employees
	 * 1. 确定资源  /employees
	 * 2. 确定请求方式  GET
	 * 3. 确定返回结果（类型，头信息，状态码）员工集合, content-type=application/json, 200
	 * @return
	 */
	//@RequestMapping(value = "employees", method = RequestMethod.GET)
	@GetMapping
	public List<Employee> list(){
		ArrayList<Employee> list = new ArrayList<>();
		list.add(new Employee(1L, "admin"));
		list.add(new Employee(2L, "root"));
		return list;
	}

	/**
	 * Get a employee {路径传参}
	 * 1. 确定资源  /employees/{name}  //{} 路径占位符
	 * 2. 确定请求方式  GET
	 * 3. 确定返回结果（类型，头信息，状态码）员工对象, content-type=application/json, 200
	 * @return
	 *
	 * 如果@PathVariable注解没有设置value，默认就是去路径上找相同名称的参数
	 */
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id){
        return new Employee(id,"admin");
	}

	/**
	 * 删除一个员工
	 * 1. 确定资源  /employees/{id}  //{} 路径占位符
	 * 2. 确定请求方式  DELETE
	 * 3. 确定返回结果（类型，头信息，状态码）空文档, content-type=application/json, 204
	 */
	@DeleteMapping("{id}")
	public void deleteEmployee(Long id, HttpServletResponse response){
		System.out.println("删除id为:"+id+"的员工");
		response.setStatus(HttpServletResponse.SC_NO_CONTENT); //设置状态码
	}

	/**
	 * 获取某个员工某个月的薪资记录
	 * 1. 确定资源  /employees/{employeeId}/salaries/{month}
	 * 2. 确定请求方式  GET
	 * 3. 确定返回结果（类型，头信息，状态码）薪资对象, content-type=application/json, 200
	 *
	 * @DataTimeFormat 前台传日期参数到后台接收时使用的注解
	 * @JsonFormat 后台返回json数据给前台时使用的注解
	 *
	 * @return
	 */
	@GetMapping("{employeeId}/salaries/{month}")
	public Salary getSalaryByEmployee(@PathVariable Long employeeId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM") Date month){
       return new Salary(1L, employeeId, BigDecimal.TEN, month);
	}

	/**
	 *给某个员工添加一条薪资记录
	 * 1. 确定资源  /employees/{employeeId}/salaries
	 * 2. 确定请求方式  POST
	 * 3. 确定返回结果（类型，头信息，状态码）薪资对象, content-type=application/json, 201
	 * 用表单提交 在body里面输入新增信息
	 * 路径占位符可以根据对象的Setter自动封装到对象同名的属性上
	 */
	@PostMapping("{employeeId}/salaries")
	public Salary save(Salary salary){
    return salary;
	}

	/**
	 * 更新员工数据
	 * @param employee
	 * @return
	 */
	@PutMapping("{id}")
	public Employee updateById(Employee employee){
		System.out.println("update employee...");
		return employee;
	}
}
