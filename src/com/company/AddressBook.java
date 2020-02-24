package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.Scanner;

/**
 * This class stores the address entries into an address book
 * The list of Address Entries can grow or shrink
 * @author JessicaAsuncion
 */
public class AddressBook {
    // Create instance of AddressEntry using ArrayList collection
    private static ArrayList<AddressEntry> addressEntryList = new ArrayList();

    /**
     * this method lists the address entries in the address book
     * the list is in alphabetical order by last name
     */
    public static void list()
    {
        Collections.sort(addressEntryList);

        // lists out each entry
        for (AddressEntry a : addressEntryList)
        {
            System.out.println(a.toString());
        }
    }

    /**
     * Adds an address entry to the addressbook
     * @param a
     */
    public static void addAddress(AddressEntry a)
    {
        // user set methods to set each item in an address entry
        a.setFirstName(Menu.prompt_FirstName());
        a.setLastName(Menu.prompt_LastName());
        a.setStreet(Menu.prompt_Street());
        a.setCity(Menu.prompt_City());
        a.setState(Menu.prompt_State());
        a.setZip(Menu.prompt_Zip());
        a.setPhone(Menu.prompt_Phone());
        a.setEmail(Menu.prompt_Email());

        // add it to the address book
        addressEntryList.add(a);

        System.out.println("New address entry added to address book.");
        System.out.println(a.getFirstName());
        System.out.println(a.getLastName());
        System.out.println(a.getStreet());
        System.out.println(a.getCity());
        System.out.println(a.getState());
        System.out.println(a.getZip());
        System.out.println(a.getPhone());
        System.out.println(a.getEmail());
    }

    /**
     * Specifically for readFromFile method
     * @param a
     */
    public static void add(AddressEntry a)
    {
        addressEntryList.add(a);
    }

    /**
     * remove a single entry from the address book by finding the last name or the beginning of it
     */
    public static void remove() throws IOException {
        // Prompt user for last name to remove
        Scanner inputLast = new Scanner(System.in);
        System.out.println("Enter in all or the beginning of the last name of the contact you wish to find: ");
        String startOf_lastName = inputLast.nextLine();
        // call find method to find contact of last name entered
        find(startOf_lastName);

        // prompt user for first name if more than one entry
        Scanner inputFirst = new Scanner(System.in);
        System.out.println("Enter in First Name you wish to remove:");
        String first = inputFirst.nextLine();

        // loop through array
        for(int i = 0; i < addressEntryList.size(); i++)
        {
            if(addressEntryList.get(i).getFirstName().startsWith(first))
            {
                // print out address entry if you find the last name
                System.out.println(addressEntryList.get(i));

                // prompt user to ask if it is the correct entry they want to remove
                Scanner inputOption = new Scanner(System.in);
                System.out.println("Hit 'y' to remove the following entry or 'n' to return to main menu: ");
                char option;
                option = inputOption.next().charAt(0);

                switch (option)
                {
                    case 'y':
                        System.out.println("You have successfully removed the " + addressEntryList.get(i).getFirstName() + " " +
                                addressEntryList.get(i).getLastName() + " contact.");
                        addressEntryList.remove(i);
                        break;
                    case 'n':
                        Menu.print_Menu();
                        break;
                    default:
                        System.out.println("Incorrect option. Please enter a valid option. ");
                }
            }
        }
    }

    /**
     * Load a file with address entries
     * Prompt the user for a file including the path
     * The method will set each entry in the file as an AddressEntry object
     * The number of entries in the file will be printed out
     * @param filename the name of file the user will read from
     */
    public static void readFromFile(String filename) throws IOException {
        // prompt the user for file name
        Scanner userInputFile = new Scanner(System.in);
        System.out.println("Enter in filename (don't forget the path): ");
        String input = userInputFile.next();

        // open file
        File file = new File(input);
        Scanner inputFile = new Scanner(file);

        // create counter to find the number of addresses in the address book
        int count = 0;

        String fName, lName, st, c, s, p, e;
        int z;

        // put address entries in file into an array
        while(inputFile.hasNext())
        {
            fName = inputFile.nextLine();
            lName = inputFile.nextLine();
            st = inputFile.nextLine();
            c = inputFile.nextLine();
            s = inputFile.nextLine();
            z = Integer.parseInt(inputFile.nextLine());
            p = inputFile.nextLine();
            e = inputFile.nextLine();

            AddressEntry entry = new AddressEntry (fName, lName, st, c, s, z, p, e);

            add(entry);
            count++;
        }
        inputFile.close();

        System.out.println("Number of addresses: " + count);
    }

    /**
     * Find the contact by entering the beginning part of the last name or the whole last name
     * more entries can be returned if they start with the same letters or have the same last name
     * @param startOf_lastName
     * @throws IOException
     */
    public static void find(String startOf_lastName) throws IOException {
        // create a counter for the number of entries found
        int count = 0;

        // loop through each entry in the array to find a matching last name
        for(int i = 0; i < addressEntryList.size(); i++)
        {
            if(addressEntryList.get(i).getLastName().startsWith(startOf_lastName))
            {
                // print out entry if it matches
                System.out.println(addressEntryList.get(i));
                // update the counter for each entry found
                count++;
            }
        }
        System.out.println("The following " + count + " entries were found in the address book with the word starting with " +
                startOf_lastName);
    }
}
// /Users/jessicamasterasuncion/Desktop/AddressInputFile.txt

