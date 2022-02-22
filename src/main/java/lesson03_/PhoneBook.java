package lesson03_;

import java.util.HashSet;

public class PhoneBook {
    private final HashSet<PhonebookEntry> phonebook;

    public PhoneBook() {
        this.phonebook = new HashSet<>(5);
    }

    public void add(String surname, long number) {
        boolean isSurnameInBook = false;

        for (PhonebookEntry pe : phonebook) {
            if (surname.equals(pe.getSurname())) {
                isSurnameInBook = true;
                pe.add(number);
                break;
            }
        }
        if (!isSurnameInBook) {
            phonebook.add(new PhonebookEntry(surname, number));
        }

    }

    public void get(String surname) {
        boolean isSurnameInBook = false;
        for (PhonebookEntry pe: phonebook
        ) {
            if (surname.equals(pe.getSurname())) {
                isSurnameInBook = true;
                System.out.println(pe);
                break;
            }
        }
        if (!isSurnameInBook) {
            System.out.println(surname + ": данная запись не обнаружена!");
        }
    }
}
