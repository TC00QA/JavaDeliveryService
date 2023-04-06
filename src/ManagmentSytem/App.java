package ManagmentSytem;

import Database.DatabaseUtils;
import Enums.CrudChoices;
import Enums.MenuChoices;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class App {

    private LinkedHashMap<Integer, CrudChoices> crudChoices = new LinkedHashMap<Integer, CrudChoices>();
    private LinkedHashMap<Integer, MenuChoices> menuChoices = new LinkedHashMap<Integer, MenuChoices>();
    private final Scanner userIn = new Scanner(System.in);

    public App(){
        initHashmaps();
    }

    public void initHashmaps(){
        // Crud for all tables
        crudChoices.put(1, CrudChoices.CREATE);
        crudChoices.put(2, CrudChoices.READ);
        crudChoices.put(3, CrudChoices.UPDATE);
        crudChoices.put(4, CrudChoices.DELETE);
        crudChoices.put(5, CrudChoices.BACK);

        // Init options to user
        menuChoices.put(1, MenuChoices.CUSTOMER);
        menuChoices.put(2, MenuChoices.DRIVER);
        menuChoices.put(3, MenuChoices.DELIVERY);
        menuChoices.put(5, MenuChoices.ORDER);
        menuChoices.put(6, MenuChoices.ITEM);
        menuChoices.put(7, MenuChoices.QUIT);
    }
    public void begin() throws SQLException {

        MenuChoices currentChoice;
        CrudChoices crudOperation;



        boolean running = true;

        do{

            currentChoice = getUserMenuChoice();

            switch (currentChoice){
                case ITEM:
                    crudOperation = getCrudMenuChoice(currentChoice);
                    break;
                case QUIT:
                    System.out.println("Quitting");
                    running = false;
                    break;
            }

            if(currentChoice == MenuChoices.QUIT){
                break;
            }


        } while (running);

        closeScanner();
    }
    public MenuChoices getUserMenuChoice(){

        String Output;

        boolean validatedInput = false;

        while (!validatedInput){

            for (int Choice: menuChoices.keySet()){
                System.out.println(Choice + ": " + menuChoices.get(Choice).toString());
            }

            System.out.println("Enter Choice: ");

            Output = userIn.nextLine();

            if (menuChoices.containsKey(Integer.parseInt(Output))){
                return menuChoices.get(Integer.parseInt(Output));
            }

            System.out.println("Invalid Input \n");

        }
        return null;
    }

    public CrudChoices getCrudMenuChoice(MenuChoices selectedChoice){

        String Output;

        boolean validatedInput = false;

        System.out.println();

        while (!validatedInput){

            System.out.println("Select system: " + selectedChoice.toString());

            for (int Choice: crudChoices.keySet()){
                System.out.println(Choice + ": " + crudChoices.get(Choice).toString());
            }

            System.out.println("Enter Choice: ");

            Output = userIn.nextLine();

            if (crudChoices.containsKey(Integer.parseInt(Output))){
                return crudChoices.get(Integer.parseInt(Output));
            }

            System.out.println("Invalid Input");

        }
        return null;
    }

    public void closeScanner(){
        userIn.close();
    }

}
