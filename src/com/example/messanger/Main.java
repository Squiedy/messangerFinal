package com.example.messanger;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming...");
        showInitialOption();

    }

    private static void showInitialOption() {

        System.out.println("""
                Please select one...
                \t1.Manage Contacts
                \t2.Manage Messages
                \t3.Quit""");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> manageContacts();
            case 2 -> manageMessages();
            default -> {
            }
        }
    }

    private static void manageMessages() {
        System.out.println("""
                Please select one...
                \t1.Show all messages
                \t2.Send a new message
                \t3.Go back""");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> showAllMessages();
            case 2 -> sendNewMessage();
            default -> {
                showInitialOption();
            }
        }
    }

    private static void sendNewMessage() {
        System.out.println("Who are you going to send a message : ");
        String name = scanner.next();
        if (name.equals("")) {
            sendNewMessage();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact...");
                manageMessages();
            } else {
                System.out.println("What are you going to say?");
                String text = scanner.next();
                if (text.equals("")) {
                    System.out.println("Please enter some message and try again...");
                    sendNewMessage();
                } else {
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c : contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                    System.out.println("Message send successfully...");

                }

            }
        }
        manageMessages();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("********************");
            }
        } else {
            System.out.println("You don't have any message...");
        }
        manageMessages();
    }

    private static void manageContacts() {
        System.out.println("""
                please select one...
                \t1.Show all contacts
                \t2.Add a new contact
                \t3.Search for a contact
                \t4.Delete a contact
                \t5.Go back""");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> showAllContacts();
            case 2 -> addNewContact();
            case 3 -> searchForContact();
            case 4 -> deleteContact();
            default -> {
                showInitialOption();
            }
        }

    }

    private static void deleteContact() {
        System.out.println("Please enter contact name : ");
        String name = scanner.next();
        if (name.equals("")) {
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    contacts.remove(c);
                    doesExist = true;
                    break;
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact...");
            }
        }
        manageContacts();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name : ");
        String name = scanner.next();
        if (name.equals("")) {
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    c.getDetails();
                    doesExist = true;
                    break;
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact...");
            }
        }
        manageContacts();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name : ");
        String name = scanner.next();
        System.out.println("Please Enter the contact's number : ");
        String number = scanner.next();
        System.out.println("Please Enter the contact's email : ");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter the all details...");
            addNewContact();
        } else {
            boolean doesExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    doesExist = true;
                    break;
                }
            }
            if (doesExist) {
                System.out.println("There is a contact named " + name + " saved on this device...");
            } else {
                Contact contact = new Contact(name, number, email);
                contacts.add(contact);
                System.out.println("Contact added successfully...");
            }
        }
        manageContacts();
    }

    private static void showAllContacts() {
        if (contacts.size() > 0) {
            for (Contact c : contacts) {
                c.getDetails();
            }
        } else {
            System.out.println("You don't have any contacts...");
        }
        manageContacts();
    }
}