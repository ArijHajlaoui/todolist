package todolist1;

import org.testng.annotations.Test;

import repertoireobjet.pageobjet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Navbar extends Classbase {
	private static Logger log = LogManager.getLogger(Navbar.class.getName());

	@Test
	public void taches() {
		pageobjet todolist = new pageobjet(driver);
		todolist.menutaches().click();
		Boolean realvalue = todolist.menutaches().isDisplayed();
		if (realvalue) {
			System.out.println("Bouton taches est affiché (bug)");
			log.error("Bouton tache affiché dans home");
		} else {
			System.out.println("Bouton taches n'est pas affiché (correct)");
			log.info("Bouton tache n'est pas affiché dans home");
		}
	}

	@Test
	public void deconnexion() {
		pageobjet todolist = new pageobjet(driver);
		todolist.menudeconnexion().click();
		Boolean realvalue = todolist.menudeconnexion().isDisplayed();
		if (realvalue) {
			System.out.println("Bouton déconnexion est affiché (bug)");
			log.error("Bouton déconnexion affiché dans home");
		} else {
			System.out.println("Bouton déconnexion n'est pas affiché (correct)");
			log.info("Bouton déconnexion n'est pas affiché dans home");
		}
	}

}
