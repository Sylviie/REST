package com.sylvie.controller;

import com.sylvie.model.Employee;
import org.springframework.web.bind.annotation.*;

/**
 * Spring MVC RESTful注解
 */

@RestController
@RequestMapping("test")
public class TestController {

	/***
	 * 多个path value 和 method
	 */
	@RequestMapping(value={"xxx", "ddd"}, method = {RequestMethod.GET, RequestMethod.POST})
	public void test(){

	}

	/**
	 * params是规定请求时必须指定的参数名和参数值
	 * 例子：代表请求时，必须带有name的参数，并且值也必须是admin
	 */
	@RequestMapping(params = "name=admin")
	public void test2(){

	}

	@RequestMapping(params = "name!=admin")
	public void test3(){

	}

	/**
	 *
	 * @RequestParam注解: 规定请求时必须带有指定的参数，但是参数值不规定
	 */
    @RequestMapping("login")
	public void login(@RequestParam String username, @RequestParam String password){
		System.out.println("login 方法....");
	}

	/**
	 * headers规定，请求时必须的汽油特定的头信息
	 */
/*	@RequestMapping(value = "headers", headers = "context-type=text/html")
	public void headers(){
		System.out.println("headers方法...html");
	}

	@RequestMapping(value = "headers", headers = "context-type=text/xml")
	public void headers1(){
		System.out.println("headers1方法...xml");
	}*/


	/**
	 * 消费的数据类型
	 * 相当于配置了headers = "context-type=text/xml"
	 * content-type : 代表当前传过来的数据是什么格式
	 */
/*	@RequestMapping(value = "consumes", consumes = "text/xml")
	public void consumes(){
		System.out.println("consumes方法...xml");
	}

	@RequestMapping(value = "consumes", consumes = "text/html")
	public void consumes1(){
		System.out.println("consumes方法...html");
	}*/

	/**
	 * 生产的数据类型
	 * 相当于配置了headers="accept=text/html"
	 * accept : 期望返回的数据类型
	 * 还代表响应的头信息里面有content-type=text/html
	 *
	 */
	@RequestMapping(value = "produces", consumes = "text/xml")
	public void produces(){
		System.out.println("produces方法...xml");
	}

	@RequestMapping(value = "produces", consumes = "text/html")
	public void produces1(){
		System.out.println("produces方法...html");
	}

	/**
	 * @RequestBody 把body里带的Json请求封装在对象里面（把请求体的所有内容都封装到指定的对象中）
	 * @RequestMapping employee
	 */
	@RequestMapping("employee")
	public void testEmployee(@RequestBody Employee employee){
		System.out.println(employee);
	}

}
