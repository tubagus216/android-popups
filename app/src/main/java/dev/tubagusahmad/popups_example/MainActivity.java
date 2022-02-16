package dev.tubagusahmad.popups_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.tubagusahmad.library.popups.PopUps;
import dev.tubagusahmad.library.popups.menu.Menu;
import dev.tubagusahmad.library.popups.menu.MenuBuilder;
import dev.tubagusahmad.library.popups.menu.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ImageView moreAction;
    private ListView listDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moreAction = findViewById(R.id.moreAction);
        listDemo = findViewById(R.id.listDemo);

        initListView();

        moreAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view, true); //Show as PopUps
            }
        });
    }

    private void initListView(){
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getList());
        listDemo.setAdapter(adapter);

        listDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showMenu(view, true); //Show as PopUp
            }
        });

        listDemo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showMenu(view, false); //Show as ContextMenu
                return true;
            }
        });
    }

    private void showMenu(View view, boolean isPopUp){
        PopUps.createWith(view)
                .instanceAs(isPopUp ? Menu.asPopUpMenu() : Menu.asContextMenu()) //Showing popup or contextmenu
                .setMenu(getMenu())
                .setOnItemClickListener(new PopUps.OnItemClickListener() {
                    @Override
                    public void onItemClickListener(int position, MenuItem item) {
                        Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    private MenuBuilder getMenu(){

        MenuBuilder builder = new Menu.Builder().build(); //Menu Builder

        builder.addItem(new MenuItem("Android", R.drawable.ic_android, Color.GRAY)); //Colored Item
        builder.addItem(new MenuItem("Share", R.drawable.ic_share, Color.BLUE)); //Colored Item
        builder.addItem(new MenuItem("Download", R.drawable.ic_download, Color.GREEN)); //Colored Item
        builder.addItem(new MenuItem("Setting", R.drawable.ic_setting)); //Normal Item
        builder.addItem(new MenuItem("Delete", R.drawable.ic_delete, Color.RED)); //Colored Item

        return builder;
    }

    private List<String> getList(){

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            items.add("Demo Item " + i);
        }
        return items;
    }
}
