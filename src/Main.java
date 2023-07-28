import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> rim = List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C");
        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        String[] ab = input.split(" ");
        if (ab.length > 3) {
            throw new Exception("//т.к. формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }
        if (ab.length < 3 || !"+-*/".contains(ab[1])) {
            throw new Exception("//т.к. строка не является математической операцией");
        }
        if (ab[0].matches("\\d+") && Integer.parseInt(ab[0]) > 0 && Integer.parseInt(ab[0]) <= 10) {
            if (ab[2].matches("\\d+") && Integer.parseInt(ab[2]) > 0 && Integer.parseInt(ab[2]) <= 10) {
                int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[2]);
                switch (ab[1]) {
                    case "+" -> System.out.println(a + b);
                    case "-" -> System.out.println(a - b);
                    case "*" -> System.out.println(a * b);
                    case "/" -> System.out.println(a / b);
                }
            } else {
                throw new Exception("//т.к. используются одновременно разные системы счисления");
            }
        } else if (ab[0].length() <= 4 && ab[0].length() > 0 && rim.indexOf(ab[0]) > 0) {
            if (!ab[2].matches("\\d+") && ab[2].length() <= 4 && ab[2].length() > 0 && rim.indexOf(ab[2]) > 0) {
                int a = rim.indexOf(ab[0]), b = rim.indexOf(ab[2]);
                int c = switch (ab[1]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                if (c == 0) {
                    throw new Exception("//т.к. в римской системе нет числа '0'");
                }
                if (c < 0) {
                    throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                }
                System.out.println(rim.get(c));
            } else {
                throw new Exception("//т.к. используются одновременно разные системы счисления");
            }
        }
    }
}