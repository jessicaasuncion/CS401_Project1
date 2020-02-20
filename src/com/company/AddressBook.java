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
    public static void list(){

        Collections.sort(addressEntryList);

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

        a.setFirstName(Menu.prompt_FirstName());
        a.setLastName(Menu.prompt_LastName());
        a.setStreet(Menu.prompt_Street());
        a.setCity(Menu.prompt_City());
        a.setState(Menu.prompt_State());
        a.setZip(Menu.prompt_Zip());
        a.setPhone(Menu.prompt_Phone());
        a.setEmail(Menu.prompt_Email());

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
     *
     */
    public void remove()
    {

    }

    /**
     *
     * @param filename the name of file the user will read from
     */
    public static void readFromFile(String filename) throws IOException {
        Scanner userInputFile = new Scanner(System.in);
        System.out.println("Enter in filename (don't forget the path): ");
        String input = userInputFile.next();

        File file = new File(input);
        Scanner inputFile = new Scanner(file);

        // FileReader fr = new FileReader(input);
        // BufferedReader BR = new BufferedReader(fr);

        int count = 0;

        String fName, lName, st, c, s, p, e;
        int z;

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
     *
     * @param startOf_lastName
     * @throws IOException
     */
    public static void find(String startOf_lastName) throws IOException {
        int count = 0;
        for(int i = 0; i < addressEntryList.size(); i++)
        {
            if(addressEntryList.get(i).getLastName().equals(startOf_lastName))
            {
                System.out.println(addressEntryList.toString());
                count++;
            }
            else
            {
                System.out.println("No entries found containing that word.");
            }
        }
        System.out.println("The following " + count + " entries were found in the address book with the word starting with " +
                startOf_lastName);
    }
}
// /Users/jessicamasterasuncion/Desktop/AddressInputFile.txt

