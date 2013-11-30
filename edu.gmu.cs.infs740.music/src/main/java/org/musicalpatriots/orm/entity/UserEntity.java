package org.musicalpatriots.orm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="user2")
public class UserEntity {
	
	private String username;
	private String password;
	private String fullName;
	private Long id;
	
	public UserEntity() {
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
//	@OneToMany(mappedBy = "User", fetch=FetchType.LAZY)
//	public Set<UserRole> getRoles() {
//		return this.roles;
//	}
//	
//	public void setRoles(Set<UserRole> roles) {
//		this.roles = roles;
//	}

	@Override
	public String toString() {
		return "id: " + id + ", username: " + username + ", password: " + password + ", fullName: " + fullName;
	}
	
}
