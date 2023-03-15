package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZixunfankuiEntity;
import com.entity.view.ZixunfankuiView;

import com.service.ZixunfankuiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2023-03-07 07:08:39
 */
@RestController
@RequestMapping("/zixunfankui")
public class ZixunfankuiController {
    @Autowired
    private ZixunfankuiService zixunfankuiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunfankuiEntity zixunfankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			zixunfankui.setShangjiabianhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			zixunfankui.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunfankuiEntity> ew = new EntityWrapper<ZixunfankuiEntity>();

		PageUtils page = zixunfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunfankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunfankuiEntity zixunfankui, 
		HttpServletRequest request){
        EntityWrapper<ZixunfankuiEntity> ew = new EntityWrapper<ZixunfankuiEntity>();

		PageUtils page = zixunfankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunfankui), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunfankuiEntity zixunfankui){
       	EntityWrapper<ZixunfankuiEntity> ew = new EntityWrapper<ZixunfankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunfankui, "zixunfankui")); 
        return R.ok().put("data", zixunfankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunfankuiEntity zixunfankui){
        EntityWrapper< ZixunfankuiEntity> ew = new EntityWrapper< ZixunfankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunfankui, "zixunfankui")); 
		ZixunfankuiView zixunfankuiView =  zixunfankuiService.selectView(ew);
		return R.ok("查询咨询反馈成功").put("data", zixunfankuiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunfankuiEntity zixunfankui = zixunfankuiService.selectById(id);
        return R.ok().put("data", zixunfankui);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunfankuiEntity zixunfankui = zixunfankuiService.selectById(id);
        return R.ok().put("data", zixunfankui);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunfankuiEntity zixunfankui, HttpServletRequest request){
    	zixunfankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunfankui);
        zixunfankuiService.insert(zixunfankui);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunfankuiEntity zixunfankui, HttpServletRequest request){
    	zixunfankui.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zixunfankui);
        zixunfankuiService.insert(zixunfankui);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZixunfankuiEntity zixunfankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunfankui);
        zixunfankuiService.updateById(zixunfankui);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunfankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZixunfankuiEntity> wrapper = new EntityWrapper<ZixunfankuiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shangjia")) {
			wrapper.eq("shangjiabianhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = zixunfankuiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
