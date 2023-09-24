package com.account.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="details")
public class CustomerDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private long customerId;
	
	@NotBlank(message="name should not be blank")
	@Pattern(regexp ="^[MF]$" , message = "sex must be M or F")
	@Column(name = "sex")
	private String sex;
	
	@NotNull
	@Temporal(TemporalType.DATE)
    @Column(name = "dob", columnDefinition = "DATE CHECK (dob < '2002-01-01')")
	private Date DOB;
	
	@Column(name="city")
	@NotBlank(message= "city must not be blank")
	private String city;
}
