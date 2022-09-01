package in.exp.gridviewexp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class gridAdapter extends BaseAdapter {
    private Context context;
    public Integer images[] = {R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13,};

    public gridAdapter(){

    }
    public gridAdapter(Context context1) {
        this.context = context1;
    }

    @Override
    public int getCount() {
        return images.length;
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

        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));

        } else {
            imageView = (ImageView) view;
        }

        imageView.setImageResource(images[i]);

        return imageView;
    }
}
