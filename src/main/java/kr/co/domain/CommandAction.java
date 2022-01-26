package kr.co.domain;

public class CommandAction {
	private boolean isRedirect;
	private String where;
	
	public CommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setIsRedirect(boolean inRedirect) {
		this.isRedirect = inRedirect;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	
	
	

}
