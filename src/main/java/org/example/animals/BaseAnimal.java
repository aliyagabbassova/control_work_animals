package org.example.animals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class BaseAnimal {
    protected String name; // Имя животного
    protected String mainClass; // Класс животного
    protected String nameClass; // Подкласс животного
    protected Date birthday; // Дата рождения

    protected ArrayList skills; // Умения

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public BaseAnimal (String name, String mainClass, String nameClass, String birthday, ArrayList skills) throws ParseException {
        this.name = name;
        this.mainClass = mainClass;
        this.nameClass = nameClass;
        this.birthday = format.parse(birthday);
        this.skills = skills;
    }

    public String getInfo() {
        String str = mainClass + " " + nameClass + " " + name + " " + new SimpleDateFormat("yyyy-MM-dd").format(birthday) + " " + String.join(" / ",skills);
        return str;
    }

    public ArrayList getSkills() {
        return this.skills;
    }

    public void setSkills(ArrayList skills) {
        this.skills = skills;
    }

}

