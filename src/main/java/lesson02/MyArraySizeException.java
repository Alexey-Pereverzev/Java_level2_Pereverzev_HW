package lesson02;

public class MyArraySizeException extends IndexOutOfBoundsException{
    public MyArraySizeException() {
        System.out.println("Некорректный размер массива! Массив должен иметь размер 4х4");
    }
}
