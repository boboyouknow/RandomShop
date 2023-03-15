package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZixunfankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZixunfankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZixunfankuiView;


/**
 * 咨询反馈
 *
 * @author 
 * @email 
 * @date 2023-03-07 07:08:39
 */
public interface ZixunfankuiService extends IService<ZixunfankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZixunfankuiVO> selectListVO(Wrapper<ZixunfankuiEntity> wrapper);
   	
   	ZixunfankuiVO selectVO(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
   	
   	List<ZixunfankuiView> selectListView(Wrapper<ZixunfankuiEntity> wrapper);
   	
   	ZixunfankuiView selectView(@Param("ew") Wrapper<ZixunfankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZixunfankuiEntity> wrapper);
   	

}

