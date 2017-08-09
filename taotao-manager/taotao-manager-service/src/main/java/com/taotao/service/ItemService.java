package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	//通过itemId拿到商品信息
	TbItem getItemById(Long itemId);
	
	EasyUIDataGridResult getItemList(int page,int rows);
}
