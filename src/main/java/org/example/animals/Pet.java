package org.example.animals;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public abstract class Pet extends BaseAnimal{

    public Pet(String name, String nameClass, String birthday, ArrayList skills) throws ParseException {
        super(name, "Домашние животные", nameClass, birthday, skills);
    }
}
