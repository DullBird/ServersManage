package com.server.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.server.base.BaseDao;
import com.server.entity.ServerDetail;
import com.server.entity.ServerType;
import com.server.server.dao.IServerDetailDao;
import com.server.utils.page.Pagination;
import com.server.vo.server.ServerDetailVo;

/**
 * 
 * 服务器信息相关Dao实现类
 * @author Dull Bird
 * @date 2015-7-8
 * 
 */

@Repository("server.dao.ServerDao")
public class ServerDetailDao extends BaseDao implements IServerDetailDao {

	@Override
	public int addServer(ServerDetail server) {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into tb_server_serverdetail ");
		sql.append(" ( id, name, cpu, memory, harddisk, ");
		sql.append(" remark, status, createdate, createuid, ");
		sql.append(" createuser, ip, publicip, os, isvirtual, ");
		sql.append(" model, services, postdevicecode) ");
		sql.append(" values ");
		sql.append(" (?,?,?,?,?,?,1,sysdate,?,?,?,?,?,?,?,?,?) ");
		return this.saveORUpdate(sql.toString(),server.getId(),server.getName(),server.getCpu(),
				server.getMemory(),server.getHardDisk(),
				server.getRemark(),server.getCreateUid(),server.getCreateUser(),
				server.getIp(),server.getPublicIp(),server.getOs(),server.getIsVirtual(),
				server.getModel(),server.getServices(),server.getPostDeviceCode());
	}

	@Override
	public List<ServerType> queryServerTypeList() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from TB_SERVER_SERVERTYPE ");
		return this.queryForListBean(sql.toString(), ServerType.class);
	}

	@Override
	public long getSequenceId() {
		return this.getSequenceId("seq_tb_server_serverdetail");
	}

	@Override
	public Pagination<ServerDetailVo> queryServerList(int toPage,int pageSize,Long stId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" select * from TB_SERVER_SERVERDETAIL sd ");
		if(null != stId && stId != 0){
			sql.append(" where sd.id=sr.sid ");
			sql.append(" and sr.stid=? ");
			args.add(stId);
		}
		return this.queryForPage(toPage, pageSize, sql.toString(),
				ServerDetailVo.class, args.toArray());
	}

}
