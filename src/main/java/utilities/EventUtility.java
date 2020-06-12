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
	 * Obiekt klasy random, generator pseudolosowo�ci.
	 */
    Random random;
	
    /**
     * Akwarium, w kt�rym mog� wyst�pi� zdarzenia losowe.
     */
    Aquarium aquarium;
	
    /**
     * Tworzy instancj� klasy narz�dzii zdarze� losowych.
     * @param aquarium akwarium, w kt�rym te zdarzenia maj� zachodzi�.
     */
	public EventUtility(Aquarium aquarium) {
    	this.aquarium = aquarium;
    	random = new Random();
	}
	
	/**
	 *Imituje karmienie, czyli wsypanie karmy do akwarium. W przestrzeni akwarium pojawi si� na losowych pozycjach tyle karmy, ile jest ryb obu typ�w.
	 */
	private void feed() {
		int amount = aquarium.getFishNumber() + aquarium.getRapaciousFishNumber();
		aquarium.getFoodCreator().createFodder(amount);
		System.out.println("Dosypano karme");
		aquarium.getDataUtility().saveToTxt("Dosypano karme");
	}
	
	/**
	 * Imituje obro�ni�cie akwarium glonem. Na �cianach oraz pod�o�u akwarium pojawi si� losowo tyle glon�w ile jest w sumie �limak�w i krewetek.
	 */
	private void growAlga() {
		int amount = aquarium.getSnailNumber() + aquarium.getPrawnNumber();
		aquarium.getFoodCreator().createAlga(amount);
		aquarium.getDataUtility().saveToTxt("Akwarium obroslo glonem");
		System.out.println("Akwarium obroslo glonem");
	}
	
	/**
	 * Imituje wrzucenie ryby do akwarium. W przestrzeni akwarium losowo pojawia si� ryba.
	 */
	private void addFish() {
		aquarium.getOrganismCreator().createOrganisms(1, 0, 0, 0);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Fish");
		System.out.println("Do akwarium wrzucono Fish");
	}
	
	/**
	 * Imituje wrzucenie drapie�nej ryby do akwarium. W przestrzeni akwarium losowo pojawia si� drapie�na ryba.
	 */
	private void addRapaciousFish() {
		aquarium.getOrganismCreator().createOrganisms(0, 1, 0, 0);	
		System.out.println("Do akwarium wrzucono RapaciousFish");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono RapaciousFish");
	}
	
	/**
	 * Imituje wrzucenie �limaka do akwarium. Na �cianach akwarium losowo pojawi si� �limak.
	 */
	private void addSnail() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 1, 0);
		System.out.println("Do akwarium wrzucono slimaka");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Snail");
	}
	
	/**
	 * Imituje wrzucenie krewetek do akwarium. Na pod�o�u akwarium losowo pojawi si� krewetka.
	 */
	private void addPrawn() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 0, 1);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Prawn");
		System.out.println("Do akwarium wrzucono krewetke");
	}
	
	/**
	 * Losuje 1 zdarzenie losowe, z za�o�eniem �e mo�na wylosowa� brak zdarzenia losowego.
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
