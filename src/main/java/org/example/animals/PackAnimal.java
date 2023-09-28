package org.example.animals;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
public abstract class PackAnimal extends BaseAnimal {
    public PackAnimal(String name, String nameClass, String birthday, ArrayList skills) throws ParseException {
        super(name, "Вьючные животные", nameClass, birthday, skills);
    }
}
