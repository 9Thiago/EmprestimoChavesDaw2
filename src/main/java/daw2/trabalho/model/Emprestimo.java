package daw2.trabalho.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_emp;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "alugada")
//	private Chaves chave;	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "servidor")
	private String alugada;
	private String servidor;
	private String hora;
	private String acao;
	public Long getId_emp() {
		return id_emp;
	}
	public void setId_emp(Long id_emp) {
		this.id_emp = id_emp;
	}
	public String getAlugada() {
		return alugada;
	}
	public void setAlugada(String alugada) {
		this.alugada = alugada;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	@Override
	public int hashCode() {
		return Objects.hash(acao, alugada, hora, id_emp, servidor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(acao, other.acao) && Objects.equals(alugada, other.alugada)
				&& Objects.equals(hora, other.hora) && Objects.equals(id_emp, other.id_emp)
				&& Objects.equals(servidor, other.servidor);
	}
	@Override
	public String toString() {
		return "Emprestimo [id_emp=" + id_emp + ", alugada=" + alugada + ", servidor=" + servidor + ", hora=" + hora
				+ ", acao=" + acao + "]";
	}
	
	
}