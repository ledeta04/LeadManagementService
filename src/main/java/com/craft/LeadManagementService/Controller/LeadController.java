package com.craft.LeadManagementService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craft.LeadManagementService.Dto.Customer;
import com.craft.LeadManagementService.Model.Leads;
import com.craft.LeadManagementService.Service.LeadService;

@RestController
@RequestMapping("/leads")
public class LeadController {
	
	
	@Autowired
	LeadService leadService;
	
	@PostMapping("/post")
	public ResponseEntity<?> createNewLead(@RequestBody Leads leads){
		
		try {
			
			return new ResponseEntity<>(leadService.createNewLead(leads), HttpStatus.CREATED);
			
		} catch (Exception e) {

			return new ResponseEntity<>(leadService.createNewLead(leads), HttpStatus.NOT_FOUND);			
		}
	}
	
	@PutMapping("/convert/{leadId}")
	public ResponseEntity<?> updateLead(@PathVariable("leadId") String leadId, @RequestBody Leads leads){
		
		
	    return new 	ResponseEntity<>(leadService.updateLead(leadId, leads), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{leadId}")
	public ResponseEntity<?> getLeadById(@PathVariable("leadId") String leadId){
		
		return new ResponseEntity<>(leadService.getLeadsById(leadId), HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{leadId}")
	public ResponseEntity<?> deleteLeadById(@PathVariable("leadId") String leadId){
		
		return new ResponseEntity<>(leadService.deleteLeadById(leadId), HttpStatus.OK);		
	}
	@PutMapping("/update/{customerId}")
	public ResponseEntity<?> createOrUpdateCustomer(@PathVariable("customerId") String customerId , @RequestBody Customer customer){
		
		return new ResponseEntity<>(leadService.UpdateCustomerFromLead(customerId, customer), HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<?> createCustomerFromLead(@RequestBody Customer customer){
		
		return new ResponseEntity<>(leadService.createCustomerFromLead(customer), HttpStatus.CREATED);
	}
	
}
