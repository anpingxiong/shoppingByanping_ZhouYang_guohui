package com.shopping.guoguo.pojo;

public class PageVo {
	// 拿到的是查询起始位
	private int firstIndex;
	// 拿的是当前页
	private int currentPage;
	// 显示的最大数量
	private int maxResult = 3;
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	// 得到的是所有的页面个数
	private int totalPage;
	// 数据库中总共的数量
	private int totalResult;

	public int getFirstIndex() {
		return firstIndex;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	// firstIndex是同过currentpage算出来的
	// maxResult是自己set的
	// totalPage 是同过totalResult
	// totalResult是重数据库中插找出来的
	public void setCurrentPage(int currentPage) {
		if(currentPage<1){
			currentPage=1;
		}
		this.currentPage = currentPage;
		this.firstIndex = (currentPage - 1) * maxResult;
	}

	public int getMaxResult() {
		return maxResult;
	}

	// 这是为了我们可以在页面上控制显示的数量
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	public int getTotalResult(){
		return totalResult;
	}

	// 在设置总共数量的同时我们完成了拿到totalpage
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		this.totalPage = (totalResult % maxResult) == 0 ? (totalResult / maxResult): (totalResult / maxResult + 1);
	}

	// 页面需要totalpage,所有给了他get方法
	public int getTotalPage() {
		return totalPage;
	}

	

}
