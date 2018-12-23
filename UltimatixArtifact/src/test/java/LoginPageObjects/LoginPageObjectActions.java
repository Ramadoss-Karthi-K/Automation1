package LoginPageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageObjectActions {
	
	public WebDriver driver;
	
	// Starting up the browser
	
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\JAVA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://auth.ultimatix.net/utxLogin/login?TYPE=33554432&REALMOID=06-45402d83-8994-41d4-9e1e-60a2815da6a3&GUID=&SMAUTHREASON=0&METHOD=GET&SMAGENTNAME=-SM-EdbHMX6T%2bWb8DN7DVmL5sbY%2bn%2b30S7n%2fgIBptYa9dLbudResX4AYm9ObPeNozoDH&TARGET=-SM-HTTPS%3a%2f%2fwww%2eultimatix%2enet%2fultimatixPortalWeb%2fUTXPortalRedirect%3fTARGET%3dhttps-%3A-%2F-%2Fwww%2eultimatix%2enet-%2F");
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		
	}
	
	@Test
	public void methodUltimatixLogin() throws IOException {
		
		LoginPage  candy = new LoginPage(driver);
		candy.loginPageUltimatix("1187499", "hSS#822Qox25");
		
		
	}
	
	
	

}
