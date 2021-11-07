package br.com.ex.ExemploEnum;

public class Transacao {
	
	private StatusTransacao status;

	public StatusTransacao getStatus() {
		return status;
	}

	public void setStatus(StatusTransacao status) {
		this.status = status;
	}
	
	public boolean isPodeSerCancelada() {
		return status.isPodeSerCancelada();
	}
	 

}
