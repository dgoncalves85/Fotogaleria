package testes;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Fotogaleria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FotogaleriaTesteMobile {

	static WebDriver driver;
	private static Fotogaleria fotogaleria;
	static DesiredCapabilities capabilities;
	static String DeviceName;
	
	//public static void main(String[] args) {
	@BeforeClass
	public static void antesDeCadaTeste() {
		//some Sample Devices. Complete list can be found here: https://code.google.com/p/chromium/codesearch#chromium/src/chrome/test/chromedriver/chrome/mobile_device_list.cc
		//pick any of the device
  
		//  DeviceName = "Google Nexus 5";
		//  DeviceName = "Samsung Galaxy S4";
		//  DeviceName = "Samsung Galaxy Note 3";
		//  DeviceName = "Samsung Galaxy Note II";
		//  DeviceName = "Apple iPhone 4";
		//	DeviceName = "Apple iPhone 5";
		//  DeviceName = "Apple iPad 3 / 4";
			DeviceName = "Apple iPhone 6 Plus";

		String ChromeDriverPath = System.getProperty("webdriver.chrome.driver", "C:\\Dev\\DriversBrowsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
  
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", DeviceName);
  
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);

		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
  
		driver.manage().window().maximize();
		driver.get("http://m.oglobo.globo.com/fotogalerias/");
		fotogaleria = new Fotogaleria(driver);
		//driver.close();
		
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		driver.close();
	}
		
	@Test
	public void aVerificarHomeFotogalerias() {
		assertTrue(driver.getCurrentUrl().contains("http://m.oglobo.globo.com/fotogalerias/"));
	}
	
	@Test
	public void bVerificarPublicidadeTopo() {
		assertTrue(fotogaleria.getPublicidadeTopo());
	}
	
	@Test
	public void cVerificarPublicidadeInferior() {
		assertTrue(fotogaleria.getPublicidadeInferior());
	}
	
	@Test
	public void dAcessarGaleriaDeFotosEsportes() {
		fotogaleria.getFotoRecomendadas().click();
		assertEquals(fotogaleria.getEditoriaEsportes(), "RIO");
	}
	
	@Test
	public void eVerificarTituloGaleria() {
		assertEquals(fotogaleria.getTituloGaleria(), "GRAFITE DA PAZ");
	}

}

