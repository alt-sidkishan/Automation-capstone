package bindings;

import java.io.IOException;

import com.wipro.pageObjects.AccountLogoutPage;
import com.wipro.pageObjects.HomePage;
import com.wipro.pageObjects.LoginPage;
import com.wipro.pageObjects.MyAccountPage;
import com.wipro.utilities.PageActions;
import com.wipro.utilities.TakeScreenshot;
import com.wipro.utilities.TestOutput;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	@Given("I am on login page")
	public void i_am_on_login_page() throws IOException {
		HomePage.goToLoginPage();
	}

	@When("I enter {string} and {string} and logged in")
	public void i_enter_and_and_logged_in(String string, String string2) throws InterruptedException {
		String[] userCredentials = { string, string2 };
		LoginPage.fillLoginForm(userCredentials);
	}

	@Then("I count number of menu links")
	public void i_count_number_of_menu_links() throws IOException {
		TestOutput.writeMsgToFile("TC04_NumberOfMenuLinks.txt",
				"Number of Menu Links: " + MyAccountPage.allMenuLinks.size());
	}

	@Then("I click on each link one by one")
	public void i_click_on_each_link_one_by_one() throws IOException {

		for (int i = 0; i < MyAccountPage.allMenuLinks.size(); i++) {
			PageActions.click(MyAccountPage.allMenuLinks.get(i));
			TakeScreenshot.takeScreenshot("TC04_MenuLinkScreenShot" + i + ".png");
		}
	}

	@Then("I click on logout")
	public void i_click_on_logout() throws IOException {
		MyAccountPage.logoutFromAccount();
		TakeScreenshot.takeScreenshot("TC04_LogoutScreenshot.png");
		TestOutput.writeMsgToFile("TC04_LogoutMsg.txt", AccountLogoutPage.getLogoutMessage());
	}

}
