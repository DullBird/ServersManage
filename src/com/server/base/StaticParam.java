package com.server.base;

import java.util.HashMap;
import java.util.Map;

import com.server.vo.user.UserVo;

/**
 * 该变量存放全局静态变量
 * @author DullBird
 * @date 2014-7-7
 */
public class StaticParam {
	
	public static String HEIGHT_LIGHT = "height_light";
	public static String PAGE_BEAN = "pageBean";
	public static String SESSION_USER = "sessionUser";
	public static String SERVER_PROXY = "tb_server_proxy";
	public static String SERVER_WEBAPP = "tb_server_webapp";
	public static String SERVER_DATABASE = "tb_server_database";
	//记录在线用户的map，key为sessionId，value为UserVo对象
	public static Map<String, UserVo> ONLINE_USER_MAP = new HashMap<String, UserVo>();
	
}
