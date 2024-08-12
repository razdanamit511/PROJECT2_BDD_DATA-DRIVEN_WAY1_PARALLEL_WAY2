package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

	private Properties prop;

	// Constructor - This will help us to load the properties.
	public ConfigUtils() {

		prop = new Properties();

		try {
			FileInputStream fis;
			fis = new FileInputStream(new File("src\\test\\resources\\config\\config.properties"));
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Properties got loaded successfully");
	}

	/* Methods */

	// Method 1: This returns browser property value.
	public String getBrowser() {
		return prop.getProperty("browser");
	}

	// Method 2: This returns SignIn page URL.
	public String getSignInPageURL() {
		return prop.getProperty("signinpageurl");
	}

	// Method 3: This returns CreateAnAccount page URL.
	public String getCreateAnAccountPageURL() {
		return prop.getProperty("createanaccountpageurl");
	}

	// Method 4: This returns ForgotPassword Page URL.
	public String getForgotPasswordPageURL() {
		return prop.getProperty("forgotpasswordpageurl");
	}

	// Method 5: This returns Home Page URL.
	public String getHomePageURL() {
		return prop.getProperty("homepageurl");
	}
}
