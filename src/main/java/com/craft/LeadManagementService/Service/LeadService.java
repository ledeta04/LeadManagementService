package com.craft.LeadManagementService.Service;

import com.craft.LeadManagementService.Dto.Customer;
import com.craft.LeadManagementService.Dto.DeleteLeadsDto;
import com.craft.LeadManagementService.Dto.LeadsResponseDto;
import com.craft.LeadManagementService.Model.Leads;

public interface LeadService {
	
	public LeadsResponseDto createNewLead(Leads leads);
	public LeadsResponseDto updateLead(String leadId , Leads leads);
	public Leads getLeadsById(String leadId);
	public DeleteLeadsDto deleteLeadById(String leadId);
	public Customer UpdateCustomerFromLead(String customerId , Customer customer);
	public Customer createCustomerFromLead(Customer customer);

}
