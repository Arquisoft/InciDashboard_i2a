package com.uniovi.cucumber.pageobjects;

import java.util.Locale;
import java.util.ResourceBundle;

public class PO_Properties {

	private static String Path;
	private static int SPANISH = 0;
	private static int ENGLISH = 1;	
	private static Locale[] idioms = new Locale[] {new Locale("ES"), new Locale("EN")};

	
	public PO_Properties(String Path) //throws FileNotFoundException, IOException 
	{
		PO_Properties.Path = Path;
	}
    public String getString(String prop, int locale) {
		
		ResourceBundle bundle = ResourceBundle.getBundle(Path, idioms[locale]);
		return bundle.getString(prop);
	}

    public static int getSPANISH() {
		return SPANISH;
	}

	public static int getENGLISH() {
		return ENGLISH;
	}
	
}
