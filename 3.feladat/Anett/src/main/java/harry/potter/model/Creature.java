package harry.potter.model;

import java.util.Date;

public class Creature extends Entities {


    private Date firstMate;

    public Creature(String name) {
        super(name);
        this.firstMate = null;
    }
    public Creature(String name, String character, Date firstMet) {
        super(name,character);
        this.firstMate = firstMet;
    }

    public Date getFirstMate() {
        return firstMate;
    }

    public void setFirstMate(Date firstMate)  {
        if (firstMate==null){
            this.firstMate = firstMate;
        }
        else{
            System.out.println("mar megadva");
        }
    }

    @Override
    public String toString() {
        return "Creature{" +
                ", firstMate=" + firstMate +
                '}';
    }
}
