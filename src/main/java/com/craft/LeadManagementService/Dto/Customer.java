package com.craft.LeadManagementService.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Customer {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	Address address;
	private String notes;
	CustomFields customFields;

}
