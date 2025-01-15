package com.example.uaspbobj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

public class NavbarHelper {

    @SuppressLint("UseCompatLoadingForColorStateLists")
    public static void setupNavbar(Activity activity) {
        ImageView ivHome = activity.findViewById(R.id.ivHome);
        ImageView ivCart = activity.findViewById(R.id.ivCart);
        ImageView ivAccount = activity.findViewById(R.id.ivAccount);

        resetIcons(ivHome, ivCart, ivAccount);

        String currentPage = activity.getClass().getSimpleName();

        if (currentPage.equals("AccountActivity")) {
            ivAccount.setColorFilter(activity.getResources().getColor(R.color.yellow),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        } else if (currentPage.equals("CartActivity")) {
            ivCart.setColorFilter(activity.getResources().getColor(R.color.yellow),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        } else if (currentPage.equals("HomeActivity")) {
            ivHome.setColorFilter(activity.getResources().getColor(R.color.yellow),
                    android.graphics.PorterDuff.Mode.SRC_IN);
        }
    }

    private static void resetIcons(ImageView ivHome, ImageView ivCart, ImageView ivAccount) {
        ivHome.setBackgroundTintList(null);
        ivCart.setBackgroundTintList(null);
        ivAccount.setBackgroundTintList(null);
    }
}
