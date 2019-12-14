package hoimsys.bo;

import java.util.HashMap;
import java.util.Map;

/*
 * 通用的json返回类
 */

public class Msg {
	/*
	 * 状态码
	 * 100:处理失败
	 * 200:处理成功
	 */
	private Integer code;
	//是否成功
	private boolean success;
	//提示信息
	private String msg;
	//实际返回数据
	private Map<String,Object> data = new HashMap<String,Object>();
	
	
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理成功");
		result.setSuccess(true);
		return result;
	}
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理失败");
		result.setSuccess(false);
		return result;
	}
	
	public Msg add(String key, Object value) {
		this.getData().put(key, value);
		return this;
	}
	
	public Msg resetMsg(String msg) {
		this.msg = msg;
		return this;
	}
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
}
