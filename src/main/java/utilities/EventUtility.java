package main.java.utilities;

import java.util.Random;

import main.java.aquarium.Aquarium;

public class EventUtility {

    Random random;
	Aquarium aquarium;
	
	public EventUtility(Aquarium aquarium) {
    	this.aquarium = aquarium;
    	random = new Random();
	}
	
	private void feed() {
		int amount = aquarium.getFishNumber() + aquarium.getRapaciousFishNumber();
		aquarium.getFoodCreator().createFodder(amount);
		System.out.println("Dosypano karme");
		aquarium.getDataUtility().saveToTxt("Dosypano karme");
	}
	
	private void growAlga() {
		int amount = aquarium.getSnailNumber() + aquarium.getPrawnNumber();
		aquarium.getFoodCreator().createAlga(amount);
		aquarium.getDataUtility().saveToTxt("Akwarium obroslo glonem");
		System.out.println("Akwarium obroslo glonem");
	}
	
	private void addFish() {
		aquarium.getOrganismCreator().createOrganisms(1, 0, 0, 0);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Fish");
		System.out.println("Do akwarium wrzucono Fish");
	}
	
	private void addRapaciousFish() {
		aquarium.getOrganismCreator().createOrganisms(0, 1, 0, 0);	
		System.out.println("Do akwarium wrzucono RapaciousFish");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono RapaciousFish");
	}
	
	private void addSnail() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 1, 0);
		System.out.println("Do akwarium wrzucono slimaka");
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Snail");
	}
	
	private void addPrawn() {
		aquarium.getOrganismCreator().createOrganisms(0, 0, 0, 1);	
		aquarium.getDataUtility().saveToTxt("Do akwarium wrzucono Prawn");
		System.out.println("Do akwarium wrzucono krewetke");
	}
	
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
