package rathi.govind.assignment.adapters;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import rathi.govind.assignment.R;
import rathi.govind.assignment.activities.MinionDetailsActivity;
import rathi.govind.assignment.models.MinionCategory;

/**
 * It adapts the Minions from ArrayList and assign them their values with liking to User Interface.
 */
public class MinionAdapter extends BaseAdapter {

    private static final String TAG = MinionAdapter.class.getSimpleName();
    ArrayList<MinionCategory> data = new ArrayList<>();

    LayoutInflater inflater;
    public static MinionHolder viewHolder;
    Context context;

    public MinionAdapter(LayoutInflater inflater, ArrayList<MinionCategory> data, Context context) {
        this.inflater = inflater;
        this.data = data;
        this.context = context;
    }//Constructor LikedProductAdapter


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        View rowView = convertView;


        if (rowView == null) {

            rowView = inflater.inflate(R.layout.view_minion, parent, false);
            viewHolder = new MinionHolder();
            viewHolder.image = (ImageView) rowView.findViewById(R.id.ui_minion_image);
            viewHolder.name = (TextView) rowView.findViewById(R.id.ui_minion_name);
            viewHolder.price = (TextView) rowView.findViewById(R.id.ui_minion_rating);
            rowView.setTag(viewHolder);

        } else {
            viewHolder = (MinionHolder) convertView.getTag();
        }


        viewHolder.image.setImageDrawable(context.getResources().getDrawable(data.get(position).getImgId()));
        viewHolder.name.setText(data.get(position).getName());
        viewHolder.price.setText(data.get(position).getRatings().toString());
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent productDetails = new Intent(context, MinionDetailsActivity.class);
                productDetails.putExtra("minionName",data.get(position).getName());
                productDetails.putExtra("minionInfo",data.get(position).getInformation());
                productDetails.putExtra("minionRatings",data.get(position).getRatings());
                productDetails.putExtra("minionImage",data.get(position).getImgId());
                context.startActivity(productDetails);

            }
        });

        return rowView;
    }


}//LikedProductAdapter class

/**
 * It refers to the minion data like image, name and rating etc.
 */
class MinionHolder {
    public ImageView image;
    public TextView name;
    public TextView price;
}//class CategoryProductViewHolder

