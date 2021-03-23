package main.util;

import com.opencsv.CSVWriter;
import main.model.Article;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvConverter {
    public static void writeToCsv(List<Article> list, String fileName) {
        CSVWriter writer = null;
        try {
            writer = new CSVWriter(new FileWriter(fileName+".csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] header = {"id", "category", "name", "old_price", "new_price", "discount", "deals", "url"};
        assert writer != null;
        writer.writeNext(header, true);
        for (Article a : list) {
            String[] line = new String[header.length];
            line[0] = String.valueOf(a.getId());
            line[1] = a.getCategory();
            line[2] = a.getName();
            line[3] = a.getOldPrice();
            line[4] = a.getNewPrice();
            line[5] = a.getDiscount();
            line[6] = a.getDeals();
            line[7] = a.getUrl();
            writer.writeNext(line);
        }
        try {
            writer.close();
            System.out.println("Converted was successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
