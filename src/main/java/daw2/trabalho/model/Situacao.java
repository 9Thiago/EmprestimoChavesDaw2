package daw2.trabalho.model;

public enum Situacao {
	LIVRE("LIVRE"),
	PEGA("PEGA");
	
	private String descricao;
	
	private Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
