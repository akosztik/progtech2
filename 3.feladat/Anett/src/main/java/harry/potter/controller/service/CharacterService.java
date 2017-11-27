package harry.potter.controller.service;

import harry.potter.controller.datasource.CharacterDatasource;
import harry.potter.model.Character;

public class CharacterService {

    CharacterDatasource chard = new CharacterDatasource();

    public void addCharacter(Character character) {
        chard.addCharacter(character.getName());
    }
}
