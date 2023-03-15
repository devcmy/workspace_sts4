package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import io.swagger.annotations.ApiOperation;

/*
	1. GET    - /guest : 모든 데이터를 요청한다.
	2. POST   - /guest : 데이터를 추가한다.
	3. GET    - /guest/n : n번째 데이터를 요청한다.
	4. PUT    - /guest/n : n번째 데이터를 수정한다.
	5. DELETE - /guest/n : n번째 데이터를 제거한다.
	*/
@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@ApiOperation(value = "방명록리스트")
	@GetMapping(value = "/guest", produces="application/json;charset=UTF-8")
	public Map<String, Object> guest_list() throws Exception { //뭐가들어올지몰라 object
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code=1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		data = guestService.selectAll();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
		
	}
	
	public Map<String, Object> guest_detail()throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code=1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
		
	}
	
	public Map<String, Object> guest_write_action()throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code=1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
		
	}
	
	public Map<String, Object> guest_modify_action()throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code=1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
		
	}
	
	public Map<String, Object> guest_remove_action()throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code=1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
		
	}
	
	
	
}
