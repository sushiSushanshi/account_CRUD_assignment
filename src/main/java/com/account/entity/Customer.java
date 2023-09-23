package com.account.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="details_id", referencedColumnName = "customer_id")
	private CustomerDetails details;
	
	@Column(name="business_requirements")
	private List<String> businessRequirements;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract", referencedColumnName = "id")
	private Contract contractType;

}
