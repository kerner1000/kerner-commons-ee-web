package de.kerner.commons.ee.web;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class JSFUtils {
	
	public static FacesContext getFacesContext() throws NoSuchSessionException {
		final FacesContext context = FacesContext.getCurrentInstance();
		if(context == null)
			throw new NoSuchSessionException();
		return context;
	}
	
	public static String getSessionID() throws NoSuchSessionException {
		return getSession().getId();
	}
	
	public static String getSessionID(FacesContext context) throws NoSuchSessionException {
		return getSession(context).getId();
	}
	
	public static HttpSession getSession() throws NoSuchSessionException {
		return getSession(getFacesContext());
	}
	
	public static HttpSession getSession(FacesContext context) throws NoSuchSessionException {
		final HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		if(session == null)
			throw new NoSuchSessionException();
		return session;
	}

	public static void publishError(Throwable t) {
		try{
		publishError(t, getFacesContext());
		}catch(Throwable t2){
			// TODO not good
			t2.printStackTrace();
		}
	}
	
	public static void publishError(Throwable t, FacesContext context) {
		context.addMessage(null,
				new FacesMessage(t.getLocalizedMessage()));
	}
	
	public static void publishMessage(String string) throws NoSuchSessionException {
		publishMessage(string, getFacesContext());
	}
	
	public static void publishMessage(String string, FacesContext context) {
		context.addMessage(null,
				new FacesMessage(string));	
	}
	
	public static <V> V getManagedObject(String elString, Class<V> c) throws NoSuchSessionException {
		return getManagedObject(elString, c, getFacesContext());
	}
	
	public static <V> V getManagedObject(String elString, Class<V> c, FacesContext context) {
		Application a = context.getApplication();
		V v = c.cast(a.evaluateExpressionGet(context, elString, c));
		return v;
	}
	
	public static void storeOnSession(String key,
			Object object) throws NoSuchSessionException {
		storeOnSession(key, object, getFacesContext());
	}
	
	public static void storeOnSession(String key,
			Object object, FacesContext context) {
		context.getExternalContext()
				.getSessionMap().put(key, object);
	}
	
	public static <V> V getFromSession(String key, Class<V> c) throws NoSuchSessionException{
		return getFromSession(key, c, getFacesContext());
	}
	
	public static <V> V getFromSession(String key, Class<V> c, FacesContext context){
		V v = c.cast(context.getExternalContext().getSessionMap().get(key));
		return v;
	}
	
}