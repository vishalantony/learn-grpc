package com.github.vantony.exercises;

import com.example.tutorial.AddressBookProtos;
import com.example.tutorial.AddressBookProtos.AddressBook;
import com.example.tutorial.AddressBookProtos.Person.PhoneType;
import com.google.protobuf.util.JsonFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class AddressBookMain {

    static final String FileName = "address_book_entries.bin";
    static final int ID_LIMIT = 100000;

    private static void createFileIfNotExists(String filename) throws IOException {
        File f = new File(filename);
        if (!f.exists()) {
            f.createNewFile();
            System.out.println("file created.");
        } else {
            System.out.println("file exists. Did not create file.");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        createFileIfNotExists(FileName);
        FileInputStream fin = new FileInputStream(FileName);
        AddressBook adb = AddressBook.parseFrom(fin);
        System.out.println("Address book entries:\n" + JsonFormat.printer().print(adb));
        fin.close();
        AddressBook.Builder adbBuilder = adb.toBuilder();
        System.out.println("What do you want to do?\n1: add person\n2: Remove person\n3: Nothing");
        int action = scn.nextInt();
        scn.nextLine();
        if (action == 1) {
            AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder();
            System.out.println("Enter name: ");
            String name = scn.nextLine();
            personBuilder.setName(name);
            System.out.println("Enter email: ");
            String email = scn.nextLine();
            personBuilder.setEmail(email);
            System.out.println("Enter Phone Numbers:\n");

            while (true) {
                System.out.println("Add phone number?\n1: yes\n2: no");
                AddressBookProtos.Person.PhoneNumber.Builder phoneBuilder =
                        AddressBookProtos.Person.PhoneNumber.newBuilder();
                int addPhone = scn.nextInt();
                if (addPhone == 1) {
                    System.out.println(String.format("Phone Type: \n1: %s\n2: %s\n3: %s\nEnter Phone Type: ",
                            PhoneType.HOME, PhoneType.WORK, PhoneType.MOBILE));
                    int phoneType = scn.nextInt();
                    PhoneType type = phoneType == 1 ? PhoneType.HOME :
                            (phoneType == 2 ? PhoneType.WORK : PhoneType.MOBILE);
                    phoneBuilder.setType(type);
                    scn.nextLine();
                    System.out.println("Enter phone number: ");
                    String phoneNumber = scn.nextLine();
                    phoneBuilder.setNumber(phoneNumber);
                    personBuilder.addPhones(phoneBuilder.build());
                } else {
                    scn.nextLine();
                    break;
                }
            }

            personBuilder.setId(new Random().nextInt(ID_LIMIT));
            adbBuilder.addPeople(personBuilder.build());
        } else if (action == 2) {
            System.out.println("Enter ID of person to be removed: ");
            int id = scn.nextInt();
            int index = -1;
            int i = 0;
            for (AddressBookProtos.Person p : adbBuilder.getPeopleList()) {
                if (p.getId() == id) {
                    index = i;
                    break;
                }
                i++;
            }

            if (index != -1) {
                adbBuilder.removePeople(index);
            }
        } else if (action == 3) {
            System.out.println("Exiting...");
        } else {
            System.out.println("ERROR: Unknown action!");
        }

        FileOutputStream fout = new FileOutputStream(FileName);
        adbBuilder.build().writeTo(fout);
        fout.close();
    }
}
