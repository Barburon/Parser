package main;

import main.model.Article;
import main.service.Parser;
import main.util.CsvConverter;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        String kids = "https://allegro.pl/kategoria/dziecko?string=bargain_zone&bmatch=e2101-d3681-c3682-bab-1-2-0319";
        String culture = "https://allegro.pl/kategoria/kultura-i-rozrywka?string=bargain_zone&bmatch=e2101-d3681-c3682-cul-1-2-0319";
        String art = "https://allegro.pl/kategoria/kolekcje-i-sztuka?string=bargain_zone&bmatch=nbn-e2101-d3681-c3682-col-1-2-0319";

        Parser service = new Parser();
        Set<Article> kidsList = service.toParse(kids, 8);
        Set<Article> cultureList = service.toParse(culture, 8);
        Set<Article> artList = service.toParse(art, 8);

        CsvConverter.writeToCsv(kidsList, "kidsList");
        CsvConverter.writeToCsv(cultureList, "cultureList");
        CsvConverter.writeToCsv(artList, "artList");
    }
}