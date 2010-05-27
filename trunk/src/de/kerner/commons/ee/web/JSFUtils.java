package de.kerner.commons.ee.web;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtils {

	public static void publishError(Throwable t) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(t.getLocalizedMessage()));
	}
	
	public static void publishError(Throwable t, FacesContext context) {
		context.addMessage(null,
				new FacesMessage(t.getLocalizedMessage()));
	}
	
	public static void publishMessage(String string) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(string));	
	}
	
	public static <V> V getManagedObject(String elString, Class<V> c) {
		FacesContext context = FacesContext.getCurrentInstance();
		return getManagedObject(elString, c, context);
	}
	
	public static <V> V getManagedObject(String elString, Class<V> c, FacesContext context) {
		Application a = context.getApplication();
		V v = c.cast(a.evaluateExpressionGet(context, elString, c));
		return v;
	}
	
	public static void storeOnSession(String key,
			Object object) {
		FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().put(key, object);
	}
	
	public static <V> V getFromSession(FacesContext ctx, String key, Class<V> c){
		V v = c.cast(ctx.getExternalContext().getSessionMap().get(key));
		return v;
	}
}