package Refrensi;
/**
 * Refrensi dari https://www.petanikode.com/java-generic/
 */
public class generic {

    public static void main(String[] args) {
        
        // Membuat objek Pair dengan tipe Integer dan String
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        pair1.displayPair(); // Output: First: 1, Second: One

        // Membuat objek Pair dengan tipe Double dan Character
        Pair<Double, Character> pair2 = new Pair<>(3.14, 'A');
        pair2.displayPair(); // Output: First: 3.14, Second: A

    }

}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void displayPair() {
        System.out.println("First: " + first.toString() + ", Second: " + second.toString());
    }
}

