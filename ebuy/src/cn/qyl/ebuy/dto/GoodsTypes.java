package cn.qyl.ebuy.dto;

import java.util.List;
import java.util.Map;

/**
 * 前台导航下拉准备数据
 * Map---->maxType	0001=手机
 * List<Map>---->minType	00010001=苹果,00010002=三星...
 * @author Administrator
 *
 */
public class GoodsTypes {

	private Map<String,String> maxType;
	private List<Map<String,String>> minType;
	
	
	
	
	public GoodsTypes() {
		super();
	}
	public GoodsTypes(Map<String, String> maxType,
			List<Map<String, String>> minType) {
		super();
		this.maxType = maxType;
		this.minType = minType;
	}
	public Map<String, String> getMaxType() {
		return maxType;
	}
	public void setMaxType(Map<String, String> maxType) {
		this.maxType = maxType;
	}
	public List<Map<String, String>> getMinType() {
		return minType;
	}
	public void setMinType(List<Map<String, String>> minType) {
		this.minType = minType;
	}
	
	
}
