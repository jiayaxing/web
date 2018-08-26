package com.jiayaxing.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jiayaxing.web.service.OrderService;

@RestController
@RequestMapping(value="api/orderController")
public class OrderController {
	
	@Resource
	OrderService orderService;
	
	@RequestMapping(value = "getOrderList", method = RequestMethod.POST)
	public Map<String, Object> getOrderList(@RequestBody JSONObject jsonObject,HttpServletRequest request) {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Map<String,Object> requstMap = new HashMap<String,Object>();
		try {
			String currentPage = jsonObject.getString("currentPage");
			String pageSize = jsonObject.getString("pageSize");
			
			Integer startIndex = 0;
			startIndex = (Integer.parseInt(currentPage)-1) * Integer.parseInt(pageSize); 
			
			requstMap.put("startIndex", startIndex);
			requstMap.put("pageSize", Integer.parseInt(pageSize));
			
			if(jsonObject.containsKey("dateStart")){
				requstMap.put("dateStart", jsonObject.getString("dateStart"));
			}
			if(jsonObject.containsKey("dateEnd")){
				requstMap.put("dateEnd", jsonObject.getString("dateEnd")+" 23:59:59");
			}
			if(jsonObject.containsKey("orderType")){
				requstMap.put("orderType", jsonObject.getString("orderType"));
			}
			if(jsonObject.containsKey("status")){
				String statusStr = jsonObject.getString("status");
				List<Map<String,Object>> statusList = new ArrayList<>();
				String[] statusArray = statusStr.split(",");
				for (int i = 0; i < statusArray.length; i++) {
					Map<String, Object> statusMap = new HashMap<>();
					statusMap.put("status", statusArray[i]);
					statusList.add(statusMap);
				}
				requstMap.put("statusList", statusList);
				//requstMap.put("status", jsonObject.getString("status"));
			}
			if(jsonObject.containsKey("question")){
				requstMap.put("question", jsonObject.getString("question"));
			}
			
			List<Map<String, Object>> resultList = orderService.getOrderList(requstMap);
			returnMap.put("state", "successe");
			returnMap.put("code", "0");//没有错误
	    	returnMap.put("list", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("state", "failed");
			returnMap.put("code", "1");//普通错误
	    	returnMap.put("message", "订单查询出现错误");
		}
		return returnMap;
	}
}
