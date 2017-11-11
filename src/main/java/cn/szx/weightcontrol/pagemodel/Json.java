package cn.szx.weightcontrol.pagemodel;

import java.io.Serializable;

/**
 * 
 * @ClassName: Json
 * @Description: 因前台需要类似例如：{ "msg": "更新成功！", "obj": { Object }, "success": true } 格式的 json 数据，故创建此类。
 * @author: 宋桢熙
 * @date: 2014年9月2日 下午4:21:39
 */
public class Json implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
