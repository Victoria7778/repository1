public class main2 { public static void main(String[] args) { Scanner scanner = new Scanner(System.in); List numbers = new ArrayList<>(); List binary = new ArrayList<>(); int N = 0; while (N < 1000 && scanner.hasNext()) { String line = scanner.nextLine(); String[] tokens = line.split("\s+"); N++;

        for (String token : tokens) {
            try {
                double number = Double.parseDouble(token);
                numbers.add((int) number);
            } catch (NumberFormatException e) {
                System.err.println("Неправильний формат числа: " + token);
            }
        }
    }

    System.out.println("Введені числа:");
    for (double number : numbers) {
        System.out.printf("%.0f%n", number);
    }
    System.out.println("Введені числа:");
    for (double number : numbers) {
        System.out.printf(toBinary((int) number) + "\n");
        binary.add(toBinary((int) number));


    }
    bubbleSort(binary);

    System.out.println("Відсортовані числа у двійковому форматі:");
    for (String value : binary) {
        System.out.println(value);
    }
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