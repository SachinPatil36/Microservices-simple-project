package com.lcwd.user.service.user.service.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="microServices")
public class User {
	@Id
	@Column(name="userId")
	private String userId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="about")
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<Rating>();
	
	

	
	
	


}
