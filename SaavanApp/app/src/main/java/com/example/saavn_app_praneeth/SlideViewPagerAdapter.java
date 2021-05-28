package com.example.saavn_app_praneeth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {
    private Context context;
// crete a constructor for context
    public SlideViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3; // number of layout's
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object; //if view == object
    }

    //basically it call when we slide the screen's
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE); // cast it in layoutInflator
            View view = layoutInflater.inflate(R.layout.slide_screen,container,false);

        ImageView imageView = view.findViewById(R.id.ivSingerImage);
        ImageView dot1 = view.findViewById(R.id.dot1);
        ImageView dot2 = view.findViewById(R.id.dot2);
        ImageView dot3 = view.findViewById(R.id.dot3);
        TextView TvDes = view.findViewById(R.id.tvDes1);
        TextView TvLetsRock = view.findViewById(R.id.tvLetsRock);
        switch (position){
            case 0:
                imageView.setImageResource(R.drawable.signer4_bg_remove);
                dot1.setImageResource(R.drawable.selected);
                dot2.setImageResource(R.drawable.unselected);
                dot3.setImageResource(R.drawable.unselected);
                TvLetsRock.setText("Let's Rock");
                TvDes.setText("Create an account or log in to keep using JioSaavn!");
                break;
            case 1:
                imageView.setImageResource(R.drawable.singer_bg_remove);
                dot1.setImageResource(R.drawable.unselected);
                dot2.setImageResource(R.drawable.selected);
                dot3.setImageResource(R.drawable.unselected);
                TvLetsRock.setText("Unlimited Listening");
                TvDes.setText("No limits.Just music.Create your account or Log in to keep listening.");
                break;
            case 2:
                imageView.setImageResource(R.drawable.singer2_bg_remove);
                dot1.setImageResource(R.drawable.unselected);
                dot2.setImageResource(R.drawable.unselected);
                dot3.setImageResource(R.drawable.selected);
                TvLetsRock.setText("Recommendations");
                TvDes.setText("We'll learn what you dig and suggest more you might like.");
                break;
        }
            container.addView(view);
            return view;
        }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
