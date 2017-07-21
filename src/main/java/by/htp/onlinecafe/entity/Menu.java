package by.htp.onlinecafe.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Menu implements Serializable{

    private static final long serialVersionUID = -7724289072200931588L;
    private Integer id;
    private LocalDateTime creationTime;
    private MenuStatus menuStatus;
    private MenuLanguage menuLanguage;
    private List<MenuItem> menuItemList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public MenuStatus getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(MenuStatus menuStatus) {
        this.menuStatus = menuStatus;
    }

    public MenuLanguage getMenuLanguage() {
        return menuLanguage;
    }

    public void setMenuLanguage(MenuLanguage menuLanguage) {
        this.menuLanguage = menuLanguage;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (getId() != null ? !getId().equals(menu.getId()) : menu.getId() != null) return false;
        if (getCreationTime() != null ? !getCreationTime().equals(menu.getCreationTime()) : menu.getCreationTime() != null)
            return false;
        if (getMenuStatus() != menu.getMenuStatus()) return false;
        if (getMenuLanguage() != menu.getMenuLanguage()) return false;
        return getMenuItemList() != null ? getMenuItemList().equals(menu.getMenuItemList()) : menu.getMenuItemList() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCreationTime() != null ? getCreationTime().hashCode() : 0);
        result = 31 * result + (getMenuStatus() != null ? getMenuStatus().hashCode() : 0);
        result = 31 * result + (getMenuLanguage() != null ? getMenuLanguage().hashCode() : 0);
        result = 31 * result + (getMenuItemList() != null ? getMenuItemList().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", creationTime=" + creationTime +
                ", menuStatus=" + menuStatus +
                ", menuLanguage=" + menuLanguage +
                ", menuItemList=" + menuItemList +
                '}';
    }

    public enum MenuLanguage{
        EN_EN,
        RU_RU
    }

    public enum MenuStatus{
        ACTIVE,
        IDLE
    }
}
