package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_efika_web_permissoes")
public class Usuario {
	
	@Id
	@NotEmpty
	@Column(name="LOGIN")
	private String login;
	
	@NotEmpty
	@Column(name="SENHA")
	private String senha;
		
	public Usuario() {
	
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
