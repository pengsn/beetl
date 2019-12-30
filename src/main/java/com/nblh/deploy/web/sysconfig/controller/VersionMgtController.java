package com.nblh.deploy.web.sysconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 版本管理控制层
 */
@Controller
@RequestMapping("versionMgt")
public class VersionMgtController {
	
	/**
	 * 获取当前版本信息
	 * @param mv
	 * @return
	 */
	@RequestMapping("getVersion")
	public ModelAndView getVersion(ModelAndView mv) {
		mv.addObject("version" , "V2.2.1");
		mv.setViewName("version");
		return mv;
	}
	
	
}
