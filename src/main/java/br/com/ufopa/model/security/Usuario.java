package br.com.ufopa.model.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Column(name = "nome", length = 80)
	private String nome;

	@Column(name = "cpf", length = 20)
	private String cpf;

	@NotBlank
	@Column(name = "username", length = 100)
	private String username;

	@NotBlank
	@Column(name = "password", length = 200)
	private String password;

	@Column(name = "telefone", length = 30)
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "matricula", length = 20)
	private long matricula;

	@Transient
	private String checkPassword;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos;

	public Usuario() {
		grupos = new ArrayList<Grupo>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

	public boolean confirmaSenha() {
		return this.password.equals(this.checkPassword);
	}

	public boolean confirmaGrupo() {
		return (this.grupos.size() > 0);
	}

	public void adicionarItemVazio() {
		Grupo grupo = new Grupo();
		this.getGrupos().add(0, grupo);
	}

	public void removeItemVazio() {
		Grupo item = this.getGrupos().get(0);
		if (item != null && item.getId() == null) {
			this.grupos.remove(0);
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	@Transient
	public String getRelacaoGrupos() {
		String lista = "";
		for (Grupo g : this.grupos) {
			lista += " " + g.getNome() + " ";
		}
		return lista;
	}

	@Transient
	public boolean isNovo() {
		return id == null;
	}

	@Transient
	public boolean isExistente() {
		return !isNovo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
