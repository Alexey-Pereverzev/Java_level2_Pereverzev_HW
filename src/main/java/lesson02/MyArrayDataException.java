package lesson02;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        System.err.println("Неверные данные в ячейке [" + (i+1) + "," + (j+1) + "]");
        this.printStackTrace();
    }
}
