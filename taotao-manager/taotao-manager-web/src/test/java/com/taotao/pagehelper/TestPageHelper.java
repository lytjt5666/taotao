package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;



public class TestPageHelper {
	
	@Test
	public void testPageHelper(){
		//1、获得Mapper代理对象
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring//applicationContext-*.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//2、设置分页
		PageHelper.startPage(1,6);//页码，每页显示几条  只对下面执行的第一个select有效
		//3、执行查询
		TbItemExample example = new TbItemExample();//不设置条件即查询所有
		List<TbItem> list = itemMapper.selectByExample(example);
		//4、获得分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		System.out.println("total" + total);
		int pages = pageInfo.getPages(); //一共有多少页
		System.out.println("pages" + pages);
		int pageSize = pageInfo.getPageSize();
		System.out.println("pageSize" + pageSize); //一页几条记录
	}
}
