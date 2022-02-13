package dev.tubagusahmad.library.popups.menu;

public class Menu {

    public static ContextMenu asContextMenu(){
        return ContextMenu.getInstance();
    }

    public static PopUpMenu asPopUpMenu(){
        return PopUpMenu.getInstance();
    }

    public static class Builder{
        public Builder(){}
        public MenuBuilder build(){
            return new MenuBuilder();
        }
    }
}
