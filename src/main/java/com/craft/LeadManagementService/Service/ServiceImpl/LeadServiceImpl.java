package com.craft.LeadManagementService.Service.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.LeadManagementService.Dto.DeleteLeadsDto;
import com.craft.LeadManagementService.Dto.LeadsResponseDto;
import com.craft.LeadManagementService.JpaRepository.LeadsRepo;
import com.craft.LeadManagementService.Model.CustomFields;
import com.craft.LeadManagementService.Model.Leads;
import com.craft.LeadManagementService.Service.LeadService;

@Service
public class LeadServiceImpl implements LeadService{
	
	
	@Autowired
	LeadsRepo leadsRepo;

	@Override
	public LeadsResponseDto createNewLead(Leads leads) {
		
		try {
			
			leadsRepo.save(leads);
			
			LeadsResponseDto leadsResponseDto = new LeadsResponseDto(leads, "Create a new lead successfully", "1000");
			
			
			return leadsResponseDto;
			
		} catch (Exception e) {
			
			LeadsResponseDto leadsResponseDto = new LeadsResponseDto(leads, "new lead not created", "2000");
			
			return leadsResponseDto;
		}

	}

	@Override
	public LeadsResponseDto ConvertLeadToCustomer(String leadId, Leads leads) {
		
		Optional<Leads> optional =  leadsRepo.findById(leadId);
		
		if(optional.isPresent()) {
			
		Leads leads2 =	optional.get();
		
		leads2.setFirstName(leads.getFirstName());
		leads2.setLastName(leads.getLastName());
		leads2.setEmail(leads.getEmail());
		leads2.setPhone(leads.getPhone());
		leads2.setCompany(leads.getCompany());
		leads2.setStatus(leads.getStatus());
		leads2.setSource(leads.getSource());
		
		CustomFields customFields = new CustomFields();
		
		customFields.setIndustry(leads.getCustomFields().getIndustry());
		customFields.setLeadScore(leads.getCustomFields().getLeadScore());
		
		leadsRepo.save(leads2);
		
		LeadsResponseDto leadsResponseDto = new LeadsResponseDto(leads, "Successfully Updated", "3000");
		
		return leadsResponseDto;
				
		}
		
		
		return null;
	}

	@Override
	public Leads getLeadsById(String leadId) {

		Optional<Leads> optional =  leadsRepo.findById(leadId);
		
		if(optional.isPresent()) {
			
			return optional.get();
		}
		
		
		return null;
	}

	@Override
	public DeleteLeadsDto deleteLeadById(String leadId) {
		
		try {
			
			Optional<Leads> optional = leadsRepo.findById(leadId);
			
			leadsRepo.deleteById(leadId);
			
			if(optional.isPresent()) {
				
				return new DeleteLeadsDto("Leads removed", "400");
			}
			else {
				
				return new DeleteLeadsDto("Leads not found", "420");
			}
			
		} catch (Exception e) {

			return new DeleteLeadsDto("Error", "450");
			
		}

	}
}
