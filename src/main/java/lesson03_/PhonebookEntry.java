package lesson03_;

import java.util.LinkedList;

public class PhonebookEntry {
    private final String surname;
    private final LinkedList<Long> numbers;

    public PhonebookEntry(String surname, long number) {
        this.surname = surname;
        numbers = new LinkedList<>();
        numbers.add(number);
    }

    public String getSurname() {
        return surname;
    }

    public void add(long number) {
        numbers.add(number);
    }

    @Override
    public String toString() {
        return surname.concat(" ").concat(numbers.toString());
    }
}
