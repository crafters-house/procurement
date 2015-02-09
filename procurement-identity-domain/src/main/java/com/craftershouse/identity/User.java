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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.craftershouse.identity.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Configurable
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

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
	private List<Role> role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinTable(name = "user_groups"
				, joinColumns = { @JoinColumn(name="user_id") }
				, inverseJoinColumns = { @JoinColumn(name = "group_id") })
	private List<Group> groups;
	
	@Autowired
	private UserRepository all;
	
	
	
}
