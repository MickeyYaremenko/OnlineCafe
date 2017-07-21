package by.htp.onlinecafe.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class MenuItem implements Serializable{

    private static final long serialVersionUID = -6914326853801254086L;
    private Integer id;
    private String title;
    private String weight;
    private BigDecimal price;
    private String category;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        if (getId() != null ? !getId().equals(menuItem.getId()) : menuItem.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(menuItem.getTitle()) : menuItem.getTitle() != null) return false;
        if (getWeight() != null ? !getWeight().equals(menuItem.getWeight()) : menuItem.getWeight() != null)
            return false;
        if (getPrice() != null ? !getPrice().equals(menuItem.getPrice()) : menuItem.getPrice() != null) return false;
        if (getCategory() != null ? !getCategory().equals(menuItem.getCategory()) : menuItem.getCategory() != null)
            return false;
        return getDescription() != null ? getDescription().equals(menuItem.getDescription()) : menuItem.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
