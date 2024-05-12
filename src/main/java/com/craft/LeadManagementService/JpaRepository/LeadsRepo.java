package com.craft.LeadManagementService.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.LeadManagementService.Model.Leads;


@Repository
public interface LeadsRepo extends JpaRepository<Leads, String> {
	
	

}
