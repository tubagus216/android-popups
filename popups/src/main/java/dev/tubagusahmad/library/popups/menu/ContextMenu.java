package dev.tubagusahmad.library.popups.menu;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

import dev.tubagusahmad.library.popups.R;

import static android.graphics.Color.TRANSPARENT;

public class ContextMenu extends MenuInstances{

    private static ContextMenu instance;

    private Dialog dialog;

    public static ContextMenu getInstance(){
        if (instance == null){
            instance = new ContextMenu();
        }
        return instance;
    }

    public ContextMenu addView(View view){
        dialog = new Dialog(view.getContext());

        View container = view.findViewById(R.id.container);

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.WHITE);
        gd.setCornerRadius(25);
        container.setBackground(gd);
        container.setElevation(10);

        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(TRANSPARENT));

        return instance;
    }

    public void show(){
        dialog.show();
    }

    public void dismiss(){
        dialog.dismiss();
    }
}
