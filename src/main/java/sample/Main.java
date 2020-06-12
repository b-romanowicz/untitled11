package main.java.sample;

import java.util.Arrays;
import java.util.List;

import main.java.aquarium.Aquarium;
import main.java.aquarium.creators.AquariumCreator;
import main.java.objects.Organism;

/**
 * Klasa odpowiedzialna za symulacj�.
 * @author jakkard
 * @version 1.0
 */
public class Main  {
	
	/**
	 * Akwarium, w w kt�ry odbywa� si� b�dzie symulacja.
	 */
	private Aquarium aquarium;
	
	/**
	 * Maksymalna liczba iteracji symulacji.
	 */
	private int maxIterNum;
	
	/**
	 * Tworzy instancj� symulacji.
	 * @param aquariumCreator kreator akwarium, w kt�rym b�dzie odbywa� si� symulacja.
	 * @param maxIterNum maksymalna liczba iteracji symulacji.
	 */
	public Main(AquariumCreator aquariumCreator, int maxIterNum) {
		aquarium = aquariumCreator.createAquarium();
		this.maxIterNum = maxIterNum;
	}
	
	/**
	 * Uruchamia symulacj� z pocz�tkowymi parametrami ilo�ci poszczeg�lnych organizm�w
	 * trwaj�c� a� do osi�gni�cia maksymalnej liczby iteracji lub zdominowania akwarium przez jaki� typ organizm�w.
	 * @param fishNum pocz�tkowa ilo�� ryb (bez drapie�nych ryb) w akwarium.
	 * @param rapaciousFishNum pocz�tkowa ilo�� drapie�nych ryb w akwarium.
	 * @param snailNumber pocz�tkowa ilo�� �limak�w w akwarium.
	 * @param prawnNumber pocz�tkowa ilo�� krewetek w akwarium.
	 */
	public void run(int fishNum, int rapaciousFishNum, int snailNumber, int prawnNumber) {
		int iters = maxIterNum;
		aquarium.getOrganismCreator().createOrganisms(fishNum, rapaciousFishNum, snailNumber, prawnNumber);
		do {
			aquarium.getDataUtility().saveToTxt(maxIterNum-iters+1 + ":");
			System.out.println(maxIterNum - iters + 1);
			List<Organism> organisms = aquarium.getOrganisms();
			for(Organism organism : organisms) { 
				organism.move();
				organism.feelHunger();
			}
			aquarium.spoilFood();
			aquarium.getEventUtility().randomEvent();
			List<String> strings = Arrays.asList("" + (maxIterNum-iters+1), "" + aquarium.getFishNumber(), "" + aquarium.getRapaciousFishNumber(), 
					"" + aquarium.getSnailNumber(), "" + aquarium.getPrawnNumber(), 
					"" + aquarium.getFodderNumber(), "" + aquarium.getAlgaNumber());
			aquarium.getDataUtility().saveToCsv(strings);
			if(aquarium.specimenDominates()) break;
		} while(--iters>0);
	}
	
	/**
	 * Sprawdza, czy podany string jest liczb� oraz czy mo�e by� rozmiarem akwarium. Je�li nie zwraca domy�lny rozmiar.
	 * @param arg string podany przy uruchamianiu programu.
	 * @return rozmiar wymiaru.
	 */
	private static int checkDimension(String arg) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<2) return 5;
            return integer;
		} catch (NumberFormatException e) {
            return 5;
		}
	}
	
	/**
	 * Sprawdza, czy podany string jest liczb� oraz czy mo�e by� pocz�tkow� ilo�ci� populacji pewnego typu organizm�w. Je�li nie zwraca domy�ln� ilo��.
	 * @param arg string podany przy uruchamianiu programu.
	 * @param size maksymalna liczba populacji ka�dego typu organizmu.
	 * @return ilo�� organizm�w pojedy�czego typu.
	 */
	private static int checkPopulation(String arg, int size) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<0) return 0;
            if(integer>size) return size;
            return integer;
		} catch (NumberFormatException e) {
			return 2;
		}
	}
	
	/**
	 * Sprawdza, czy podany string jest liczb� oraz czy mo�e by� maksymaln� ilo�ci� iteracji. Je�li nie zwraca domy�ln� maksymaln� ilo�� iteracji.
	 * @param arg string podany przy uruchamianu programu.
	 * @return maksymalna ilo�� iteracji.
	 */
	private static int checkMaxIters(String arg) {
		try {
            int integer = Integer.parseInt(arg);
            if(integer<0) return 50;
            return integer;
		} catch (NumberFormatException e) {
			return 100;
		}
	}
	
	/**
	 * Uruchamia symulacj� z podanymi parametrami pocz�tkowymi w kolejno�ci: d�ugo��_akwarium szeroko�� akwarium wysoko��_akwarium
	 * ilo��_ryb ilo��_drapie�nych_ryb ilo��_�limak�w ilo��_krewetek maksymalna_liczba_iteracji. Je�li brak jest argument�w lub jakie� argumenty
	 * nie mog� by� parametrami ustawia domy�lne warto�ci.
	 * @param args argumenty podane przy uruchamianiu programu.
	 */
    public static void main(String[] args) {
    	int length;
    	if(args.length<1) length = 5;
    	else length = checkDimension(args[0]);
    	int width;
    	if(args.length<2) width=5;
    	else width = checkDimension(args[1]);
	    int height;
	    if(args.length<3) height=5;
	    else height = checkDimension(args[2]);
	    int size = length*width*height/5;
	    int fishNumber;
	    if(args.length<4) fishNumber=2;
	    else fishNumber = checkPopulation(args[3], size);
	    int rapaciousFishNumber;
	    if(args.length<5) rapaciousFishNumber=2;
	    else rapaciousFishNumber = checkPopulation(args[4], size);
	    int snailNumber;
	    if(args.length<6) snailNumber=2;
	    else snailNumber = checkPopulation(args[5], size);
	    int prawnNumber;
	    if(args.length<7) prawnNumber=2;
	    else prawnNumber = checkPopulation(args[6], size);
	    int maxIters;
	    if(args.length<8) maxIters=100;
	    else maxIters = checkMaxIters(args[7]);
	    AquariumCreator aquariumCreator = new AquariumCreator(length, width, height);
	    Main simulation = new Main(aquariumCreator, maxIters);
	    simulation.run(fishNumber, rapaciousFishNumber, snailNumber, prawnNumber);
	    System.out.println("Pomyslnie zakonczono symulacje");
    }
}
