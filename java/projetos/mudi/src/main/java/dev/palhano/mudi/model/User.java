package dev.palhano.mudi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(length = 50)
	private String username;
	@Column(length = 200)
	private String password;
	private Boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
