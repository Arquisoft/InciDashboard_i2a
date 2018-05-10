package com.uniovi.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;

public class PO_HomeView extends PO_NavView{

	static public void checkWelcome(WebDriver driver, int language) {
		// Esperamos a que se cargue el saludo de bienvenida en Español
		com.uniovi.cucumber.util.SeleniumUtils.EsperaCargaPagina(driver, "text", p.getString("welcome.message", language),
				getTimeout());
	}

}
