package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AnimalFarm {

    private final ArrayList<String> farmAnimals;

    public AnimalFarm (ArrayList<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    //Возвращаем список животных с именами
    public ArrayList<String> getFarmAnimals () {
        return farmAnimals;
    }

    //Определяем есть ли животное в энаме
    private boolean isAnimalDefined(String string)  {
        boolean result = false;
        for (Animal animal : Animal.values()) {
            if (string.startsWith(animal.name())) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;
    }

    //Ищем пробел в записи списка
    public boolean isSpacePresented(String string) throws InvalidInputException {
        boolean result = false;
        if (string.contains(" ")) {
            result = true;
        } else {
            throw new InvalidInputException("Please correct string " + string + ". Incorrect input data.");
        }
        return result;
    }

    //Выделяем тип животного из записи списка
    private String getAnimal(String string) throws InvalidInputException {
        String result = "";
        if (isSpacePresented(string)) {
            String[] animals = string.split(" ");
            result = animals[0];
        }
        return result;
    }

    //Создаём множество уникальных имен
    HashSet<String> uniqueNames () throws InvalidInputException {
        HashSet<String> uniqueAnimals = new HashSet<>();

        for (String farmAnimal : farmAnimals) {
            uniqueAnimals.add(getAnimal(farmAnimal));
        }
        return uniqueAnimals;
    }

    //Считаем количество животных одного типа в списке
    private Integer counter (String animal) throws InvalidInputException {
        Integer result = 0;

        for (String farmAnimal : farmAnimals) {
            if (getAnimal(animal).equals(getAnimal(farmAnimal))) {
                result++;
            }
        }
        return result;
    }

    //Создаем хэш-таблицу с количеством животных на ферме
    HashMap<String, Integer> countedAnimals () throws InvalidInputException {
        HashMap<String, Integer> animalsCounter = new HashMap<>();

        for (String farmAnimal : farmAnimals) {

            if (isAnimalDefined(farmAnimal)) {

                animalsCounter.put(getAnimal(farmAnimal), counter(farmAnimal));
            } else {
                throw new InvalidInputException("Please correct string " + farmAnimal + ". Incorrect input data.");
            }

        }

        return animalsCounter;
    }
    //Получаем перечисление энам по строке
    public Animal getAnimalByName(String animalName) {
        return Animal.valueOf(animalName);
    }

    //Добавление животного по типу и имени
    public void addAnimal (Animal animal, String name) {
        StringBuilder input = new StringBuilder(animal.name()).append(" ").append(name);

        farmAnimals.add(input.toString());
    }

    //Добавление животного по типу
    public void addAnimal (Animal animal) {
        StringBuilder input = new StringBuilder(animal.name()).append(" ").append("N");

        farmAnimals.add(input.toString());
    }

    //Добавление животного по имени
    public void addAnimal (String name) {
        StringBuilder input = new StringBuilder("NOT_DEFINED").append(" ").append(name);

        farmAnimals.add(input.toString());
    }

    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder();
        String output;
        for (String farmAnimal : farmAnimals) {
            sb.append(farmAnimal.replace(" ", ", ")).append("\n");
        }
        output = sb.toString();
        return output;
    }
}
