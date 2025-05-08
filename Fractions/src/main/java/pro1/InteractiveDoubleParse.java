package pro1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteractiveDoubleParse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();

        while (true) {
            System.out.print("Zadej desetinné číslo (nebo 'vypis' pro zobrazení): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("vypis")) {
                System.out.println("Uložená čísla: " + numbers);
                continue;
            }

            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
                System.out.println("Zadal jsi číslo: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Zadal jsi neplatný řetězec: " + input);
            }
        }
    }
}