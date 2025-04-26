package com.aihack.ecommerce.model;

public class FashionItem {
    private String id;
    private String gender;
    private String masterCategory;
    private String subCategory;
    private String articleType;
    private String baseColour;
    private String season;
    private int year;
    private String usage;
    private String productDisplayName;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    
    public FashionItem(String id, String gender, String masterCategory, String subCategory, 
                      String articleType, String baseColour, String season, int year, 
                      String usage, String productDisplayName, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.gender = gender;
        this.masterCategory = masterCategory;
        this.subCategory = subCategory;
        this.articleType = articleType;
        this.baseColour = baseColour;
        this.season = season;
        this.year = year;
        this.usage = usage;
        this.productDisplayName = productDisplayName;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters
    public String getId() { return id; }
    public String getGender() { return gender; }
    public String getMasterCategory() { return masterCategory; }
    public String getSubCategory() { return subCategory; }
    public String getArticleType() { return articleType; }
    public String getBaseColour() { return baseColour; }
    public String getSeason() { return season; }
    public int getYear() { return year; }
    public String getUsage() { return usage; }
    public String getProductDisplayName() { return productDisplayName; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getImageUrl() { return imageUrl; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setGender(String gender) { this.gender = gender; }
    public void setMasterCategory(String masterCategory) { this.masterCategory = masterCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }
    public void setArticleType(String articleType) { this.articleType = articleType; }
    public void setBaseColour(String baseColour) { this.baseColour = baseColour; }
    public void setSeason(String season) { this.season = season; }
    public void setYear(int year) { this.year = year; }
    public void setUsage(String usage) { this.usage = usage; }
    public void setProductDisplayName(String productDisplayName) { this.productDisplayName = productDisplayName; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
