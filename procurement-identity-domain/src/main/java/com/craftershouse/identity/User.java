package com.craftershouse.identity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import com.craftershouse.activerecord.RootAggregate;
import com.craftershouse.identity.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="USERS")
@Data @EqualsAndHashCode(callSuper=false ,  doNotUseGetters=true , of = {"id"})  
@AllArgsConstructor @Builder
public class User extends RootAggregate<UserRepository,User> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Size(max = 200)
	@NotNull
	@Column(nullable = false, length = 200,unique=true)
	private String login;

	@Size(max = 300)
	@NotNull
	@Column(nullable = false, length = 300)
	private String email;	
	
	@Size(max = 100)
	@Column(length = 100)
	private String title;

	@Size(max = 50)
	@NotNull
	@Column(nullable = false, length = 50)
	private String firstName;

	@Size(max = 250)
	@NotNull
	@Column(nullable = false, length = 250)
	private String lastName;

	@Size(max = 300)
	@NotNull
	@Column(nullable = false, length = 300)
	private String fullName;

	@Size(max = 40)
	@Column(length = 40)
	private String phone;

	@Size(max = 40)
	@Column(length = 40)
	private String celPhone;
	
	@NotNull
	@OneToMany(targetEntity=Role.class)
	private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinTable(name = "USER_GROUPS"
				, joinColumns = { @JoinColumn(name="users_id") }
				, inverseJoinColumns = { @JoinColumn(name = "user_groups_id") })
	private List<Group> groups;
	
	public User () {}
	
	@Transactional
	public void add(Group group) {
		getGroups().add(group);
	}

	@Transactional
	public void add(Role role) {
		getRoles().add(role);
	}
	
}
