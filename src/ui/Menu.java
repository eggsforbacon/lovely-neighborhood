package ui;

import exceptions.IncorrectTypeException;
import exceptions.InvalidForTheDayException;
import model.Shop;

import java.util.Scanner;

public class Menu {
    private final int REGISTER_PERSON = 1;
    private final int ATTEMPTED_PEOPLE = 2;
    private final int EXIT_COND = 0;
    private boolean exit = false;
    private final Shop shop = new Shop();

    public void startProgram() {

        do {
            Scanner in = new Scanner(System.in);
            mainMenu();
            int answer = in.nextInt();
            in.nextLine();
            selection(answer, in);
        } while (!exit);
    }

    private void mainMenu() {
        clear();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("----------------------BIENVENIDO A 'MI BARRIO TE QUIERE'------------------------");
        System.out.println("-INGRESAR UNA PERSONA                                                       [" + REGISTER_PERSON + "]-");
        System.out.println("-REVISAR INTENTOS DE ENTRADA                                                [" + ATTEMPTED_PEOPLE + "]-");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-[" + EXIT_COND + "]                                                                      SALIR-");
        System.out.print("*(Ingrese una opcion): ");
    }

    private void selection(int answer, Scanner in) {
        switch (answer) {
            case REGISTER_PERSON:
                registerPerson(in);
                break;
            case ATTEMPTED_PEOPLE:
                checkAttempts(in);
                break;
            case EXIT_COND:
                exit = true;
                break;
            default:
                break;
        }
    }

    private void registerPerson(Scanner in) {
        clear();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-Ingrese el tipo de documento de acuerdo a la siguiente lista:                 -");
        System.out.println(shop.getValidTypes());
        String newType = in.nextLine().trim();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-Ingrese el numero de documento:                                               -");
        String newId = in.nextLine().trim();
        try {
            shop.createUser(newType, newId);
            System.out.println("----------------------El cliente fue ingresado exitosamente!--------------------");
        } catch (IncorrectTypeException | InvalidForTheDayException typeE) {
            System.out.println(typeE.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("-(Presione enter para continuar)");
            in.nextLine();
        }
    }

    private void checkAttempts(Scanner in) {
        clear();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--Intentos: " + shop.getAttempts());
        System.out.println("--Personas admitidas: " + shop.getPeople());
        System.out.println("-(Presione enter para regresar)                                                -");
        in.nextLine();
    }

    private static void clear() {
        try {
            final String OS = System.getProperty("os.name");
            if (OS.contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else Runtime.getRuntime().exec("clear");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
