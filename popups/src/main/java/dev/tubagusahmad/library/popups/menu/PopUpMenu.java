package dev.tubagusahmad.library.popups.menu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import dev.tubagusahmad.library.popups.R;

public class PopUpMenu extends MenuInstances {

    private static PopUpMenu instance;

    private PopupWindow popupWindow;

    public static PopUpMenu getInstance(){
        if (instance == null){
            instance = new PopUpMenu();
        }
        return instance;
    }

    public PopUpMenu addView(View view){
        popupWindow = new PopupWindow(view.getContext());
        View container = view.findViewById(R.id.container);

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(Color.WHITE);
        gd.setCornerRadius(25);
        container.setBackground(gd);
        container.setElevation(10);

        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        return instance;
    }

    public void showAt(View context){
        int[] location = new int[2];
        context.getLocationInWindow(location);
        popupWindow.showAtLocation(context, Gravity.NO_GRAVITY, location[0], location[1] - context.getHeight());
    }

    public void dismiss(){
        popupWindow.dismiss();
    }
}
