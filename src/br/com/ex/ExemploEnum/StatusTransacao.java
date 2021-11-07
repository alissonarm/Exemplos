package br.com.ex.ExemploEnum;

public enum StatusTransacao {
	
	PENDENTE("Pendente") {
		@Override
		boolean isPodeSerCancelada() {
			return true;
		}
	},
	ANALISE("Em analise") {
		@Override
		boolean isPodeSerCancelada() {
			return true;
		}
	},
	PROCESSADA("Processada") {
		@Override
		boolean isPodeSerCancelada() {
			return false;
		}
	},
	CANCELADA("Cancelada") {
		@Override
		boolean isPodeSerCancelada() {
			return false;
		}
	};
	
	private String descricao;

	StatusTransacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	abstract boolean isPodeSerCancelada();
	
}
