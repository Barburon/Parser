package main.model;

import java.util.Objects;

public class Article {
    private Integer id;
    private String category;
    private String name;
    private String oldPrice;
    private String newPrice;
    private String discount;
    private String deals;
    private String url;

    public Article(Integer id, String category, String name, String oldPrice, String newPrice, String discount, String deals, String url) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.discount = discount;
        this.deals = deals;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(getId(), article.getId()) && Objects.equals(getCategory(), article.getCategory()) && Objects.equals(getName(), article.getName()) && Objects.equals(getOldPrice(), article.getOldPrice()) && Objects.equals(getNewPrice(), article.getNewPrice()) && Objects.equals(getDiscount(), article.getDiscount()) && Objects.equals(getDeals(), article.getDeals()) && Objects.equals(getUrl(), article.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCategory(), getName(), getOldPrice(), getNewPrice(), getDiscount(), getDeals(), getUrl());
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
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