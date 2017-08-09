package com.taotao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

/**
 * 商品查询serviceImpl
 * */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//分页处理
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//返回一个EasyUIDataGridResult处理结果
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		easyUIDataGridResult.setRows(list);
		return easyUIDataGridResult;
	}

}
