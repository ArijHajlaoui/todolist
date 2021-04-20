package todolist1;

import org.testng.annotations.Test;

import repertoireobjet.pageobjet;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends Classbase {
	private static Logger log = LogManager.getLogger(Home.class.getName());

	@Test
	public void login() {
		// se connecter avec un login et mp valides
		pageobjet todolist = new pageobjet(driver);

		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/input[1]")));
		todolist.identifiant().click();
		todolist.identifiant().sendKeys("test@test.com");
		todolist.identifiant().sendKeys(Keys.TAB);
		todolist.motdepasse().sendKeys("test");
		todolist.boutonenvoyer().click();
	}

	@Test
	public void envoyer() {

		pageobjet todolist = new pageobjet(driver);
		Boolean actualvalue = todolist.boutonenvoyer().isEnabled();

		// Vérifier si le bouton envoyer est activé lorsque les deux champs sont vides
		if (actualvalue) {
			System.out.println("Bouton envoyer est activé (bug)");
			log.error("Bouton envoyé activé lorsque les champs sont vides");
		} else {
			System.out.println("Bouton envoyer est désactivé (correct)");
			log.info("bouton envoyé est désactivé");
		}

		// Vérifier si le bouton envoyer est activé lorsque le champs mot de passe est
		// vide
		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/input[1]")));
		todolist.identifiant().click();
		todolist.identifiant().sendKeys("test@test.com");
		if (actualvalue) {
			System.out.println("Bouton envoyer est activé (bug)");
			log.error("Bouton envoyé activé lorsque le champs mp est vides");
		} else {
			System.out.println("Bouton envoyer est désactivé (correct)");
			log.info("bouton envoyé est désactivé");
		}

		// Vérifier si le bouton envoyer est activé lorsque les deux champs sont remplis
		todolist.identifiant().sendKeys(Keys.TAB);
		todolist.motdepasse().sendKeys("test");
		if (actualvalue) {
			System.out.println("Bouton envoyer est activé (correct)");
			log.info("bouton envoyé est activé");
		}

		else {
			System.out.println("Bouton envoyer est désactivé (bug)");
			log.error("Bouton envoyé désactivé lorsque les champs sont remplis");
		}

		// Vérifier si le bouton envoyer est activé lorsque le champs adresse mail est
		// vide
		todolist.identifiant().clear();
		if (actualvalue) {
			System.out.println("Bouton envoyer est activé (bug)");
			log.error("Bouton envoyé activé lorsque le champs adresse mail est vide");
		} else {
			System.out.println("Bouton envoyer est désactivé (correct)");
			log.info("bouton envoyé est désactivé");
		}
	}

	@Test
	public void alerteconnexion() {

		pageobjet todolist = new pageobjet(driver);
		todolist.identifiant().click();
		todolist.identifiant().sendKeys("test@test");
		todolist.identifiant().sendKeys(Keys.TAB);
		todolist.motdepasse().sendKeys("testt");
		todolist.boutonenvoyer().click();

		String currentmessage = todolist.messagealerte().getText();
		String expectedmessage = "Désolé, les identifiants sont incorrects.";
		Assert.assertEquals(currentmessage, expectedmessage);
		System.out.println("Alerte rouge est affiché");
		log.info("alerte rouge est affiché lorsques les identifiants sont erronés");
	}

}
