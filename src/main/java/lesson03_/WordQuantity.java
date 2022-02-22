package lesson03_;

public class WordQuantity {                  // тип данных, который хранит слово и количество вхождений слова в массив
    private final String word;
    private int quantity;

    public WordQuantity(String word) {      // когда слово встретилось в первый раз, количество инициализируется как 1
        this.word = word;
        this.quantity = 1;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWord() {
        return word;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return word + ' ' + quantity;
    }
}

