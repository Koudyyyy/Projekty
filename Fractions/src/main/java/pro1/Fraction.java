package pro1;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Jmenovatel nemůže být nula!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Fraction add(Fraction other) {
        int commonDenominator = denominator * other.denominator;
        int newNumerator = (numerator * other.denominator) + (other.numerator * denominator);
        return new Fraction(newNumerator, commonDenominator);
    }

    public Fraction subtract(Fraction other) {
        int commonDenominator = denominator * other.denominator;
        int newNumerator = (numerator * other.denominator) - (other.numerator * denominator);
        return new Fraction(newNumerator, commonDenominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static Fraction parse(String input) {
        input = input.trim();

        if (input.matches(".*\\d+%.*")) {
            String[] parts = input.split("\\+");
            Fraction result = new Fraction(0, 1);

            for (String part : parts) {
                part = part.trim();
                if (part.endsWith("%")) {
                    int percentage = Integer.parseInt(part.replace("%", "").trim());
                    result = result.add(new Fraction(percentage, 100)); // Převede procenta na zlomek
                } else {
                    result = result.add(parse(part));
                }
            }
            return result;
        }

        if (input.contains("+") || input.contains("-")) {
            String[] parts = input.split("(?=[+-])");
            Fraction result = parse(parts[0].trim());

            for (int i = 1; i < parts.length; i++) {
                String part = parts[i].trim();
                if (part.startsWith("+")) {
                    result = result.add(parse(part.substring(1).trim()));
                } else if (part.startsWith("-")) {
                    result = result.subtract(parse(part.substring(1).trim()));
                }
            }
            return result;
        }

        if (!input.matches("-?\\d+/\\d+")) {
            throw new IllegalArgumentException("Neplatný formát zlomku: " + input);
        }

        String[] parts = input.split("/");
        int numerator = Integer.parseInt(parts[0].trim());
        int denominator = Integer.parseInt(parts[1].trim());

        return new Fraction(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}