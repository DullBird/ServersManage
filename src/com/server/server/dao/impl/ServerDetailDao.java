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
	public Pagination<ServerDetailVo> queryServerList(int toPage,int pageSize,
			Long stId,Long userId,Integer status,Long id) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		sql.append(" select sd.id,sd.name,sd.cpu,sd.memory,sd.harddisk, ");
		sql.append(" sd.remark,sd.status,sd.createdate,sd.createuid,sd.createuser, ");
		sql.append(" sd.ip,sd.publicip,sd.os,sd.isvirtual,sd.model,sd.services, ");
		sql.append(" sd.postdevicecode, ");
		sql.append(" listagg(st.name,'&nbsp;&nbsp;') within group (order by st.name) as stName ");
		sql.append(" from tb_server_serverdetail sd,tb_server_serverrelation sr,tb_server_servertype st ");
		if(null != userId && userId != 0){
			sql.append(" ,tb_server_userserver us,tb_server_user u ");
		}
		sql.append(" where sd.id=sr.sid(+) ");
		sql.append(" and sr.stid=st.id(+) ");
		if(null != stId && stId != 0){
			sql.append(" and st.id=? ");
			args.add(stId);
		}
		if(null != userId && userId != 0){
			sql.append(" and sd.id = us.sid ");
			sql.append(" and us.userid = u.id ");
			sql.append(" and u.id=? ");
			args.add(userId);
		}
		if(null != status){
			sql.append(" and sd.status=? ");
			args.add(status);
		}
		if(null != id){
			sql.append(" and sd.id=? ");
			args.add(id);
		}
		sql.append(" group by sd.id,sd.name,sd.cpu,sd.memory,sd.harddisk,sd.remark, ");
		sql.append(" sd.status,sd.createdate,sd.createuid, ");
		sql.append(" sd.createuser,sd.ip,sd.publicip,sd.os, ");
		sql.append(" sd.isvirtual,sd.model,sd.services,sd.postdevicecode ");
		return this.queryForPage(toPage, pageSize, sql.toString(),
				ServerDetailVo.class, args.toArray());
	}

	@Override
	public int updateServer(ServerDetail server) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update tb_server_serverdetail set ");
		sql.append(" name=? , cpu=? , memory=? , harddisk=? , ");
		sql.append(" remark=? , ip=? , publicip=? , os=? , isvirtual=? , ");
		sql.append(" model=? , services=? , postdevicecode=? ");
		sql.append(" where id=? ");
		return this.saveORUpdate(sql.toString(), server.getName(),server.getCpu(),
				server.getMemory(),server.getHardDisk(),server.getRemark(),
				server.getIp(),server.getPublicIp(),server.getOs(),
				server.getIsVirtual(),server.getModel(),server.getServices(),
				server.getPostDeviceCode(),server.getId());
	}

}
