package cn.qyl.ebuy.common;
/**
 * 分页模型
 * pageIndex 当前页
 * pageSize	每页显示记录数
 * recordCount 总记录数
 *
 */
public class PageModel {
	public final static int PAGE_SIZE = 5;
	
	private Integer pageIndex;
	private int pageSize;
	private Integer recordCount;
	
	//获取起始页
	public int getStartRow(){
		return (this.getPageIndex() - 1) * this.getPageSize();
	}
	//获取总页数
	public int getTotalPage(){
		return (this.getRecordCount() - 1)/this.getPageSize() + 1;
	}
	
	//提供setter和getter方法
	public Integer getPageIndex() {
		return pageIndex>0?pageIndex:1;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize>0?pageSize:PAGE_SIZE;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	@Override
	public String toString() {
		return "PageModel [pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", recordCount=" + recordCount + "]";
	}
	
	
}
