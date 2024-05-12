package com.craft.LeadManagementService.Model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	private String email;
	private String phone;
	private String company;
	private String status;
	private String source;
	
	CustomFields customFields;
	
	

}
