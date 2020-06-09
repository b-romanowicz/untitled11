package sample;

import java.util.Random;

import main.java.aquarium.Aquarium;
import main.java.objects.Fish;
import main.java.objects.Prawn;
import main.java.objects.RapaciousFish;
import main.java.objects.Snail;

public class Event {


    public void losujEvent() {

        Random losowa = new Random();
        int wylosowana = losowa.nextInt(140);

        if (wylosowana<10) {
            System.out.println("Pierwsza opcja");
            resetuj_pozycje();
        }
        else if (wylosowana>=10 && wylosowana<19) {
            System.out.println("Druga opcja");
            zmien_temperature();
        }
        else if (wylosowana>=20 && wylosowana<30) {
            System.out.println("Trzecia opcja");
            zabij_losowo();
        }
        else if (wylosowana>=30 && wylosowana<40) {
            System.out.println("Czwarta opcja");
            zwieksz_rozmiar();
        }
        else if (wylosowana>=40 && wylosowana<50) {
            System.out.println("Piąta opcja");
            karmienie_ryb();
        }
        else if (wylosowana>=50 && wylosowana<60) {
            System.out.println("Szosta opcja");
            zepsuty_filtr();
        }
        else if (wylosowana>=60 && wylosowana<70) {
            System.out.println("Siodma opcja");
            czyszczenie_akwarium();
        }
        else {
            System.out.println("Nie wylosowano event'u");
        }
    }


    public void resetuj_pozycje(){

    }
    public void zmien_temperature(){

    }
    public void zabij_losowo(){

    }
    public void zwieksz_rozmiar(){

    }
    public void karmienie_ryb(){
    }
    public void zepsuty_filtr(){

    }
    public void czyszczenie_akwarium(){

    }


    public void kreator_karmy() {

    }



}
