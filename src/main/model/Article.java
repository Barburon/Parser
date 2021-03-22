package main.model;

public class Article {

    private String category;
    private String name;
    private String oldPrice;
    private String newPrice;
    private String discount;
    private String deals;
    private String url;

    public Article(String category, String name, String oldPrice, String newPrice, String discount, String deals, String url) {

        this.category = category;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.discount = discount;
        this.deals = deals;
        this.url = url;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDeals() {
        return deals;
    }

    public void setDeals(String deals) {
        this.deals = deals;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" +

                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", oldPrice='" + oldPrice + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", discount='" + discount + '\'' +
                ", deals='" + deals + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}