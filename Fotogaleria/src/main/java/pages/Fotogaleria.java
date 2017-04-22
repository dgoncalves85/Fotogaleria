package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Fotogaleria {
	
	WebDriver driver;

	public Fotogaleria(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFotoRecomendadas() {
		return driver.findElement(By.xpath("//*[@id='photoGallery']/ul/li[1]/a/span[1]"));
	}
	
	public boolean getPublicidadeTopo() {
		return driver.findElement(By.id("pub-fullbanner-1")).isDisplayed();
	}
	
	public boolean getPublicidadeInferior() {
		return driver.findElement(By.id("pub-retangulo-2")).isDisplayed();
	}
	
	
	public String getEditoriaEsportes() {
		return driver.findElement(By.className("editoria")).getText();
	}
	
	public String getTituloGaleria() {
		return driver.findElement(By.xpath("//*[@id='photoGallery']/div/div/p")).getText();
	}
}