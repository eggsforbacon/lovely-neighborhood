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
        boolean newTypeValid = validTypes.contains(newType);
        boolean newIdValid = checkIfValid(newId);
        if (!newTypeValid) throw new IncorrectTypeException("-------------------El tipo de documento ingresado no es valido------------------");
        else if (newType.equals(validTypes.get(0)))
            throw new IncorrectTypeException("-----------No se permite el ingreso de menores de edad por el momento-----------");
        else if (!newIdValid) throw new InvalidForTheDayException("----------------El numero de cedula no es permitido el dia de hoy---------------");
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

    public int getAttempts() {
        return attempts;
    }

    public String getValidTypes() {
        StringBuilder msg = new StringBuilder();
        for (String s : validTypes) {
            msg.append("-").append(s).append("\n");
        }
        msg.append("*                                                                              *");
        return msg.toString();
    }

    public int getPeople() {
        return peopleInTheShop.size();
    }
}
