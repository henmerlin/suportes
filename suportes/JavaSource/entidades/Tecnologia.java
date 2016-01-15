package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tecnologia{

	@Id
	@GeneratedValue
	private Integer Id;

	@NotEmpty
	private String nome;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="tecnologia")
	private List<Motivo> motivos;

	public Tecnologia() {

	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Motivo> getMotivos() {
		return motivos;
	}


	public void setMotivos(List<Motivo> motivos) {
		this.motivos = motivos;
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
		Tecnologia other = (Tecnologia) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tecnologia [Id=" + Id + "]";
	}


}

