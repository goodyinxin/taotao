package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.service.ItemService;


/**商品查询的service
 * @author yinxin
 * @2017年3月5日
 * @ItemServiceImpl
 */
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItemById(Long itemId) {
		TbItemExample example = new TbItemExample();
		//创建查询条件
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example );
		//判断list里是否为空
		TbItem tbItem = null;
		if(list != null && list.size() > 0){
			 tbItem = list.get(0);
		}
		
		return tbItem;
	}

}
