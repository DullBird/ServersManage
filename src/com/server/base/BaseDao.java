package com.server.base;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.server.utils.page.Pagination;

/**
 * dao基类
 * @author DullBird
 * 
 */
@Repository("base.BaseDao")
public class BaseDao {
	
	private static Logger log = Logger.getLogger(BaseDao.class);
	
	private JdbcTemplate jdbcTemplate;

	@Resource(name = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Oracle sequence 从oracle 序列查找下一个值
	 * 
	 * @param sequenceName
	 * @author zengxiangtao
	 * @return long
	 * **/
	public long getSequenceId(String sequenceName) {
		StringBuffer sql = new StringBuffer(" SELECT ").append(sequenceName)
				.append(".NEXTVAL FROM DUAL");
		long id = 0;
		try {
			id = jdbcTemplate.queryForLong(sql.toString());
			log.info("-------->getSequenceId............. " + sequenceName
					+ " The New id:" + id);
		} catch (DataAccessException e) {
			log.error("-------->sequence :" + sequenceName
					+ ".............Exception msg:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return id;
	}

	/**
	 * 查询封装成对象
	 * 
	 * @param sql
	 *            查询的SQL
	 * @param args
	 *            参数
	 * @param mappedClass
	 *            封装的对象
	 * @author zengxiangtao
	 * @param <T>
	 * **/
	public <T> List<T> queryForListBean(String sql,Class<T> mappedClass,
			 Object... args) {
		List<T> rs = null;
		try {
			rs = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(mappedClass)
					, args);
			log.info("----->queryForListBean{" + sql + ","
					+ mappedClass.getName() + "}..... Result list size:"
					+ (null != rs ? rs.size() : "null"));
		} catch (DataAccessException e) {
			log.error("-------->queryForListBean{" + sql + ","
					+ mappedClass.getName() + "}.............Exception msg:"
					+ e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return rs;
	}

	/**
	 * 查出一个对象记录
	 * 
	 * @param sql
	 *            查询的SQL
	 * @param args
	 *            参数
	 * @param mappedClass
	 *            封装的对象
	 * @author zengxiangtao
	 * **/
	public <T> T queryForBean(String sql, Class<T> mappedClass, Object... args) {
		List<T> rs = queryForListBean(sql, mappedClass, args);
		if (null != rs && rs.size() > 0) {
			if (rs.size() > 1) {
				log.warn("-------->queryForBean(" + sql + ","
						+ mappedClass.getName()
						+ ").............The search Result is not only one!");
			}
			return rs.get(0);
		}
		return null;
	}

	/**
	 * 执行新增/更新/删除
	 * 
	 * @param sql
	 *            执行的SQL
	 * @param args
	 *            参数
	 * @author zengxiangtao
	 * **/
	public int saveORUpdate(String sql, Object... args) {
		int num = 0;
		try {
			num = jdbcTemplate.update(sql, args);
			log.info("----->saveORUpdate(" + sql + ")----> effective Num:"
					+ num);
		} catch (DataAccessException e) {
			log.error("-------->saveORUpdate(" + sql
					+ ").............Exception msg:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return num;
	}

	/**
	 * 查找某一个属性
	 * 
	 * @param sql
	 *            执行的SQL
	 * @param args
	 *            参数
	 * @param elementType
	 *            查询的属性类型
	 * @author zengxiangtao
	 * **/
	public <T> List<T> findProperty(String sql,	Class<T> elementType,
			Object... args) {
		List<T> rs = null;
		try {
			rs = jdbcTemplate.queryForList(sql, elementType, args);
			log.info("----->findProperty(" + sql + ")----> Result list size:"
					+ (null != rs ? rs.size() : "null"));
		} catch (DataAccessException e) {
			log.error("-------->findProperty(" + sql
					+ ").............Exception msg:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return rs;
	}

	/**
	 * 查询结果封装成map
	 * 
	 * @param sql
	 *            执行的SQL
	 * @param args
	 *            参数
	 * @author zengxiangtao
	 * **/
	public List<Map<String, Object>> queryForMapList(String sql, Object... args) {
		List<Map<String, Object>> rs = null;
		try {
			rs = jdbcTemplate.queryForList(sql, args);
			log.info("----->queryForMapList(" + sql
					+ ")----> Result list size:"
					+ (null != rs ? rs.size() : "null"));
		} catch (DataAccessException e) {
			log.error("-------->queryForMapList(" + sql
					+ ").............Exception msg:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return rs;
	}

	/**
	 * 查询结果封装成map
	 * 
	 * @param sql
	 *            执行的SQL
	 * @param args
	 *            参数
	 * @author zengxiangtao
	 * **/
	public Map<String,Object> queryForMap(String sql, Object... args) {
		Map<String, Object> map = null;
		try {
			map = jdbcTemplate.queryForMap(sql, args);
			log.info("BaseDAO----------->queryForMap-------> sql:" + sql);
		} catch (DataAccessException e) {
			log.error("BaseDAO-------->queryForMap(" + sql
					+ ").............Exception msg:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return map;
	}

	
	/**
	 * 分页函数
	 * @param pageSize
	 * @param toPage
	 * @param sql
	 * @param args
	 * @param mappedClass
	 * @return Pagination<T>
	 * @author flatychen
	 * @time   2013-7-4
	 */
	public <T> Pagination<T> queryForPage(int toPage, int pageSize, String sql,
			Class<T> mappedClass,Object... args ) {
		String countSql = Pagination.countSql(sql);
		String querySql = Pagination.pageSql(sql);
		// 得到分页条目总数量
		int totalCount = 	jdbcTemplate.queryForInt(countSql, args);
		//int totalCount = (Integer)o;
		Pagination<T> page = new Pagination<T>(pageSize, toPage,totalCount);
		//替换SQL
		String lastSql = page.generatePageSql(querySql);
		try {
			List<T> list = jdbcTemplate.query(lastSql,
					new BeanPropertyRowMapper<T>(mappedClass), args);
			log.info("BaseDAO----------->queryForPage-------> sql:" + lastSql);
			page.setObjLists(list);
		} catch (Exception e) {
			log.error("BaseDAO-------->queryForPage(" + lastSql
					+ ").............Exception msg:" + e.getMessage());
			e.printStackTrace();
		}
		return page;

	}
	
}
