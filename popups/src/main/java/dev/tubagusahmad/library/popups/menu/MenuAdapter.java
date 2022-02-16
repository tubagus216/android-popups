package dev.tubagusahmad.library.popups.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dev.tubagusahmad.library.popups.R;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private List<MenuItem> menuItems;

    public MenuAdapter(Context context, List<MenuItem> menuItems){
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int i) {
        return menuItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View v, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_item,viewGroup, false);

        ItemViewHolder holder = new ItemViewHolder(view);
        MenuItem item = menuItems.get(i);

        if (!(item.getColor() == 0)){
            holder.icon.setColorFilter(item.getColor());
            holder.title.setTextColor(item.getColor());
        }

        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getIcon());

        return view;
    }

    private class ItemViewHolder{
        private ImageView icon;
        private TextView title;
        private ItemViewHolder(View view){
            icon = view.findViewById(R.id.icons);
            title = view.findViewById(R.id.titles);
        }
    }
}
