package harry.potter.model;

import java.util.Date;

public class Creature extends Entities {
    private Integer Id;
    private Date firstMate;

    public Creature(String name) {
        super(name);
        this.firstMate = null;
    }
    public Creature(Integer Id,String name, String character) {
        super(name,character);
        this.Id=Id;
    }
    public Creature(Integer Id,String name, String character,Date firstMet) {
        super(name,character);
        this.Id=Id;
        this.firstMate=firstMet;
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
