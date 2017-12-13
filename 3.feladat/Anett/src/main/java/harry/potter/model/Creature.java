package harry.potter.model;

import java.util.Date;

public class Creature extends Entities {
    private Integer Id;
    private String firstMate;

    /**
    * A tulterhelt kostruktorok:
     * a Creature letrehozasakor (elso) csak nevvel peldanyosit.
     * Mig adatbazisbol letrejott Creature mar az adatbazisban letarolt osszes informacioval peldanyosit.
     */

    public Creature(String name) {
        super(name);
        this.firstMate = null;
    }

    public Creature(Integer Id,String name, String character) {
        super(name,character);
        this.Id=Id;
    }
    public Creature(Integer Id,String name, String character,String firstMet) {
        super(name,character);
        this.Id=Id;
        this.firstMate=firstMet;
    }

    /**
     * A kovetkezo metodusok az osztaly getter es setter metodusai:
     */

    public String getFirstMate() {
        return firstMate;
    }

    public void setFirstMate(String firstMate)  {
        if (firstMate==null){
            this.firstMate = firstMate;
        }
        else{
            System.out.println("mar megadva");
        }
    }

    /**
     * A feluldefinialt toString metodus egy karakterlancot ad vissza.
     */

    public int getId() {
        return this.Id;
    }



    @Override
    public String toString() {
        return "Creature{" +
                ", firstMate=" + firstMate +
                '}';
    }
}
