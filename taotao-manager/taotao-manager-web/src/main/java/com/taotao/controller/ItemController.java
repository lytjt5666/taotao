package com.taotao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * 商品查询
 * */
@Controller
public class ItemController {
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping(value = "/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping(value ="/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){   //Integer可以为空，int不可为空
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		
		return result;
	}
}
