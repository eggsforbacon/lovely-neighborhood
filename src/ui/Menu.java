package ui;

import model.Shop;

import java.util.Scanner;

public class Menu {
    private final int REGISTER_PERSON = 1;
    private final int ATTEMPTED_PEOPLE = 2;
    private final int EXIT_COND = 0;
    private boolean exit = false;
    private Shop shop = new Shop();

    public void startProgram() {

        do {
            Scanner in = new Scanner(System.in);
            mainMenu();
            selection(in.nextInt(), in);
        } while (!exit);
    }

    private void mainMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("----------------------BIENVENIDO A 'MI BARRIO TE QUIERE'------------------------");
        System.out.println("-REGISTRAR UNA PERSONA                                                      [1]-");
        System.out.println("-INGRESAR UNA PERSONA                                                       [2]-");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-[0]                                                                      SALIR-");
        System.out.print("*(Ingrese una opción):");
    }

    private void selection(int answer, Scanner in) {
        switch (answer) {
            case REGISTER_PERSON:
                registerPerson(in);
                break;
            case ATTEMPTED_PEOPLE:
                System.out.println(2);
                break;
            case EXIT_COND:
                exit = true;
                break;
            default:
                break;
        }
    }

    private void registerPerson(Scanner in) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-Ingrese el tipo de documento de acuerdo a la siguiente lista:                 -");
        String newType = in.nextLine();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-Ingrese el numero de documento:                                               -");
        String newId = in.nextLine();
        shop.createUser(newType, newId);
    }
}
