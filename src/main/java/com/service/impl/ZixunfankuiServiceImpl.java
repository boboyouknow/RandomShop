package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZixunfankuiDao;
import com.entity.ZixunfankuiEntity;
import com.service.ZixunfankuiService;
import com.entity.vo.ZixunfankuiVO;
import com.entity.view.ZixunfankuiView;

@Service("zixunfankuiService")
public class ZixunfankuiServiceImpl extends ServiceImpl<ZixunfankuiDao, ZixunfankuiEntity> implements ZixunfankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZixunfankuiEntity> page = this.selectPage(
                new Query<ZixunfankuiEntity>(params).getPage(),
                new EntityWrapper<ZixunfankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZixunfankuiEntity> wrapper) {
		  Page<ZixunfankuiView> page =new Query<ZixunfankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZixunfankuiVO> selectListVO(Wrapper<ZixunfankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZixunfankuiVO selectVO(Wrapper<ZixunfankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZixunfankuiView> selectListView(Wrapper<ZixunfankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZixunfankuiView selectView(Wrapper<ZixunfankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
