package com.uniovi.cucumber.util;


import java.util.List;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {


	/**
	 * Espera por la visibilidad de un elemento/s en la vista actualmente cargandose en driver. Para ello se empleará una consulta xpath.
	 * @param driver: apuntando al navegador abierto actualmente.
	 * @param xpath: consulta xpath.
	 * @param timeout: el tiempo máximo que se esperará por la aparición del elemento a buscar con xpath
	 * @return  Se retornará la lista de elementos resultantes de la búsqueda con xpath.
	 */
	static public List<WebElement> EsperaCargaPaginaxpath(WebDriver driver, String xpath, int timeout)
	{
		WebElement resultado = 
				(new WebDriverWait(driver, timeout)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		assertTrue(resultado != null);
		List<WebElement> elementos = driver.findElements(By.xpath(xpath));

		return elementos;					
	}

	/**
	 * Espera por la visibilidad de un elemento/s en la vista actualmente cargandose en driver. Para ello se empleará una consulta xpath 
	 * según varios criterios..
	 * 
	 * @param driver: apuntando al navegador abierto actualmente.
	 * @param criterio: "id" or "class" or "text" or "@attribute" or "free". Si el valor de criterio es free es una expresion xpath completa. 
	 * @param text: texto correspondiente al criterio.
	 * @param timeout: el tiempo máximo que se esperará por la apareción del elemento a buscar con criterio/text.
	 * @return Se retornará la lista de elementos resultantes de la búsqueda.
	 */
	static public List<WebElement> EsperaCargaPagina(WebDriver driver, String criterio, String text, int timeout)
	{
		String busqueda;
		if ("id".equals(criterio)) busqueda = "//*[contains(@id,'" + text + "')]";
		else if ("class".equals(criterio)) busqueda = "//*[contains(@class,'" + text + "')]";
		else if ("text".equals(criterio)) busqueda = "//*[contains(text(),'" + text + "')]";
		else if ("free".equals(criterio)) busqueda = text;
		else busqueda = "//*[contains("+criterio+",'" + text + "')]";

		return EsperaCargaPaginaxpath(driver, busqueda, timeout);
	}

}
