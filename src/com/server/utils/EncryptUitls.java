package com.server.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*******************************************************************************
 * 加密工具类
 * 
 * @author zengxiangtao
 * @version 2013-07-01 
 ******************************************************************************/
public class  EncryptUitls{

	private static Logger log = Logger.getLogger(EncryptUitls.class);
	protected EncryptUitls() {
		
	}

	/***************************************************************************
	 * MD5<br>
	 * 
	 * @param data
	 *            原文<br>
	 **************************************************************************/
	public static String MD5Digest(String str) {
		if(StringUtils.isBlank(str)){
			return null;
		}
		log.debug("----------->MD5Digest------------>Data:" + str);
		try {
			return DigestUtils.md5Hex(str.getBytes("UTF-8"));
		} catch (Exception e) {
			log.error("--------------->MD5DigestException------------>msg:"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/***************************************************************************
	 * BASE64 编码<br>
	 * 
	 * @param data
	 **************************************************************************/
	public static String base64Encode(String data) {
		log.info("-------------------->base64Encode------------>Data:" + data);
		if (StringUtils.isBlank(data)) {
			return null;
		}
		try {
			String rs = (new BASE64Encoder()).encodeBuffer(data.getBytes());
			log.info("---------------------->base64Encode------------>Result:"
					+ rs);
			return rs;
		} catch (Exception e) {
			log.error("-------------------->base64Encode------------>Excetption:"
					+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/***************************************************************************
	 * BASE64 解码<br>
	 * 
	 * @param data
	 **************************************************************************/
	public static String base64Decode(String key) {
		log.info("-------------------->base64Decode------------>Data:" + key);
		try {
			String rs = new String((new BASE64Decoder()).decodeBuffer(key));
			log.info("-------------------->base64Encode------------>Result:"
					+ rs);
			return rs;
		} catch (Exception e) {
			log.error("-------------------->base64Decode------------>Excetption:"
					+ e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
