package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

public class CreatureService {

    CreatureDatasource cd = new CreatureDatasource();

    public void addCreature(Creature creature) {
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
}
