package dev.tubagusahmad.library.popups.menu;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {

    private View headerView, footerView;

    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuBuilder(){}

    public void setHeaderView(View headerView){
        this.headerView = headerView;
    }

    public void addItem(MenuItem item){
        this.menuItems.add(item);
    }

    public void addFooterView(View footerView){
        this.footerView = footerView;
    }

    public View getHeaderView() {
        return headerView;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public View getFooterView() {
        return footerView;
    }

}
