package lesson03_;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //  (1е задание)
        System.out.println("1 задание");
        System.out.println();
        ArrayList<String> words = new ArrayList<>(20);              // инициализируем массив слов
        words.add("raise"); words.add("risen"); words.add("arose"); words.add("snare"); words.add("aisle"); words.add("tears");
        words.add("aisle"); words.add("noise"); words.add("tears"); words.add("aside"); words.add("aside"); words.add("store");
        words.add("aisle"); words.add("stern"); words.add("arose"); words.add("snore"); words.add("store"); words.add("onset");
        words.add("alien"); words.add("aside");
        HashSet<WordQuantity> wordQuantities = wordsWithQuantity(words);        // создаем множество слов с количествами вхождений
        for (WordQuantity wq : wordQuantities) {                                // выводим итог в консоль
            System.out.println(wq.toString());
        }

        // (2е задание)
        System.out.println();
        System.out.println("2 задание");
        System.out.println();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Переверзев", 89654123654L);
        phoneBook.add("Круглов", 89145632587L);
        phoneBook.add("Иванов", 89874563214L);
        phoneBook.add("Петров", 89112223366L);
        phoneBook.add("Сидоров", 89128521478L);
        phoneBook.add("Сидоров", 89258745698L);
        phoneBook.add("Петров", 89056896375L);
        phoneBook.add("Круглов", 89512486357L);
        phoneBook.add("Петров", 89014785236L);
        phoneBook.add("Переверзев", 89112589632L);

        phoneBook.get("Петров");
        phoneBook.get("Круглов");
        phoneBook.get("Цветков");
    }


    // (1е задание)
    public static HashSet<WordQuantity> wordsWithQuantity(ArrayList<String> words) {
        HashSet<WordQuantity> hswq = new HashSet<>(10);          // создаем множество слов с количествами
        for (String word : words) {                                         // идем по массиву слов
            boolean wordIsInHashSet = false;
            for (WordQuantity wq : hswq) {                                  // если слово уже нашлось в множестве
                if (wq.getWord().equals(word)) {
                    wq.setQuantity(wq.getQuantity() + 1);                   // увеличиваем его количество на 1
                    wordIsInHashSet = true;
                    break;
                }
            }
            if (!wordIsInHashSet) {                                          // если слова в множестве нет, добавляем его
                hswq.add(new WordQuantity(word));
            }
        }
        return hswq;
    }

}
