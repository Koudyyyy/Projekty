package pro1;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File inputDir = new File("Data/input");
        File outputDir = new File("Data/output");

        File[] inputFiles = inputDir.listFiles();
        if (inputFiles == null || inputFiles.length == 0) {
            System.err.println("Nebyly nalezeny žádné soubory v 'Data/input'.");
            return;
        }

        for (File inputFile : inputFiles) {
            if (inputFile.isFile()) {
                System.out.println("\nNačítám soubor: " + inputFile.getName());

                List<ExamRecord> records = readInputFile(inputFile.toPath());
                if (records != null) {
                    File outputFile = new File(outputDir, inputFile.getName());
                    exportToCSV(outputFile, records);
                }
            }
        }

        System.out.println("\nVšechny soubory byly úspěšně zpracovány!");
    }

    public static List<ExamRecord> readInputFile(Path fileName) {
        List<String> lines;
        try {
            lines = Files.readAllLines(fileName);
        } catch (IOException e) {
            System.err.println("Chyba při čtení souboru: " + e.getMessage());
            return null;
        }

        List<ExamRecord> records = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split("[=:;]");
            if (split.length != 2) {
                System.err.println("Chybný řádek (přeskočeno): " + line);
                continue;
            }

            String name = split[0].trim();
            String score = split[1].trim();

            try {
                records.add(new ExamRecord(name, parsePercentageOrFraction(score)));
            } catch (IllegalArgumentException e) {
                System.err.println("Neplatný formát (přeskočeno): " + score);
            }
        }
        return records;
    }

    public static Fraction parsePercentageOrFraction(String input) {
        input = input.trim();

        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            Fraction sum = new Fraction(0, 1);
            for (String part : parts) {
                sum = sum.add(parseSingleValue(part.trim()));
            }
            return sum;
        }

        return parseSingleValue(input);
    }

    public static Fraction parseSingleValue(String input) {
        if (input.endsWith("%")) {
            int percentage = Integer.parseInt(input.replace("%", "").trim());
            return new Fraction(percentage, 100);
        }

        if (input.matches("-?\\d+/\\d+")) {
            String[] parts = input.split("/");
            int numerator = Integer.parseInt(parts[0].trim());
            int denominator = Integer.parseInt(parts[1].trim());
            return new Fraction(numerator, denominator);
        }

        throw new IllegalArgumentException("Neplatný formát: " + input);
    }

    public static void exportToCSV(File outputFile, List<ExamRecord> records) {
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (ExamRecord record : records) {
                writer.write(record.getName() + "," + record.getScore() + "\n");
            }
            System.out.println("Uložen soubor: " + outputFile.getName());
        } catch (IOException e) {
            System.err.println("Chyba při ukládání souboru: " + e.getMessage());
        }
    }
}