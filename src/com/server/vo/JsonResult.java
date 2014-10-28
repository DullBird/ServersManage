package com.server.vo;

/**
 * 返回的json结果类
 * @author DullBird
 * @date 2014-7-9
 */
public class JsonResult<T> {
	
	private T resultData;			//存放返回的结果
	
	private boolean isSuccess;		//是否成功，可用于ajax提示
	
	//保留空的构造方法
	public JsonResult(){}
	
	public JsonResult(boolean isSuccess,T resultData){
		this.isSuccess = isSuccess;
		this.resultData = resultData;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
