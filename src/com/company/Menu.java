package com.company;
import java.util.Scanner;
import java.io.*;

/**
 * The menu class displays options to the user: Loading, Addition, Removal, Find, Listing, Quit
 * @author JessicaAsuncion
 */
public class Menu {
    /**
     * The menu prompts the user for which they would like to do: load, addition, removal, find, listing, or quit
     * by entering a letter
     */
    public static void print_Menu() throws IOException {
        AddressEntry a = new AddressEntry();

        // show user the menu and ask what they would like to do
        char select;
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************\n");
        System.out.println("PLease enter in your menu selection\n");
        System.out.println("a) Loading From File\n");
        System.out.println("b) Addition\n");
        System.out.println("c) Removal\n");
        System.out.println("d) Find\n");
        System.out.println("e) Listing\n");
        System.out.println("f) Quit\n");
        System.out.println("*****************************\n");

        select = sc.next().charAt(0);

        /*
        * Switch cases for the menu; what happens if user selects a certain option
         */
        switch(select)
        {
            // Load entries from file
            case 'a':
                //readFromFile("AddressInputDataFile.txt");
                AddressBook.readFromFile("AddressInputFile.txt");
                break;

            // Add contact
            case 'b':
                System.out.println("Add a new address entry.\n");
                AddressBook.addAddress(a);
                break;

            // Delete contact by last name
            case 'c':
                AddressBook.remove();
                break;

            // Find contact from file
            case 'd':
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter in all or the beginning of the last name of the contact you wish to find: ");
                String startOf_lastName = scan.nextLine();
                AddressBook.find(startOf_lastName);
                break;

            // List files by last name
            case 'e':
                AddressBook.list();
                System.out.println("List of entries.");
                break;

            // Quit with Goodbye! message
            case 'f':
                System.out.println("Goodbye!");
                System.exit(0);
                break;

            // Message if user does not enter a correct selection a, b, c, d, e, or f
            default:
                System.out.println("Please enter a correct choice:");
                break;
        }
        // Call menu again until user chooses f (quits)
        print_Menu();
    }

    /**
     * prompt_FirstName  generates a standard output prompt for the First Name to be entered
     */
    public static String prompt_FirstName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        String firstName = input.next();

        return firstName;
    }
    /**
     * prompt_LastName  generates a standard output prompt for the Last Name to be entered
     */
    public static String prompt_LastName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Last Name: ");
        String lastName = input.next();

        return lastName;
    }
    /**
     * prompt_Street  generates a standard output prompt for the street to be entered
     */
    public static String prompt_Street() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Street: ");
        String street = input.next();

        return street;
    }
    /**
     * prompt_Street  generates a standard output prompt for the city to be entered
     */
    public static String prompt_City() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter City: ");
        String city = input.next();

        return city;
    }
    /**
     * prompt_Street  generates a standard output prompt for the state to be entered
     */
    public static String prompt_State() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter State: ");
        String state = input.next();

        return state;
    }
    /**
     * prompt_Street  generates a standard output prompt for the zip to be entered
     */
    public static int prompt_Zip() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Zip: ");
        int zip = input.nextInt();

        return zip;
    }
    /**
     * prompt_Street  generates a standard output prompt for the telephone to be entered
     */
    public static String prompt_Phone() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Phone: ");
        String phone = input.next();

        return phone;
    }
    /**
     * prompt_Street  generates a standard output prompt for the email to be entered
     */
    public static String prompt_Email() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = input.next();

        return email;
    }

}
