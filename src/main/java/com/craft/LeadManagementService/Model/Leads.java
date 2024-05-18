package com.craft.LeadManagementService.Model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leads {
	
	
	@Id
	@GeneratedValue(generator = "leadKeyGenerator")
	@GenericGenerator(name = "leadKeyGenerator", strategy = "com.craft.LeadManagementService.Utility.LeadKeyGenerator")
	private String leadId;
	private String firstName;
	private String lastName;
	@NotEmpty(message = "email can not be empty")
	private String email;
	@Min(10)
	private String phone;
	private String company;
	private String status;
	private String source;
	
	CustomFields customFields;
	
	

}
