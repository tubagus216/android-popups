package dev.tubagusahmad.library.popups.menu;

public class MenuItem {

    private String title;
    private int icon;

    public MenuItem(String title, int icon){
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon(){
        return icon;
    }
}
