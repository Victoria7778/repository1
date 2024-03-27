import java.util.*;

public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        List<String> binary = new ArrayList<>();
        int N = 0;
        while (N < 1000 && scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            N++;

            for (String token : tokens) {
                try {
                    double number = strtodec(token);
                    numbers.add((int) number);
                } catch (NumberFormatException e) {
                    System.err.println("Error: " + token);
                }
            }
        }

        System.out.println("Printed num:");
        for (double number : numbers) {
            System.out.printf("%.0f%n", number);
        }
        System.out.println("Printed num:");
        for (double number : numbers) {
            System.out.printf(toBinary((int) number) + "\n");
            binary.add(toBinary((int) number));

        }
        bubbleSort(binary);

        System.out.println("Sorted bin num:");
        for (String value : binary) {
            System.out.println(value);
        }
        System.out.println("Average " + calculateAverage(numbers));
        System.out.println("Median " + calculateMedian(numbers));

    }

    private static String toBinary(int number) {
        StringBuilder binary = new StringBuilder();
        if (number >= Short.MAX_VALUE) {
            return "0111111111111111";
        } else if (number <= Short.MIN_VALUE) {
            return "1000000000000000";
        } else {
            boolean isNegative = number < 0;

            if (isNegative) {
                number = -number;
            }

            do {

                binary.insert(0, number % 2);

                number /= 2;
            } while (number > 0);

            while (binary.length() < 16) {
                binary.insert(0, '0');
            }

            if (isNegative) {
                binary = invert(binary);
                binary = addOne(binary);
            }

            return binary.toString();
        }
    }

    private static StringBuilder invert(StringBuilder binary) {
        StringBuilder inverted = new StringBuilder();
        for (char bit : binary.toString().toCharArray()) {
            inverted.append((bit == '0') ? '1' : '0');
        }
        return inverted;
    }

    private static StringBuilder addOne(StringBuilder binary) {
        StringBuilder result = new StringBuilder();
        boolean carry = true;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char bit = binary.charAt(i);
            if (bit == '0' && carry) {
                result.insert(0, '1');
                carry = false;
            } else if (bit == '1' && carry) {
                result.insert(0, '0');
            } else {
                result.insert(0, bit);
            }
        }
        return result;
    }

    private static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty())
            return 0;

        long sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.size();
    }

    private static double calculateMedian(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int middle = numbers.size() / 2;
        if (numbers.size() % 2 == 0) {
            return (numbers.get(middle - 1) + numbers.get(middle)) / 2.0;
        } else {
            return numbers.get(middle);
        }
    }

    private static int strtodec(String str) throws NumberFormatException {
        int result = 0;
        int index = 0;
        boolean isNegative = false;

        if (str.charAt(0) == '-') {
            isNegative = true;
            index = 1;
        }

        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                throw new NumberFormatException("Error: " + str);
            }
            int digit = c - '0';
            result = result * 10 + digit;
        }

        return isNegative ? -result : result;
    }

    private static void bubbleSort(List<String> array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) > 0) {
                    String temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }

    }
}
