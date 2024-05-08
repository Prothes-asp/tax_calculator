package com.aspprothesbarai.taxcalculation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
    LayoutInflater inflater;
    Context context;
    int flags[];
    String gridTitle[];
    Animation animation;
    public CustomBaseAdapter(MainActivity mainActivity, int[] flags, String[] gridTitle) {
        this.context = mainActivity;
        this.flags = flags;
        this.gridTitle = gridTitle;
    }

    @Override
    public int getCount() {
        return gridTitle.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_sample_layout,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.gridImgId);
        TextView textView = convertView.findViewById(R.id.gridTvId);
        imageView.setImageResource(flags[position]);
        textView.setText(gridTitle[position]);
        animation = AnimationUtils.loadAnimation(context,R.anim.fade_in);
        convertView.setAnimation(animation);
        return convertView;
    }
}
