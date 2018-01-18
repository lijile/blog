package com.lecoder.blog.web.common;

public class JsonResult {
	
	/**
	 * JSON请求发生错误(result字段)(0:错误，1:正常，2:重定向)
	 */
	public final static int ERROR = 0;
	/**
	 * JSON请求正常(result字段)
	 */
	public final static int SUCCESS = 1;
	/**
	 * 重定向(result字段)
	 */
	public final static int REDIRECT = 2;
	
	/**
	 * 结果代码(0:错误，1:正常，2:重定向)
	 */
	private int result;
	/**
	 * 结果信息
	 */
	private String msg;

	/**
	 * 异常详细信息,呈现程序异常堆栈;
	 */
	private String errorMsg;

	/**
	 * 处理后返回的结果
	 */
	private Object info;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public JsonResult(int result, String msg, String errorMsg, Object info) {
		super();
		this.result = result;
		this.msg = msg;
		this.errorMsg = errorMsg;
		this.info = info;
	}

	public JsonResult() {
		super();
	}

	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", msg=" + msg + ", errorMsg=" + errorMsg + ", info=" + info + "]";
	}
	
}
