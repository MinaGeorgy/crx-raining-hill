package com.crx.examples.service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation class RainingHillsServiceImpl
 * @author mina.nashed
 */

public class RainingHillsServiceImpl implements RainingHillsService{

	private static Logger logger=Logger.getLogger("RainingHillsServiceImpl.class");
    /**
     * @param Integer Array hills 
     * @return  Volume of All Units are needed To fill The Hills
     * <p>
     * The Time Complexity For Raining Hills Calculation Algorithm is O(n).
     * The Space Complexity For Raining Hills Calculation Algorithm is O(n).
     * 
     * </p>
     */
    public int calculate(Integer[] hills){
    	
    	logger.log(Level.INFO, "=======  Begin Calculate The Volume Units  ======= ");
    	// check if the array is null or the size is less than 3  
    	if(hills==null || hills.length<3 )
    		return 0;
    	//sum of the volumes units
    	int sum=0;	
    	// max hill from the left
    	int maxLeft=0;
    	// max hill from the right
    	int maxRight=0;
    	
    	int indexLeft=0;
    	int indexRight=hills.length-1;
    	
    	while (indexLeft<indexRight){
    		//Get The maximun hill from the left
    		maxLeft=Math.max(hills[indexLeft],maxLeft);
    		//Get The maximun hill from the Right
    		maxRight=Math.max(hills[indexRight],maxRight);
    		//Get the minimum of the maxleft and maxRight
    		//and Subtract it from the other hills and
    		//accumulate it to the sum of unit volumes
    		if(maxLeft<maxRight){
    			sum+=Math.max(0,maxLeft-hills[indexLeft]);
    			indexLeft++;
    		}else{
    			sum+=Math.max(0,maxRight-hills[indexRight]);
    			indexRight--;
    		}
    			
    	}
    	logger.log(Level.INFO, "The Sum of the Volume Units  ======= "+sum);
    	return sum;
    	
    }

}
