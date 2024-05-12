package com.craft.LeadManagementService.Utility;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class LeadKeyGenerator implements IdentifierGenerator {
	
//	 /**
//	 * 
//	 */
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "LEAD";
	private static final AtomicInteger counter = new AtomicInteger(987653);

	    @Override
	    public Serializable generate(SharedSessionContractImplementor session, Object object) {
	    	
	    	int value =  counter.incrementAndGet();
			String formattedValue = String.format("%06d", value);
	    	
	        return PREFIX + formattedValue;
	    }

}
