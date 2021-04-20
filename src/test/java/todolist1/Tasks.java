package todolist1;

import org.testng.annotations.Test;

import repertoireobjet.pageobjet;

import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tasks extends Classbase {
	private static Logger log = LogManager.getLogger(Tasks.class.getName());

	@Test
	public void taches() {
		pageobjet todolist = new pageobjet(driver);

		WebDriverWait d = new WebDriverWait(driver, 10);
		d.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/input[1]")));
		todolist.identifiant().click();
		todolist.identifiant().sendKeys("test@test.com");
		todolist.identifiant().sendKeys(Keys.TAB);
		todolist.motdepasse().sendKeys("test");
		todolist.boutonenvoyer().click();

		// Créer une tache
		todolist.creertache().sendKeys("tache111");
		todolist.descriptiontache().sendKeys("test111");
		todolist.boutonajouter().click();
		log.info("Tache créee avec succès");

		// Verifier le bouton de modification de statut
		String currentmessage = todolist.modifierstatut().getText();
		String expectedmessage = "Non complétée";
		Assert.assertEquals(currentmessage, expectedmessage);
		System.out.println("Tache est non complétée (correct)");
		log.info("tache à l'état non complète");
		todolist.statutnoncomplété().click();
		String currentmessage2 = todolist.statutcomplété().getText();
		String expectedmessage2 = "Complétée";
		Assert.assertEquals(currentmessage2, expectedmessage2);
		System.out.println("Tache est complétée (correct)");
		log.info("tache à l'état complète");

		// verifier le bouton de suppression
		todolist.boutonsupprimer().click();
		log.info("tache supprimé avec succès");
		/*
		 * LocalStorage local = ((WebStorage) driver).getLocalStorage(); //
		 * local.clear(); int t = local.size(); Assert.assertEquals(t, 0); if (true) {
		 * System.out.println("LocalStorage mis à jour");
		 * log.info("LocalStorage mis à jour"); } else {
		 * System.out.println("LocalStorage n'est pas mis à jour");
		 * log.info("LocalStorage n'est pas mis à jour"); }
		 */
	}

	@Test
	public void boutonajouter() {
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

		Boolean actualvalue = todolist.boutonajouter().isEnabled();

		// Vérifier si le bouton ajouter est activé lorsque les deux champs sont vides
		if (actualvalue) {
			System.out.println("Bouton ajouter est activé (bug)");
			log.error("Bouton ajouter activé lorsque les champs sont vides");
		} else {
			System.out.println("Bouton ajouter est désactivé (correct)");
			log.info("Bouton ajouter désactivé");
		}

		// Vérifier si le bouton ajouter est activé lorsque le champs description est
		// vide
		todolist.creertache().sendKeys("tache112");
		if (actualvalue) {
			System.out.println("Bouton ajouter est activé (bug)");
			log.error("Bouton ajouter activé lorsque le champs description est vide");
		} else {
			System.out.println("Bouton ajouter est désactivé (correct)");
			log.info("Bouton ajouter désactivé");
		}

		// Vérifier si le bouton ajouter est activé lorsque les deux champs sont remplis
		todolist.descriptiontache().sendKeys("test112");
		if (actualvalue) {
			System.out.println("Bouton ajouter est activé (correct)");
			log.info("Bouton ajouter activé");
		} else {
			System.out.println("Bouton ajouter est désactivé (bug)");
			log.error("Bouton ajouter est désactivé lorsque les champs sont remplis");
		}

		// Vérifier si le bouton ajouter est activé lorsque le champs creer tache est
		// vide
		todolist.creertache().clear();
		if (actualvalue) {
			System.out.println("Bouton ajouter est activé (bug)");
			log.error("Bouton ajouter activé lorsque le champs créer tache est vide");
		} else {
			System.out.println("Bouton ajouter est désactivé (correct)");
			log.info("Bouton ajouter désactivé");
		}
	}

}