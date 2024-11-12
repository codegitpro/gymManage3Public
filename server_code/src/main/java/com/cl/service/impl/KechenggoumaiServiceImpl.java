package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KechenggoumaiDao;
import com.cl.entity.KechenggoumaiEntity;
import com.cl.service.KechenggoumaiService;
import com.cl.entity.view.KechenggoumaiView;

@Service("kechenggoumaiService")
public class KechenggoumaiServiceImpl extends ServiceImpl<KechenggoumaiDao, KechenggoumaiEntity> implements KechenggoumaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechenggoumaiEntity> page = this.selectPage(
                new Query<KechenggoumaiEntity>(params).getPage(),
                new EntityWrapper<KechenggoumaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechenggoumaiEntity> wrapper) {
		  Page<KechenggoumaiView> page =new Query<KechenggoumaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechenggoumaiView> selectListView(Wrapper<KechenggoumaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechenggoumaiView selectView(Wrapper<KechenggoumaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
