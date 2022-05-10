package dev.tubagusahmad.library.popups.menu;

public class MenuItem {

    private String title = "";
    private int icon = 0;
    private int color = 0;
	
	public MenuItem(String title){
		this.title = title;
	}

    public MenuItem(int icon, String title){
        this.title = title;
        this.icon = icon;
    }

    public MenuItem(int icon, String title, int color){
        this.title = title;
        this.icon = icon;
        this.color = color;
    }
	
	public MenuItem(String title, int color){
		this.title = title;
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
