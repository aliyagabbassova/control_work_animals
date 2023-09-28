package org.example.animals.Pets;
import org.example.animals.Pet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Dogs extends Pet {
    public Dogs(String name, String birthday, ArrayList skills) throws ParseException {

        super(name, "Собака", birthday, skills);
    }
}