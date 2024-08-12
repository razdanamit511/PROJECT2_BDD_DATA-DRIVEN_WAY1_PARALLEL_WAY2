package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverFactory {

	private WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		if (browser.equalsIgnoreCase("edge")) {

			EdgeOptions eoptions = new EdgeOptions();
			eoptions.addArguments("--remote-allow-origins=*");

			driver = new EdgeDriver(eoptions);
			tldriver.set(driver);

		} else if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions coptions = new ChromeOptions();
			coptions.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(coptions);
			tldriver.set(driver);

		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
