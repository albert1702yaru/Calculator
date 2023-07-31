import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> arabic = List.of("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
            "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
            "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
            "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII",
            "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI",
            "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
            "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
            "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
            "XCVII", "XCVIII", "XCIX", "C");

    private static String toggle(int a, int b, String sign, boolean s) throws Exception {
        int c = switch (sign) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
        if (s && c == 0) {
            throw new Exception("throws Exception //т.к. в римской системе нет числа '0'");
        }
        if (s && c < 0) {
            throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
        return s ? arabic.get(c) : Integer.toString(c);
    }

    private static String symbol(String s1, String s2, String s3) throws Exception {
        if (s1.matches("\\d+") && s2.matches("\\d+")) {
            return toggle(Integer.parseInt(s1), Integer.parseInt(s2), s3, false);
        } else if (arabic.contains(s1) && arabic.contains(s2)) {
            return toggle(arabic.indexOf(s1), arabic.indexOf(s2), s3, true);
        } else {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        }
    }

    private static String does(String[] input) throws Exception {
        if (input.length > 3) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }
        if (input.length < 3 || !"+-*/".contains(input[1])) {
            throw new Exception("throws Exception //т.к. строка не является математической операцией");
        }
        return symbol(input[0].toUpperCase(), input[2].toUpperCase(), input[1]);
    }

    public static String calc(String input) throws Exception {
        String[] expression = input.split(" ");
        return does(expression);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println(calc(in.nextLine()));
        in.close();
    }
}