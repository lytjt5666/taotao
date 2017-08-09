package com.taotao.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {
	@Resource
	private ItemCatService itemCatServcie;
	
	@RequestMapping(value ="/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0")Long parentId){ //参数名不匹配
		List<EasyUITreeNode> list = itemCatServcie.getItemCatList(parentId);
		
		return list;
	}
}
