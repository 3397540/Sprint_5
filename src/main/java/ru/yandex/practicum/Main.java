package ru.yandex.practicum;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Значения enum: " + Arrays.toString(Animal.values()));

        String[] array = {"DOG Жучка", "DOG Внучка", "DOG Бабка", "CAT Муська", "HORSE Жаба", "FROG Люська"};

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));

        System.out.println("Значения списка: " + list);

        AnimalFarm animalFarm = new AnimalFarm(list);

        animalFarm.addAnimal(animalFarm.getAnimalByName("COW"), "Бурёнка");
        animalFarm.addAnimal(animalFarm.getAnimalByName("COW"));
        animalFarm.addAnimal("Жучка");

        System.out.println("Список уникальных животных: " + animalFarm.uniqueNames());

        System.out.println("Количество животных на ферме: " + animalFarm.countedAnimals());

        System.out.println("Все животные на ферме: " + animalFarm.getFarmAnimals());

        System.out.println("Перечень животных: \n" + animalFarm);

        animalFarm.isSpacePresented("DOG");




    }
}
