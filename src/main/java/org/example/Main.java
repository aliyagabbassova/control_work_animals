package org.example;
import org.example.animals.BaseAnimal;
import org.example.animals.OtherAnimal;
import org.example.animals.PackAnimals.Camels;
import org.example.animals.PackAnimals.Donkeys;
import org.example.animals.PackAnimals.Horses;
import org.example.animals.PackAnimals.OtherPack;
import org.example.animals.Pets.Cats;
import org.example.animals.Pets.Dogs;
import org.example.animals.Pets.Hamsters;
import org.example.animals.Pets.OtherPet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner iscanner = new Scanner(System.in);
    public static ArrayList<BaseAnimal> animalList = new ArrayList<>();
    public static void main(String[] args) throws ParseException {
        animalList.add(new Dogs("Гера", "2019-03-27", new ArrayList<>(Arrays.asList("Лежать", "Кусать", "Бегать"))));
        animalList.add(new Cats("Люся", "2016-05-17", new ArrayList<>(Arrays.asList("Лежать", "Играть"))));
        animalList.add(new Cats("Пушок", "2020-10-02", new ArrayList<>(Arrays.asList("Лежать"))));
        animalList.add(new Hamsters("Грызлик", "2010-11-18", new ArrayList<>(Arrays.asList("Бегать в колесе"))));
        animalList.add(new Horses("Пуля", "2019-03-27", new ArrayList<>(Arrays.asList("Скакать", "Перепрыгивать"))));
        animalList.add(new Camels("Рыжик", "2017-04-78", new ArrayList<>(Arrays.asList("Сидеть", "Играть"))));
        animalList.add(new Camels("Двугорбик", "2014-03-15", new ArrayList<>(Arrays.asList("Бегать", "Лежать"))));
        animalList.add(new Donkeys("Иа", "2021-07-02", new ArrayList<>(Arrays.asList("Катать"))));



        System.out.println("Реестр животных");
        int num = 1;
        int num1;
        int num2;
        int num3 = 1;
        int num4 = 1;

        ArrayList skills = new ArrayList<String>();

        while (num != 0) {
            System.out.println("Что Вы хотите сделать?\n1 - просмотреть список животных;\n2 - добавить животное;\n3 - добавить команду\n0 - выйти.");
            System.out.print("Ваш ответ: ");
            num = iscanner.nextInt();


            switch (num) {
                case 1:
                    int i = 0;
                    for (BaseAnimal unit : animalList) {
                        i++;
                        System.out.println(i + ". " + unit.getInfo());
                    }
                    break;

                case 2:
                    System.out.println("Какое животное Вы хотите добавить?\n1 - домашнее животное;\n2 - вьючное животное;\n3 - другое;\n0 - выйти.");
                    num1 = iscanner.nextInt();

                    System.out.println("Введите имя: ");
                    String name = iscanner.next();
                    System.out.println("Введите дату рождения (yyyy-MM-dd): ");
                    String date = iscanner.next();

                    String nameClass = null;
                    String mainClass = null;


                    while (num3 != 0) {
                        System.out.println("1 - добавить скилл \n0 - сохранить");
                        num3 = iscanner.nextInt();
                        switch (num3) {
                            case 1:
                                System.out.println("Скилл: ");
                                String skill = iscanner.next();
                                skills.add(skill);
                                break;
                        }

                    }


                    if (num1 == 1) {
                        System.out.println("Выбирете вид:\n1 - кошка;\n2 - собака;\n3 - хомяк;\n4 - другое;\n0 - выйти.");
                        num2 = iscanner.nextInt();

                        switch (num2) {

                            case 1:
                                animalList.add(new Cats(name, date, skills));
                                break;
                            case 2:
                                animalList.add(new Dogs(name, date, skills));
                                break;
                            case 3:
                                animalList.add(new Hamsters(name, date, skills));
                                break;
                            case 4:
                                System.out.println("Введите подвид животного: ");
                                nameClass = iscanner.next();
                                animalList.add(new OtherPet(name, nameClass, date, skills));
                        }

                    } else if (num1 == 2) {
                        System.out.println("Выбирете вид:\n1 - лошадь;\n2 - верблюд;\n3 - осел;\n4 - другое;\n0 - выйти.");
                        num2 = iscanner.nextInt();

                        switch (num2) {

                            case 1:
                                animalList.add(new Horses(name, date, skills));
                                break;
                            case 2:
                                animalList.add(new Camels(name, date, skills));
                                break;
                            case 3:
                                animalList.add(new Donkeys(name, date, skills));
                                break;

                            case 4:
                                System.out.println("Введите подвид животного: ");
                                nameClass = iscanner.next();
                                animalList.add(new OtherPack(name, nameClass, date, skills));
                                break;
                        }

                    }else if (num1 == 3) {
                        System.out.println("Введите тип животного: ");
                        mainClass = iscanner.next();

                        System.out.println("Введите подвид животного: ");
                        nameClass = iscanner.next();

                        animalList.add(new OtherAnimal(name, mainClass, nameClass, date, skills));

                    }else if (num1 == 0) {
                        System.exit(0);
                    }

                    break;
                case 3:
                    int k = 0;

                    for (BaseAnimal unit : animalList) {
                        k++;
                        System.out.println(k + ". " + unit.getInfo());
                    }
                    System.out.println("Введите номер животного: ");
                    int pos = iscanner.nextInt();
                    System.out.println(animalList.get(pos-1).getInfo());

                    while (num4 != 0) {
                        System.out.println("1 - добавить скилл \n0 - сохранить");
                        num4 = iscanner.nextInt();

                        switch (num4) {
                            case 1:
                                System.out.println("Скилл: ");
                                ArrayList oldSkills = animalList.get(pos-1).getSkills();
                                String newSkill = iscanner.next();
                                oldSkills.add(newSkill);
                                animalList.get(pos-1).setSkills(oldSkills);
                                break;
                        }

                    }
                    break;

            }
        }

    }

}