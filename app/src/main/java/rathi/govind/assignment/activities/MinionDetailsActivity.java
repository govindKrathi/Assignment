package rathi.govind.assignment.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import rathi.govind.assignment.R;


public class MinionDetailsActivity extends ActionBarActivity {

    ImageView image;
    TextView name, info, rating;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_minion_details);

        image = (ImageView) findViewById(R.id.ui_image_minion);
        name = (TextView) findViewById(R.id.ui_name_minion);
        info = (TextView) findViewById(R.id.ui_info_minion);
        rating = (TextView) findViewById(R.id.ui_rating_minion);

        int imageId = getIntent().getIntExtra("minionImage", 0);
        String imageName = getIntent().getStringExtra("minionName");
        String imageInfo = getIntent().getStringExtra("minionInfo");
        Double imageRating = getIntent().getDoubleExtra("minionRatings", 0.0);

        image.setImageDrawable(getResources().getDrawable(imageId));
        name.setText(imageName);
        info.setText(imageInfo);
        rating.setText(imageRating.toString());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return true;
    }
}