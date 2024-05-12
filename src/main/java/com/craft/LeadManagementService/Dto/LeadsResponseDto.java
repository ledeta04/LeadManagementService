package com.craft.LeadManagementService.Dto;

import com.craft.LeadManagementService.Model.Leads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeadsResponseDto {
	
	private Leads leads;
	private String message;
	private String statusCode;

}
