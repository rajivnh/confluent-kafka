package com.lti.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	private String name;
	
	private BigDecimal balance;
	
	private BigDecimal withdrawal;
	
	private BigDecimal deposite;
	
	private String comment;
	
	private BigDecimal finalBalance;
}
