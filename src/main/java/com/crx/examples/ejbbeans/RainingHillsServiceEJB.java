package com.crx.examples.ejbbeans;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.crx.examples.service.RainingHillsService;
import com.crx.examples.service.RainingHillsServiceImpl;

/**
 * Session Bean implementation class RainingHillsServiceImpl
 */
@Stateless
@LocalBean
public class RainingHillsServiceEJB {

	/**
	 * declare reference of Logger class
	 */
	private static Logger logger=Logger.getLogger("RainingHillsServiceEJB.class");
	/**
	 * declare reference of RainingHillsService Class
	 */
	private RainingHillsService rainingHillsService=new RainingHillsServiceImpl();
    /**
     * @param An Integer Array hills 
     * @return Volume of All Units are needed To fill The Hills
     * <p>
     * The Time Complexity For Raining Hills Calculation Algorithm is O(n).
     * The Space Complexity For Raining Hills Calculation Algorithm is O(n).
     * </p>
     */
    public int calculate(Integer[] hills){
    	
    	logger.log(Level.INFO, "=======  Begin Calculate The Volume Units  ======= ");
    	//call the method calculate in service class
    	int sum=rainingHillsService.calculate(hills);
    			
    	logger.log(Level.INFO, "The Sum of the Volume Units  ======= "+sum);
    	return sum;
    	
    }

}
