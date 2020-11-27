package com.inetbanking.Testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_Login_001 extends BaseClass {
   
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URl opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered username");
		lp.setpassword(password);
		logger.info("Entered password");
		lp.clicksubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		  Assert.assertTrue(true);
		  logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"LoginPage");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
