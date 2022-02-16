package dev.tubagusahmad.library.popups.menu;

public class MenuItem {

    private String title;
    private int icon;
    private int color = 0;

    public MenuItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public MenuItem(String title, int icon, int color){
        this.title = title;
        this.icon = icon;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon(){
        return icon;
    }

    public int getColor() {
        return color;
    }
}
