package pro1;

import java.util.Scanner;

public class InteractiveFractionParse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Zadej operaci se zlomky (např. '1/2 + 1/3') nebo 'konec': ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("konec")) {
                System.out.println("Ukončuji program.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Zadaný řetězec je neplatný, zadejte prosím znovu.");
                continue;
            }

            try {
                Fraction f1 = Fraction.parse(parts[0]);
                Fraction f2 = Fraction.parse(parts[2]);
                Fraction result;

                switch (parts[1]) {
                    case "+":
                        result = f1.add(f2);
                        break;
                    case "-":
                        result = f1.subtract(f2);
                        break;
                    case "*":
                        result = f1.multiply(f2);
                        break;
                    default:
                        System.out.println("Neznámý operátor: " + parts[1]);
                        continue;
                }

                System.out.println("Výsledný zlomek: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Zadaný řetězec je neplatný, zadejte prosím znovu.");
            }
        }
    }
}