package com.crx.examples.service;

/**
 * @author mina.nashed
 * 
 *
 */
public interface RainingHillsService {

	/**
	 * <p>
	 * calculate method to predefine the amount of units that are needed
	 * to fill the hills after raining
	 * @param hills
	 * @return  sum of volume units to fill hills
	 */
    public int calculate(Integer [] hills);
}
