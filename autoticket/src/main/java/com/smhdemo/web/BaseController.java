package com.smhdemo.web;
/**
 * 
 *  
 * 
 */
public abstract class BaseController {
	public String getForwardPage(String pageFileName){
		return getPagePath()+"/"+pageFileName;
	}
	protected abstract String getPagePath();
}

