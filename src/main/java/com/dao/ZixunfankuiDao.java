package com.dao;

import com.entity.ZixunfankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZixunfankuiVO;
import com.entity.view.ZixunfankuiView;


/**
 * 咨询反馈
 * 
 * @author 
 * @email 
 * @date 2023-03-07 07:08:39
 */
public interface ZixunfankuiDao extends BaseMapper<ZixunfankuiEntity> {
	
	List<ZixunfankuiVO> selectListVO(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
	
	ZixunfankuiVO selectVO(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
	
	List<ZixunfankuiView> selectListView(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);

	List<ZixunfankuiView> selectListView(Pagination page,@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
	
	ZixunfankuiView selectView(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
	

}
