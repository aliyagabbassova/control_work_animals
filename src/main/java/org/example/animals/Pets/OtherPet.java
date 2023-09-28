package org.example.animals.Pets;
import org.example.animals.Pet;

import java.text.ParseException;
import java.util.ArrayList;

public class OtherPet extends Pet {
    public OtherPet(String name, String nameClass, String birthday, ArrayList skills) throws ParseException {
        super(name, nameClass, birthday, skills);
    }
}