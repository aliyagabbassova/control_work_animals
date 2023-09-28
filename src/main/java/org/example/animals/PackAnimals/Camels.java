package org.example.animals.PackAnimals;
import org.example.animals.PackAnimal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
public class Camels extends PackAnimal {
    public Camels(String name, String birthday, ArrayList skills) throws ParseException {
        super(name, "Верблюд", birthday, skills);
    }
}