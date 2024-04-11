package com.cff.tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cff.pages.OrangeHRMLoginPage;
import com.google.common.util.concurrent.Uninterruptibles;

public final class OrageHRMTest extends BaseTests{

	private OrageHRMTest() {

	}

	//@Test
	public void loginLogoutTest1() throws Throwable {
//		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();	
//				ohlp.enterUserName("admin");
//				ohlp.enterPassword("admin123");
//				ohlp.clickLoginButton();
//
//		OrangeHRMHomePage ohhp = ohlp.enterUserName("admin").enterPassword("admin123").clickLoginButton();
//		Thread.sleep(5000);
//		ohhp.clickLabelUsername().clickLinkLogout();
//
//		System.out.println("logout");
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		String title =  new OrangeHRMLoginPage().enterUserName("admin").enterPassword("admin123").clickLoginButton()
						.clickLabelUsername().clickLinkLogout()
						.getTitle();
		Uninterruptibles.sleepUninterruptibly(8, TimeUnit.SECONDS);
		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}
	
	@Test(dataProvider = "LoginTest")
	public void loginLogoutTest(String username, String password) throws Throwable {
		Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
		String title =  new OrangeHRMLoginPage().enterUserName("admin").enterPassword("admin123").clickLoginButton()
						.clickLabelUsername().clickLinkLogout()
						.getTitle();
		Uninterruptibles.sleepUninterruptibly(8, TimeUnit.SECONDS);
		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}
	
	@DataProvider(name = "LoginTest", parallel = true)
	public Object[][] getData(){
		
		
		return new Object[][] {
			
			{"admin","admin123"},
			{"admin","admin123"}
			
		};	
	}
	
	
}
