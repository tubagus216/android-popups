package dev.tubagusahmad.library.popups;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import dev.tubagusahmad.library.popups.menu.ContextMenu;
import dev.tubagusahmad.library.popups.menu.MenuAdapter;
import dev.tubagusahmad.library.popups.menu.MenuBuilder;
import dev.tubagusahmad.library.popups.menu.MenuInstances;
import dev.tubagusahmad.library.popups.menu.MenuItem;
import dev.tubagusahmad.library.popups.menu.PopUpMenu;

@SuppressLint("StaticFieldLeak")
public class PopUps {

    private static PopUps instance;
    private static View mContext, layoutView;

    private MenuInstances menuInstances;

    private static ListView itemList;

    private PopUpMenu popUpMenu;
    private ContextMenu contextMenu;

    private OnItemClickListener listener;

    public static PopUps createWith(View context){

        instance = new PopUps();
        mContext = context;

        layoutView = LayoutInflater.from(context.getContext()).inflate(R.layout.popups, null);

        itemList = layoutView.findViewById(R.id.itemList);

        return instance;
    }

    //Creating menu instances
    public PopUps instanceAs(MenuInstances menuInstances){

        this.menuInstances = menuInstances;

        return instance;
    }

    public PopUps setMenu(final MenuBuilder menuBuilder){

        MenuAdapter adapter = new MenuAdapter(mContext.getContext(), menuBuilder.getMenuItems());

        if (menuInstances instanceof PopUpMenu) {
            createPopUpMenu(menuBuilder);
        }else if(menuInstances instanceof ContextMenu){
            createContextMenu(menuBuilder);
        }

        itemList.setAdapter(adapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MenuItem item = menuBuilder.getMenuItems().get(i);
                listener.onItemClickListener(i, item);

                if (popUpMenu != null){
                    popUpMenu.dismiss();
                }

                if (contextMenu != null){
                    contextMenu.dismiss();
                }
            }
        });

        return instance;
    }

    private void createPopUpMenu(MenuBuilder menuBuilder){

        popUpMenu = PopUpMenu.getInstance()
                .addView(layoutView);

    }

    private void createContextMenu(MenuBuilder menuBuilder){
        contextMenu = ContextMenu.getInstance()
                .addView(layoutView);
    }

    public PopUps setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
        return instance;
    }


    public void show(){
        if (menuInstances instanceof  PopUpMenu){
            popUpMenu.showAt(mContext);
        }else if (menuInstances instanceof ContextMenu){
            contextMenu.show();
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(int position, MenuItem item);
    }
}
