package lesson02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите построчно размер массива: ");   // инициализация массива
        int lines = 0;
        int columns = 0;
        boolean correct_lines = true;
        while (lines <=0) {                                     // проверяем, что вводится целое положительное число
            System.out.print("Количество строк (число большее нуля): ");
            if (scanner.hasNextInt()) {
                lines = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не целое число");
                correct_lines = false;
                break;
            }
        }

        while ((columns <= 0)&&(correct_lines)) {               // если ввод строк успешен проверяем ввод столбцов
            System.out.print("Количество столбцов (число большее нуля): ");
            if (scanner.hasNextInt()) {
                columns = scanner.nextInt();
            } else {
                System.out.println("Вы ввели не целое число");
                break;
            }
        }

        if ((lines != 4) || (columns != 4)) {
            scanner.close();
            throw new MyArraySizeException();
        }

        String[][] array = new String[lines][columns];
        scanner.nextLine();

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Введите значение массива [" + (i+1) + "," + (j+1) + "]: ");
                array[i][j] = scanner.nextLine();
            }

        }
        try {
            int sum = sumArray(array);
            System.out.println("Сумма равна: " + sum);
        } catch (NumberFormatException e) {
            System.err.println("Некорректные данные в массиве, вывод суммы невозможен");
        }
        scanner.close();

    }

    public static int sumArray(String[][] array) throws NumberFormatException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }
}
