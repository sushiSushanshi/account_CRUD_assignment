package com.account.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message= "Account Type must not be blank")
	@Column(name="account_type")
	private String accountType;
	
	@NotBlank(message= "customer name must not be blank")
	@Column(name="name")
	private String name;
	
	@NotNull
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="details_id", referencedColumnName = "customer_id")
	private CustomerDetails details;
	
	@NotNull
	@Column(name="business_requirements")
	private List<String> businessRequirements;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract", referencedColumnName = "id")
	private Contract contractType;

}
