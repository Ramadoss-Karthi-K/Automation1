package LoginPageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class LoginPage {

	public WebDriver driver ;
	public WebDriverWait wait;

	//creating a constructor for initializing the webDriver Instance

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// Identifying the elements in Ultimatix login page.

	By usernameLogin = By.xpath("//input[@id='USER']");

	By passwordLogin = By.xpath("//input[@id='PASSWORD']");

	By clicking = By.xpath("//input[@class = 'login_button']");

	By iconImage = By.id("PinNewsCarousel");


	public void loginPageUltimatix(String userName, String password ) throws IOException {

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLogin)).sendKeys(userName);
		driver.findElement(passwordLogin).sendKeys(password);
		driver.findElement(clicking).click();

		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(iconImage));
		 

		//****************************************** Taking screenshot ***********************************************************************************
		
		// Getting a part of the image element

		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		BufferedImage image = ImageIO.read(ss);

		// Get the location of the element on the page.

		Point points = element.getLocation();

		// Get the width and height of the element.

		int width = element.getSize().getWidth();
		System.out.println(width);
		int height = element.getSize().getHeight();
		System.out.println(height);
		
		// Crop to get only element screenshot	

		BufferedImage partImage = image.getSubimage(points.getX(), points.getY(), width, height);

		ImageIO.write(partImage, "png", ss);

		// Copy the image to the disk location.
		
		File location = new File("C:\\Users\\Karthick\\Desktop\\Selenium\\screen.png");
		Files.copy(ss,location);
		
		// To get the entire image and save in same location with different name.
		
		File screen1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File location1 = new File("C:\\Users\\Karthick\\Desktop\\Selenium\\screen1.png");
		Files.copy(screen1,location1);
		
		//*****************************************************************************************************************************************************
	
	}
	



}
