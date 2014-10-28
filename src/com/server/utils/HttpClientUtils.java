package com.server.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

/*******************************************************************************
 * Http 请求工具类
 * 
 * @author zengxiangtao
 * @version 2013-07-01
 ******************************************************************************/
public class HttpClientUtils {

	private static Logger log = Logger.getLogger(HttpClientUtils.class);

	protected HttpClientUtils() {

	}

	/**
	 * Apache Http Post 请求<br>
	 * 
	 * @param urlStr
	 *            -请求路径
	 * @param parmap
	 *            -请求参数
	 * @param charSet
	 *            -编码
	 */
	public static String sendPostRequest(String urlStr,Map<String, String> parmap, String charSet) {
		long begainTime = System.currentTimeMillis();
		HttpClient client = new HttpClient();
		// 设置超时时间 假如超时 则返回 ""
		 client.getHttpConnectionManager().getParams().setConnectionTimeout(15*1000);
		// 表示用Post方式提交
		PostMethod method = new PostMethod(urlStr);
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
		// 设置请求参数
		if (null != parmap && parmap.size() > 0) {
			Iterator it = parmap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> me = (Map.Entry) it.next();
				method.addParameter(me.getKey(), me.getValue() == null ? "":me.getValue());
			}
		}
		try {
			int status = client.executeMethod(method);
			if (status == 200) {
				String rs = new String(method.getResponseBody(), charSet);
				log.info("----->sendPostRequest....URL:"+urlStr+"----result:"+rs);
				return rs;
			}
		} catch (HttpException e) {
			log.error("------>sendPostRequest....URL:"+urlStr+"------>Exception:"+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("------>sendPostRequest....URL:"+urlStr+"------>Exception:"+ e.getMessage());
			e.printStackTrace();
		} finally {
			log.info("----->sendPostRequest....URL:"+urlStr+"---- use Times:"+(System.currentTimeMillis()-begainTime));
			method.releaseConnection();
		}
		return null;
	}

	/**
	 * Apache get请求
	 * 
	 * @param urlStr
	 *            -请求路径
	 */
	public static byte[] sendApacheGetRequst(String urlStr) {
		log.info("HttpClientUtils------>sendApacheGetRequst------>URL:"
				+ urlStr);
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(urlStr);
		// 当请求发生跳转时是否继续请求
		get.setFollowRedirects(true);
		try {
			client.executeMethod(get);
			// get.getResponseBodyAsString()容易出现乱码
			return get.getResponseBody();
		} catch (IOException e) {
			log.error("HttpClientUtils------>sendApacheGetRequst------>Exception:"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			get.releaseConnection();
		}
		return null;
	}
	
	public static String sendGetRequstOfGzip(String url) {
		HttpClient http = new HttpClient();  
	    CustomGetMethod get = new CustomGetMethod(url);  
	      
	   //添加头信息告诉服务端可以对Response进行GZip压缩  
	    get.setRequestHeader("Accept-Encoding", "gzip, deflate");  
	    try {  
	        int statusCode = http.executeMethod(get);  
	        if (statusCode != HttpStatus.SC_OK) {  
	            System.err.println("Method failed: "  
	                    + get.getStatusLine());  
	        }  
	
	        //打印解压后的返回信息  
//	        System.out.println(get.getResponseBodyAsString());
	        return get.getResponseBodyAsString();
	    } catch (Exception e) {  
	        System.err.println("页面无法访问");  
	        e.printStackTrace();  
	    } finally {  
	    	get.releaseConnection();  
	    }
	    return null;
	}

}
