# repository1
Rakhmanova Viktoria
import java.util.*;

public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        int N=0;
        while (N<1000 && scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");

        for (String token : tokens) {
            try {
                double number = Double.parseDouble(token);
                numbers.add((int) number);
            } catch (NumberFormatException e) {
                System.err.println("Неправильний формат числа: " + token);
            }
        }}

        System.out.println("Введені числа:");
        for (double number : numbers) {
            System.out.printf("%.0f%n", number);
        }
        System.out.println("Введені числа:");
        for (double number : numbers) {
            System.out.printf(toBinary((int) number)+"\n");
        }
    }}