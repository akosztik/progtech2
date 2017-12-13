package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

import java.util.ArrayList;
import java.util.List;

public class CreatureService {

    CreatureDatasource cd = new CreatureDatasource();

    /**
     * Ezekkel a metodussal a CreatureDatasource metodusanak adjuk at a creature nevet, karakteret.
     * parametere: a creature, a Creature osztaly egy peldanya.
     */

    public void addCreature(Creature creature) {
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
    public List<Creature> listCreatures() {
        List<Creature> creatures = cd.listCreatures();
        return creatures;
    }
    public String[] toArray(List<Creature> creatureList){
        String[] list=new String[creatureList.size()];
        for (int i =0;i<creatureList.size();i++ ){
            list[i]=creatureList.get(i).getName();
        }
        return list;
    }
    public Creature getCreatureByName(String name){
        Creature creature= cd.getCreatureByName(name);
        return creature;
    }
    public void changeCharacter(String name, String character){
        cd.changeCharacter(name,character);
    }
    public void updateCreature(String name, String date){
        cd.updateCreature(name, date);
    }
}
