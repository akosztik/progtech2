package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

import java.util.List;

public class CreatureService {

    CreatureDatasource cd = new CreatureDatasource();

    public void addCreature(Creature creature) {
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
    public List<Creature> listCreatures() {
        List<Creature> creatures = cd.listCreatures();
        return creatures;
    }
    public Creature getCreatureByName(String name){
        Creature creature= cd.getCreatureByName(name);
        return creature;
    }
}
