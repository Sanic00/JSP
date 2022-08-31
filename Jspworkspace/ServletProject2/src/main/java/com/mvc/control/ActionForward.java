package com.mvc.control;

public class ActionForward {

//	XXXAction의 비즈니스 로직 수행 후 ControlServlet에게 반환하는 객체
//    (이동할 url과 이동방법을 저장하고 제시함)
	
	private String url;
	private boolean redirect; 
	
	public ActionForward() {}
	
//	오버로딩
	public ActionForward(String url) {
		this.url = url;
	}
	
	public ActionForward(String url,boolean redirect) {
		this.url = url;
		this.redirect = redirect;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
	
}
