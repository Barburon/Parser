package main;

import main.model.Article;
import main.service.Parser;
import main.util.CsvConverter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String electronica = "https://allegro.pl/kategoria/elektronika?string=bargain_zone&bmatch=cl-e2101-d3718-c3682-ele-1-2-0304&price-subsidy=1";
        String sport = "https://allegro.pl/kategoria/sport-i-turystyka?string=bargain_zone&bmatch=e2101-d3681-c3682-spo-1-2-0319&price-subsidy=1";
        String supermarket = "https://allegro.pl/kategoria/supermarket?string=bargain_zone&bmatch=e2101-d3681-c3682-sup-1-2-0319&price-subsidy=1";

        Parser service = new Parser();
        List<Article> electronicaList = service.toParse(electronica, 2);
        List<Article> sportList = service.toParse(sport, 2);
        List<Article> supermarketList = service.toParse(supermarket, 2);

        List<Article> resultList = new ArrayList<>(electronicaList.size() + sportList.size() + supermarketList.size());
        resultList.addAll(electronicaList);
        resultList.addAll(sportList);
        resultList.addAll(supermarketList);
        resultList.forEach(System.out::println);
        CsvConverter.writeToCsv(resultList);
    }
}