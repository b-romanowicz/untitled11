package main.java.utilities;

import java.util.Random;

import main.java.aquarium.Aquarium;

/**
 * 
 * @author jakkard
 *
 */
public class EventUtility {
	
	/**
	 * Obiekt klasy random, generator pseudolosowoœci.
	 */
    Random random;
	
    /**
     * Akwarium, w którym mog¹ wyst¹piæ zdarzenia losowe.
     */
    Aquarium aquarium;
	
    /**
     * Tworzy instancjê klasy narzêdzii zdarzeñ losowych.
     * @param aquarium akwarium, w którym te zdarzenia maj¹ zachodziæ.
     */
	public EventUtility(Aquarium aquarium) {
    	this.aquarium = aquarium;
    	random = new Random();
	}
	
	/**
	 *Imituje karmienie, czyli wsypanie karmy do akwarium. W przestrzeni akwarium pojawi siê na losowych pozycjach tyle karmy, ile jest ryb obu typów.
	 */
	private void feed() {
		int amount = aquarium.getFishNumber() + aquarium.getRapaciousFishNumber();
		aquarium.getFoodCreator().createFodder(amount);
		System.out.println("Dosypano karme");
		aquarium.getDataUtility().saveToTxt("Dosypano karme");
	}
	
	/**
	 * Imituje obroœniêcie akwarium glonem. Na œcianach oraz pod³o¿u akwarium pojawi siê losowo tyle glonów ile jest w sumie œlimaków i krewetek.
	 */
	private void growAlga() {
		int amount = aquarium.getSnailNumber() + aquarium.getPrawnNumber();
		aquarium.getFoodCreator().createAlga(amount);
		aquarium.getDataUtility().saveToTxt("Akwarium obroslo glonem");
		System.out.println("Akwarium obroslo glonem");
	}
	
	/**
	 * Imituje wrzucenie ryby do akwarium. W przestrzeni akwarium losowo pojawia siê ryba.
	 */
	private void addFish() {
		aquarium.getOrganismCreator().createOrganisms(1, 0, 0, 0);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Fish");
		System.out.println("Do akwarium wrzucono Fish");
	}
	
	/**
	 * Imituje wrzucenie drapie¿nej ryby do akwarium. W przestrzeni akwarium losowo pojawia siê drapie¿na ryba.
	 */
	private void addRapaciousFish() {
		aquarium.getOrganismCreator().createOrganisms(0, 1, 0, 0);	
		System.out.println("Do akwarium wrzucono RapaciousFish");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono RapaciousFish");
	}
	
	/**
	 * Imituje wrzucenie œlimaka do akwarium. Na œcianach akwarium losowo pojawi siê œlimak.
	 */
	private void addSnail() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 1, 0);
		System.out.println("Do akwarium wrzucono slimaka");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Snail");
	}
	
	/**
	 * Imituje wrzucenie krewetek do akwarium. Na pod³o¿u akwarium losowo pojawi siê krewetka.
	 */
	private void addPrawn() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 0, 1);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Prawn");
		System.out.println("Do akwarium wrzucono krewetke");
	}
	
	/**
	 * Losuje 1 zdarzenie losowe, z za³o¿eniem ¿e mo¿na wylosowaæ brak zdarzenia losowego.
	 */
	public void randomEvent() {
		int randomInt = random.nextInt(100)+1;
		if(randomInt<=20) feed();
		else if(randomInt<=40) growAlga();
		else if(randomInt<=41) addFish();
		else if(randomInt<=42) addRapaciousFish();
		else if(randomInt<=43) addSnail();
		else if(randomInt<=44) addPrawn();
	}
}
