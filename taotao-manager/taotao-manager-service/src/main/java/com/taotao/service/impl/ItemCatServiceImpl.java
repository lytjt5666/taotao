package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Resource 
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		// 根据id查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//将list转换成树形列表
		List<EasyUITreeNode> resultList =new ArrayList<EasyUITreeNode>();
		for(TbItemCat tbItemCat : list){
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			//将节点添加到list中
			resultList.add(node);
		}
		return resultList;
	}

}
