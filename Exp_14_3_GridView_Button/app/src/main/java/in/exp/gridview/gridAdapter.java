package in.exp.gridview;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.Random;

public class gridAdapter extends BaseAdapter {

    String[] btn_name = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
    Context context;

    public gridAdapter(Context c) {
        this.context = c;
    }

    @Override
    public int getCount() {
        return btn_name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button btn;
        if (view == null) {
            btn = new Button(context);
            btn.setLayoutParams(new GridView.LayoutParams(500, 100));
        } else {
            btn = (Button) view;
        }
        btn.setText(btn_name[i]);

        Random rand = new Random();
        int r = rand.nextInt(156);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        int a = rand.nextInt(255);
        int color = Color.argb(a, r, g, b);
        btn.setBackgroundColor(color);
        return btn;
    }
}
