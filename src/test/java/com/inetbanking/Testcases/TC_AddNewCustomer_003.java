package com.inetbanking.Testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	LoginPage lp = new LoginPage(driver);
	lp.setUsername(username);
	lp.setpassword(password);
	lp.clicksubmit();
	Thread.sleep(3000);
	
	AddNewCustomer addcust=new AddNewCustomer(driver);
	addcust.clickAddNewCustomer();
	
	logger.info("providing customer details....");
	
	
	addcust.custName("Pavan");
	addcust.custgender("male");
	addcust.custdob("10","15","1985");
	Thread.sleep(5000);
	addcust.custaddress("INDIA");
	addcust.custcity("HYD");
	addcust.custstate("AP");
	addcust.custpinno("5000074");
	addcust.custtelephoneno("987890091");
	
	
	addcust.custemailid(Randomstring()+"@gmail.com");
	addcust.custpassword("abcdef");
	addcust.custsubmit();
	
	Thread.sleep(3000);
	
	logger.info("validation started....");
	
	boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
	
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("test case passed....");
		
	}
	else
	{
		logger.info("test case failed....");
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
		
	}
	
	
    
}
