package org.example.animals.PackAnimals;
import org.example.animals.PackAnimal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Donkeys extends PackAnimal {
    public Donkeys(String name, String birthday, ArrayList skills) throws ParseException {
        super(name, "Осел", birthday, skills);
    }
}
