package pro1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(String outputPath, List<ExamRecord> records) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            for (ExamRecord record : records) {
                writer.write(record.getName() + "," + record.getScore() + "\n");
            }
            System.out.println("Export hotový: " + outputPath);
        } catch (IOException e) {
            System.err.println("Chyba při exportu do CSV: " + e.getMessage());
        }
    }
}