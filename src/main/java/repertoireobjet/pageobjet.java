package repertoireobjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageobjet {
	WebDriver driver;

	public pageobjet(WebDriver driver) {
		this.driver = driver;
	}

	private By id = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/input[1]");
	private By mp = By.cssSelector(":focus");
	private By benvoyer = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[3]/input[1]");
	private By alerte = By.xpath("//div[contains(text(),'Désolé, les identifiants sont incorrects.')]");
	private By creer = By.cssSelector("div.container.mt-5 div:nth-child(1) div.row:nth-child(5) div.col:nth-child(1) > input.form-control:nth-child(2)");
	private By description = By.cssSelector("div.container.mt-5 div:nth-child(1) div.row:nth-child(5) div.col:nth-child(2) > input.form-control:nth-child(2)");
	private By ajouter = By.cssSelector("div.container.mt-5 div:nth-child(1) div.row:nth-child(5) div.col:nth-child(3) > button.btn.btn-primary:nth-child(2)");
	private By modifier = By.xpath("//div[contains(text(),'Non complétée')]");
	private By modifier2 = By.xpath("//div[contains(text(),'Non complétée')]");
	private By modifier3 = By.xpath("//div[contains(text(),'Complétée')]");
	private By supprimer = By.xpath("//body/div[@id='root']/div[1]/div[1]/ul[1]/li[1]/span[1]/a[1]");
	private By taches = By.linkText("Tâches");
	private By deconnexion = By.linkText("Déconnexion");

	public WebElement identifiant() {
		return (driver.findElement(id));
	}

	public WebElement motdepasse() {
		return (driver.findElement(mp));
	}

	public WebElement boutonenvoyer() {
		return (driver.findElement(benvoyer));
	}

	public WebElement messagealerte() {
		return (driver.findElement(alerte));
	}

	public WebElement creertache() {
		return (driver.findElement(creer));
	}

	public WebElement descriptiontache() {
		return (driver.findElement(description));
	}

	public WebElement boutonajouter() {
		return (driver.findElement(ajouter));
	}

	public WebElement modifierstatut() {
		return (driver.findElement(modifier));
	}

	public WebElement statutnoncomplété() {
		return (driver.findElement(modifier2));
	}

	public WebElement statutcomplété() {
		return (driver.findElement(modifier3));
	}

	public WebElement boutonsupprimer() {
		return (driver.findElement(supprimer));
	}

	public WebElement menutaches() {
		return (driver.findElement(taches));
	}

	public WebElement menudeconnexion() {
		return (driver.findElement(deconnexion));
	}

}
