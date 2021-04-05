package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Shop {
    private int attempts;
    private final ArrayList<Person> peopleInTheShop;
    private final ArrayList<String> validTypes = new ArrayList<>(Arrays.asList("TI","CC","PP","CE"));
    private final int currentDay;

    public Shop() {
        attempts = 0;
        peopleInTheShop = new ArrayList<>();
        currentDay = LocalDateTime.now().getDayOfMonth();
    }

    public void createUser(String newType, String newId) throws IncorrectTypeException, InvalidForTheDayException {
        attempts++;
        boolean newTypeNotValid = validTypes.contains(newType);
        boolean newIdNotValid = checkIfValid(newId);
        if (newTypeNotValid) throw new IncorrectTypeException("El tipo de documento ingresado no es valido.");
        else if (newType.equals(validTypes.get(0))) throw new IncorrectTypeException("No se permite el ingreso de menores de edad por el momento");
        else if (newIdNotValid) throw new InvalidForTheDayException("EL numero de cedula no es permitido el día de hoy.");
        else {
            peopleInTheShop.add(new Person(newType, newId));
        }
    }

    private boolean checkIfValid(String newId) {
        boolean dayIsEven = currentDay % 2 == 0;
        boolean secondToLastEven = newId.charAt(newId.length() - 2) % 2 == 0;
        if (dayIsEven && !secondToLastEven) return true;
        else return !dayIsEven && secondToLastEven;
    }

    public ArrayList<Person> getPeopleInTheShop() {
        return peopleInTheShop;
    }

    public int getAttempts() {
        return attempts;
    }

    public ArrayList<String> getValidTypes() {
        return validTypes;
    }
}
