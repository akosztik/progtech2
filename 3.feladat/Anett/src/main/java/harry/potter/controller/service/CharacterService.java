package harry.potter.controller.service;

import harry.potter.controller.datasource.CharacterDatasource;
import harry.potter.model.Character;
import harry.potter.model.Student;

import java.util.List;

public class CharacterService {

    CharacterDatasource chard = new CharacterDatasource();
    /**
     * Ezekkel a metodussal a CharacterDatasource metódusanak adjuk at a character nevet.
     * parametere: a character, a Character osztaly egy peldanya.
     */
    public void addCharacter(Character character) {
        chard.addCharacter(character.getName());
    }
    /**
     * Ezzel a metodussal a CharacterDatasource metodusa meghivva,
     * amely az sql parancsot generlja es futtatja, egy listat kapunk vissza az összes
     * karakterrel.
     */
    public List<Character> listCharacters() {
        List<Character> characters = chard.listCharacters();
        return characters;
    }
    /**
     * Ezzel a metodussal listabol string arrayt allitunk elo.
     * parametere: ArrayList
     */
    public String[] toArray(List<Character> characterList){
        String[] list=new String[characterList.size()];
        for (int i =0;i<characterList.size();i++ ){
            list[i]=characterList.get(i).getName();
        }
        return list;
    }
}
