package net.jmdawson.shakespeare.web;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * A root view bean to redirect to the {@link ViewPosBean}
 * 
 * @author Jacob M. Dawson
 *
 */

@RequestScoped
@Named
public class RootViewBean {

	static final String VIEW_PATH = "/pos";

	public static void redirect() {
		
		try {
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		
		externalContext.redirect(externalContext.getRequestContextPath() + VIEW_PATH);
		FacesContext.getCurrentInstance().responseComplete();
		}
		catch (IOException ex){
			throw new RuntimeException(ex);
		}
		
	}

}
