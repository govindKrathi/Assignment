package rathi.govind.assignment.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ScrollView;

import rathi.govind.assignment.ApplicationData;
import rathi.govind.assignment.R;
import rathi.govind.assignment.adapters.SliderPageAdapter;
import rathi.govind.assignment.fragments.MainFragment;

/**
 * The first activity of application which get started by creating ApplicationData which make call to
 * method who builds product catalogue. It also contails the SlidingImages which shows featured images of products.
 */
public class MainActivity extends ActionBarActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationData appData = (ApplicationData) getApplication();
            appData.intializeData();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.ui_content, new MainFragment()).commit();

        final ScrollView mScrollView = (ScrollView) findViewById(R.id.ui_scroll_view);
        assert mScrollView != null;
        mScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                //replace this line to scroll up or down
                mScrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        }, 1L);

        viewPager = (ViewPager) findViewById(R.id.ui_viewPager);
        PagerAdapter adapter = new SliderPageAdapter(MainActivity.this);
        viewPager.setAdapter(adapter);
    }


}
