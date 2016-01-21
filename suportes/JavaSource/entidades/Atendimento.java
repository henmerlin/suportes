package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Atendimento {

	@Id
	@GeneratedValue
	private Integer Id;
	
	private String tecnico;

	@NotEmpty
	@Length(min=8, max=10, message="Padrão: G00XXXXX.")
	private String colaborador;
	
	@NotEmpty
	private String acompanhamento;
	
	@NotEmpty
	private String instancia;
	
	@NotEmpty
	private String ordem;
	
	@NotEmpty
	private String servico;

	private String autorizacao;

	@OneToOne
	@NotNull
	private Motivo motivo;

	private String observacao;

	private Date inicio;
	
	private Date fim;
	
	private Boolean acesso;
	
	private Boolean ferramentas;


	public Atendimento() {
	
	}


	public String getServico() {
		return servico;
	}


	public void setServico(String servico) {
		this.servico = servico;
	}


	public String getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(String acompanhamento) {
		this.acompanhamento = acompanhamento;
	}



	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}



	public String getOrdem() {
		return ordem;
	}


	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}


	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendimento [Id=" + Id + "]";
	}

	public Boolean getAcesso() {
		return acesso;
	}

	public void setAcesso(Boolean acesso) {
		this.acesso = acesso;
	}

	public Boolean getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(Boolean ferramentas) {
		this.ferramentas = ferramentas;
	}

}
