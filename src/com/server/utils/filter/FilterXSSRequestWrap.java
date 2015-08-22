package com.server.utils.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

import com.server.utils.EncodeFilter;

/**
 * 用于过滤request参数中的敏感符号，防止xss注入
 * filter里面获取的request对象不能直接修改parameter
 * 通过继承HttpRequestWrapper即可改变
 * @author Dull Bird
 * @data 2015-8-22
 */
public class FilterXSSRequestWrap extends HttpServletRequestWrapper {
	
	/**
	 * 规范化后请求参数map 
	 */
    private Map<String, String[]> sanitized;
    
    /** 
     * 原始请求参数map 
     */  
    private Map<String, String[]> orig;  

	public FilterXSSRequestWrap(HttpServletRequest request) {
		super(request);
		orig = request.getParameterMap();     
        sanitized = getParameterMap(); 
	}
	
	@Override
    public String getParameter(String name){         
        String[] vals = getParameterMap().get(name);   
        if (vals != null && vals.length > 0)   
            return vals[0];  
        else          
            return null;          
    }  
  
	@Override
    public Map<String, String[]> getParameterMap(){     
        if (sanitized==null)  
            sanitized = sanitizeParamMap(orig);  
        return sanitized;             
  
    }  
  
    @Override
    public String[] getParameterValues(String name){     
        return getParameterMap().get(name);  
    }
    
    /** 
     * 规范请求参数 
     * @param raw 
     * @return 
     */  
    private  Map<String, String[]> sanitizeParamMap(Map<String, String[]> raw){         
        Map<String, String[]> res = new HashMap<String, String[]>();  
        if (raw==null){
        	return res;
        }
        for(String key : (Set<String>) raw.keySet()){             
            String[] rawVals = raw.get(key);  
            String[] snzVals = new String[rawVals.length];  
            for(int i=0; i < rawVals.length; i++){  
                snzVals[i] = EncodeFilter.encode(rawVals[i]);  
            }  
            res.put(key, snzVals);  
        }             
        return res;  
    }  
      
}
