package daw2.trabalho.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chaves")
public class Chaves implements Serializable {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chave_id;
	private String nomechave;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	public Long getChave_id() {
		return chave_id;
	}
	public void setChave_id(Long chave_id) {
		this.chave_id = chave_id;
	}
	public String getNomechave() {
		return nomechave;
	}
	public void setNomechave(String nomechave) {
		this.nomechave = nomechave;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(chave_id, nomechave, situacao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chaves other = (Chaves) obj;
		return Objects.equals(chave_id, other.chave_id) && Objects.equals(nomechave, other.nomechave)
				&& situacao == other.situacao;
	}
	@Override
	public String toString() {
		return "Chaves [chave_id=" + chave_id + ", nomechave=" + nomechave + ", situacao=" + situacao + "]";
	}
	
	

	
	
}
