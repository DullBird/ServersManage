package com.server.user.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.server.base.StaticParam;
import com.server.user.service.IOnlineUserService;
import com.server.utils.page.Pagination;
import com.server.vo.user.UserVo;

/**
 * 在线用户的业务逻辑实现类
 * @author Dull Bird
 * @date 2015-8-19
 */
@Service("user.service.OnlineUserService")
public class OnlineUserService implements IOnlineUserService {

	@Override
	public void addOnlineUser(String sessionId, UserVo sessionUser) {
		Map<String, UserVo> onlineUserMap = StaticParam.ONLINE_USER_MAP;
		Iterator<Map.Entry<String, UserVo>> entries = onlineUserMap.entrySet().iterator();
		while(entries.hasNext()){
			Map.Entry<String, UserVo> entry = entries.next();
			//判断此次添加的用户是否已经存在在在线用户map上
			if(entry.getValue().getId() == sessionUser.getId()){
				//此用户已经存在在在线用户map上（已登录），剔除原来，保存现在
				StaticParam.ONLINE_USER_MAP.remove(entry.getKey());
				break;
			}
		}
		StaticParam.ONLINE_USER_MAP.put(sessionId, sessionUser);
	}

	@Override
	public void delOnlineUser(String sessionId) {
		StaticParam.ONLINE_USER_MAP.remove(sessionId);
	}

	@Override
	public Pagination<UserVo> queryOnlineUser(int toPage, int pageSize) {
		int startNum = (toPage-1)*pageSize+1;
		int endNum = toPage*pageSize;
		Map<String, UserVo> onlineUserMap = StaticParam.ONLINE_USER_MAP;
		Iterator<Map.Entry<String, UserVo>> entries = onlineUserMap.entrySet().iterator();
		List<UserVo> onlineUserListAll = new ArrayList<UserVo>();
		//把map转换成list
		while(entries.hasNext()){
			Map.Entry<String, UserVo> entry = entries.next();
			onlineUserListAll.add(entry.getValue());
		}
		Pagination<UserVo> pagination = new Pagination<UserVo>(pageSize, toPage,onlineUserListAll.size());
		List<UserVo> onlineUserList = new ArrayList<UserVo>();
		for(int i=(startNum-1);i<=(endNum-1);i++){
			if(i>=onlineUserListAll.size()){
				break;
			}
			onlineUserList.add(onlineUserListAll.get(i));
		}
		pagination.setObjLists(onlineUserList);
		return pagination;
	}
	
}
