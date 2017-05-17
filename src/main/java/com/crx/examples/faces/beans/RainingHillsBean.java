package com.crx.examples.faces.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.crx.examples.ejbbeans.RainingHillsServiceEJB;
import com.crx.examples.exception.ConverterException;
import com.crx.examples.exception.InvalidParameterException;
import com.crx.examples.model.RainingHillsDO;

/**
 * @author mina.nashed
 * 
 *<h1>Raining Hills Bean</h1>
 *         <p>
 *         A session scope managed bean for raining hills volume of units
 *         calculation.
 *         </p>
 */
@ManagedBean(name = "hillsBean")
@SessionScoped
public class RainingHillsBean implements Serializable {

	/**
	 * @serial 1L
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * REGEX To Validate the Input Data As Numeric Value.
	 */
	private static final String REGEX = "^[0-9]+(,[0-9]+)*$";
	/**
	 * A LOGGER Object for tracing the actions.
	 */
	private static final Logger LOGGER = Logger.getLogger("RainingHillsBean");

	/**
	 * An Object For Input data and The result .
	 */
	private RainingHillsDO rainingHills = new RainingHillsDO();

	/**
	 * Reference For RainingHillsServiceEJB EJB Implementation.
	 */
	@Inject
	private RainingHillsServiceEJB serviceImpl;

	/**
	 * Reference For RainingHillsServiceImpl EJB Implementation.
	 */
	private static final String page = "/index.xhtml";

	/**
	 * Inject ResourceBundle file
	 */

	@ManagedProperty("#{message}")
	private ResourceBundle message;

	/**
	 * 
	 * @return to index page
	 */
	public String calculateVolume() {
		LOGGER.log(Level.INFO, "Start Calculate The Volume of The Raining Hills.");
		try {
			// set the result of the calculation and return to the success page
			rainingHills.setResult(String.valueOf((serviceImpl.calculate(convertToInteger(rainingHills.getData())))));
			// catch InvalidParameterException exception if input data is
			// invalid
		} catch (InvalidParameterException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			// catch ConverterException exception if failed while converting the
			// input data
		} catch (ConverterException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

			// default handling exception
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, message.getString("general.error"), ""));
		}
		LOGGER.log(Level.INFO, "End Calculate The Volume of The Raining Hills Successfully.");
		return page;
	}

	/**
	 * @throws InvalidParameterException
	 * @throws ConverterException
	 *             <p>
	 *             Validate and Converting the Input String to Array of
	 *             BigDecimal .
	 *             </p>
	 * @param input @return BigDecimal[] @throws
	 */
	private Integer[] convertToInteger(String input) throws ConverterException, InvalidParameterException {
		LOGGER.log(Level.INFO, "convert the input data");

		if (input == null || !input.matches(REGEX))
			throw new InvalidParameterException("Invalid Input Data");

		Integer[] hills = null;
		try {
			hills = Arrays.stream(input.trim().split(",")).map(e -> new Integer(e)).toArray(Integer[]::new);
		} catch (Exception e) {
			throw new ConverterException("Failed While Converting the Input Data");
		}
		LOGGER.log(Level.INFO, "End converting the input data successfully.");
		return hills;
	}

	/**
	 * 
	 * @return RainingHillsDO object
	 */
	public RainingHillsDO getRainingHills() {
		return rainingHills;
	}

	/**
	 * 
	 * @param rainingHills
	 */
	public void setRainingHills(RainingHillsDO rainingHills) {
		this.rainingHills = rainingHills;
	}

	/**
	 * 
	 * @return ResourceBundle
	 */
	public ResourceBundle getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 */
	public void setMessage(ResourceBundle message) {
		this.message = message;
	}

}
