package rathi.govind.assignment.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import rathi.govind.assignment.R;

/**
 * It adapts the multiple images which are linked to the User Interface shown in the sliding view on MainActivity.
 */
public class SliderPageAdapter extends PagerAdapter {

    Context context;
    int[] imageId = {R.drawable.minion_slide1, R.drawable.minion_slide2, R.drawable.minion_slide3,R.drawable.minion_slide4,R.drawable.minion_slide5 };


    public SliderPageAdapter(Context context){
        this.context = context;

    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.view_slider_image, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.ui_slider_image);
        imageView.getLayoutParams().height = 240;
        imageView.getLayoutParams().width = RelativeLayout.LayoutParams.MATCH_PARENT;
        imageView.setImageResource(imageId[position]);
        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }

}
