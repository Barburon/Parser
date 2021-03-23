package main.service;

import main.model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private int id = 0;

    public List<Article> toParse(String link, int numOfPages) {
        int pagesLimit = 1;
        List<Article> resultList;
        List<Article> articleList = new ArrayList<>();
        Document document = null;
    do {
        try {
            document = Jsoup.connect(link + "&page"+ pagesLimit++)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (HTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .get();
            Thread.sleep(600);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        assert document != null;
        String category = document.select("body > div.main-wrapper > div:nth-child(4) > div > div > div > div > div > div:nth-child(1) > div > div > div > div > div._3kk7b.myre_zn._e8a20_CWOtz._vnd3k > div > div > div > div._17qy1._bxr46._d2756_GNE_S._d2756_2aXO4 > a > span").text();
        Elements elements = document.getElementsByAttributeValue("class", "mgn2_13 mqu1_ae mp0t_0a mgmw_ia mli8_k4 _9c44d_3UsPL ");
        Elements articles = elements.select("article");
        for (Element element : articles) {
            Elements aElem = element.select("a");
            String name = aElem.text();
            String oldPrice = element.select("div > div.mpof_ki.myre_zn._9c44d_1Hxbq > div.mp0t_ji.mpof_vs._9c44d_1VS-Y._9c44d_3_DDQ.mpof_vs._9c44d_2MDwk > span.mpof_uk.mqu1_ae._9c44d_18kEF.m9qz_yp._9c44d_2BSa0._9c44d_KrRuv").text();
            String newPrice = element.select("div > div.mpof_ki.myre_zn._9c44d_1Hxbq > div._9c44d_3AMmE > div > div > span").text();
            String deals = element.select("div > div.mpof_ki.myre_zn._9c44d_1Hxbq > div._9c44d_3K52C > div.mpof_ki.m389_6m.munh_56_l > span").text();
            String discount = element.select("div > div.mpof_ki.myre_zn._9c44d_1Hxbq > div.mp0t_ji.mpof_vs._9c44d_1VS-Y._9c44d_3_DDQ.mpof_vs._9c44d_2MDwk > span._9c44d_1uHr2").text();
            String url = aElem.attr("href");
            articleList.add(new Article(++id, category, name, oldPrice, newPrice, discount, deals, url));
        }
        resultList = articleList.stream()
                .distinct()
                .filter(article -> !article.getOldPrice().isBlank())
                .limit(100)
                .collect(Collectors.toList());
    }while ( resultList.size() < 100 && pagesLimit < numOfPages );
        resultList.forEach(System.out::println);
        return resultList;
    }
}