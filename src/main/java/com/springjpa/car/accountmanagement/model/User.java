package com.springjpa.car.accountmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "UserCar")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	@Column(name="USERID")
	private Long userId;
	@NotNull(message = "first name cannot be null")
	@Size(min = 2, message = "first name cannot be less than 2 characters")
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private String age;
	@Column(name="EMAIL")
	@NotNull
	private String email;
	@Column(name="CARNAME")
	private String carName;
	@Column(name="MODELNO")
	private String modelno;
	
	public User() {
		super();
	}

}
