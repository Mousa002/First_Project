package testcasessaucelapwebsite;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCases {
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String MyWebsite = "https://www.saucedemo.com/v1/";
	String username = "standard_user";
	String passwordInput = "secret_sauce";

	@BeforeTest
	public void MySetUp() {
		driver.get(MyWebsite);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void Login() {
		// driver.findElement(By.id("user-name")).sendKeys(username);
		// driver.findElement(By.id("password")).sendKeys(passwordInput);
		// driver.findElement(By.id("login-button")).click();
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		UserNameInputField.sendKeys(username);
		PasswordInputField.sendKeys(passwordInput);
		LoginButton.click();

	}

	@Test(priority = 2, enabled = false)
	public void AddAllIteams() throws InterruptedException {
		List<WebElement> AddToCartButton = driver.findElements(By.className("btn_primary"));
		for (int i = 0; i < AddToCartButton.size(); i++) {
			AddToCartButton.get(i).click();
		}

		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void AddRandomIteams() {
		List<WebElement> AddToCartButtons = driver.findElements(By.className("btn_primary"));
		int randomindex = rand.nextInt(AddToCartButtons.size());
		AddToCartButtons.get(randomindex).click();
		System.out.println(randomindex);
	}

	@Test(priority = 4)
	public void CheckOutProces() {
		WebElement ShoppingCart = driver.findElement(By.className("shopping_cart_badge"));
		ShoppingCart.click();
		WebElement CheckOutButton = driver.findElement(By.className("checkout_button"));
		CheckOutButton.click();
		// Array of first names:
		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Edward" };
		int RandomFirstName = rand.nextInt(firstNames.length);
		// Arrray of last names:
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int RandomLastName = rand.nextInt(lastNames.length);
		// Array of postal codes:
		String[] postalCodes = { "12345", "67890", "54321", "98765", "11223" };
		int RandomPostalCode = rand.nextInt(postalCodes.length);
		WebElement FirstNameInput = driver.findElement(By.id("first-name"));
		WebElement LastNameInput = driver.findElement(By.id("last-name"));
		WebElement PostalCodeInput = driver.findElement(By.id("postal-code"));
		FirstNameInput.sendKeys(firstNames[RandomFirstName]);
		LastNameInput.sendKeys(lastNames[RandomLastName]);
		PostalCodeInput.sendKeys(postalCodes[RandomPostalCode]);
		WebElement ContinueButton = driver.findElement(By.className("cart_button"));
		ContinueButton.click();
		WebElement FinishButton = driver.findElement(By.className("btn_action"));
		FinishButton.click();

	}

	@AfterTest
	public void PostTesting() {

	}

}
