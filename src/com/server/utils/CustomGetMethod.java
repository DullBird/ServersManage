package com.server.utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;



/**  
 * @类功能说明：  用于访问gzip网页
 * @作者：wujunjun 
 * @创建时间：2014-3-5 上午10:48:37  
 * @版本：V1.0  
 */ 
public class CustomGetMethod extends org.apache.commons.httpclient.methods.GetMethod{
	
	public CustomGetMethod(String uri) {
		super(uri);
	}

	
	/**
	 * Get response as string whether response is GZipped or not
	 * 重写getResponseBodyAsString方法，解压gzip网页返回的内容
	 * @return
	 * @throws IOException
	 */
	@Override
	public String getResponseBodyAsString() throws IOException {
		GZIPInputStream gzin;
		if (getResponseBody() != null || getResponseStream() != null) {

			if (getResponseHeader("Content-Encoding") != null
					&& getResponseHeader("Content-Encoding").getValue()
							.toLowerCase().indexOf("gzip") > -1) {
				// For GZip response
				InputStream is = getResponseBodyAsStream();
				gzin = new GZIPInputStream(is);

				InputStreamReader isr = new InputStreamReader(gzin,
						getResponseCharSet());
				java.io.BufferedReader br = new java.io.BufferedReader(isr);
				StringBuffer sb = new StringBuffer();
				String tempbf;
				while ((tempbf = br.readLine()) != null) {
					sb.append(tempbf);
					sb.append("\r\n");
				}
				isr.close();
				gzin.close();
				return sb.toString();
			} else {
				// For deflate response
				return super.getResponseBodyAsString();
			}
		} else {
			return null;
		}
	}

}
