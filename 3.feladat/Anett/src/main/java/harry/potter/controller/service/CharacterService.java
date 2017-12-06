package harry.potter.controller.service;

import harry.potter.controller.datasource.CharacterDatasource;
import harry.potter.model.Character;

import java.util.List;

public class CharacterService {

    CharacterDatasource chard = new CharacterDatasource();

    public void addCharacter(Character character) {
        chard.addCharacter(character.getName());
    }
    public List<Character> listCharacters() {
        List<Character> characters = chard.listCharacters();
        return characters;
    }
}
