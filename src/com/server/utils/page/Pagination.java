package com.server.utils.page;

import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 * 分页工具类
 * @author DullBird
 * @param <T>
 */
public class Pagination<T> {
	
	private static int DEFAULT_PAGE_SIZE=20;
	// 总记录数
	private int totalRows = 0;
	// 页大小
	private int pageSize = 10;

	// 请求页
	private int toPage = 1;
	// 查询结果集
	private List<T> objLists;
	
	//页码的起始与结束
	private int begin = 1;
	private int end = 1;
	//分页页码显示个数
	private int paginationSize = 9;

	//URL
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	//总页数
	private int totalPage = 1;
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		if (totalRows > 0) {
			int total = totalRows / pageSize;
			if (totalRows % pageSize != 0) {
				total++;
			}
			totalPage= total;
		}
		else totalPage= 1;
	}


	/*
	 * Oracel 查询总行数语句
	 * 
	 * @param querySql
	 * 
	 * @return
	 */
	public static String countSql(String querySql) {
		return new StringBuffer("SELECT COUNT(*) as count FROM (")
				.append(querySql).append(" ) flaty").toString();
	}

	/*
	 * Oracle 分页语句
	 * 
	 * @param querySql
	 * 
	 * @return
	 */
	public static String pageSql(String querySql) {
		StringBuffer pageSql = new StringBuffer(
				"SELECT *  FROM ( SELECT wrap.*, ROWNUM as brow FROM ( ");
		pageSql.append(querySql).append(
				" ) wrap WHERE ROWNUM <= {para1} ) WHERE brow > {para2}  ");
		return pageSql.toString();
	}

	public String generatePageSql(String querySql) {
		querySql = StringUtils.replace(querySql, "{para1}", toPage * pageSize
				+ "");
		querySql = StringUtils.replace(querySql, "{para2}", (toPage - 1)
				* pageSize + "");
		return querySql;
	}
	
	public Pagination(){
		this.totalRows = 0;
		this.pageSize = DEFAULT_PAGE_SIZE;
		setTotalPage();
	}

	/**
	 * @param pageSize
	 * @param toPage
	 */
	public Pagination(int pageSize, int toPage, int totalRows) {
		super();
		//总行数合法化
		if(totalRows <= 0){
			this.totalRows = 0;
		}else{
			this.totalRows = totalRows;
		}
		//页大小合法化
		if (pageSize > 0 ) {
			this.pageSize = pageSize;
		}else{
			this.pageSize = DEFAULT_PAGE_SIZE;
		}
		//设置总页数，注意顺序
		setTotalPage();
		//请求页合法化
		if (toPage > 0 && toPage <= totalPage) {
			this.toPage = toPage;
		} else if(toPage<=0){
			toPage=1;
		} else{
			this.toPage = this.totalPage;
		} 
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 0) {
			pageSize = 10;
		}
		this.pageSize = pageSize;
	}

	public int getToPage() {
		return toPage;
	}

	public void setToPage(int toPage) {
		if (toPage < 0) {
			toPage = 1;
		}
		this.toPage = toPage;
	}

	public List<T> getObjLists() {
		return objLists;
	}

	public void setObjLists(List<T> objLists) {
		this.objLists = objLists;
	}

	
	/*
	 * 分页，起始与结束
	 */
	public int getBegin() {
		begin = Math.max(1, toPage - paginationSize/2);
		begin = (totalPage >=paginationSize && (totalPage - toPage < paginationSize/2)) ? (totalPage - paginationSize + 1) : begin;
		return begin;
	}
	
	public int getEnd() {
		end = Math.min(begin + paginationSize - 1, totalPage);
		return end;
	}
	
	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPaginationSize() {
		return paginationSize;
	}

	public void setPaginationSize(int paginationSize) {
		this.paginationSize = paginationSize;
	}

}

