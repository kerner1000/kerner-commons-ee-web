package de.kerner.commons.ee.web;

import java.util.Locale;

import javax.faces.context.FacesContext;

import de.kerner.commons.logging.Log;

/**
 * <p>
 * TODO Description
 * </p>
 * <p>
 * TODO Example of usage
 * <p>
 * 
 * @author Alexander Kerner
 * 
 */
public class LocaleBean {
	
	private final static Log log = new Log(LocaleBean.class);
	
	public String localeToGerman(){
		 FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.GERMAN);
		 log.debug("changed locale to " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
		 return null;
	}
	
	public String localeToEnglish(){
		 FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		 log.debug("changed locale to " + FacesContext.getCurrentInstance().getViewRoot().getLocale());
		 return null;
	}

}
