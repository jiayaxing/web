package com.jiayaxing.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiayaxing.web.dao.OrderInfoMapper;


@Service("orderService")
public class OrderService {
	
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	public List<Map<String, Object>> getOrderList(Map<String, Object> param) throws Exception {
		List<Map<String,Object>> listQuery = orderInfoMapper.getOrderList(param);
		if(null!=listQuery&&listQuery.size()>0){
			int totalSize = orderInfoMapper.getOrderListTotalSize(param);
			listQuery.get(0).put("totalSize", totalSize);
		}
		return listQuery;
	}
}
