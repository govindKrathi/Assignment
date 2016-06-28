package rathi.govind.assignment.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import rathi.govind.assignment.ApplicationData;
import rathi.govind.assignment.R;
import rathi.govind.assignment.adapters.MinionAdapter;
import rathi.govind.assignment.models.MinionCategory;

/**
 * It shows you the search product results.
 */
public class SearchResultsActivity extends ActionBarActivity {

    private GridView grid;
    private MinionAdapter adapter;
    ApplicationData appData;
    ArrayList<MinionCategory> searchedMinionCategory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);


        searchedMinionCategory = handleSearch(getIntent().getStringExtra("searchQuery"));
        grid = (GridView) findViewById(R.id.ui_grid_search_minion);

        if (searchedMinionCategory == null) {
            return;
        }
        adapter = new MinionAdapter(getLayoutInflater(), searchedMinionCategory, this);
        grid.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        final SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                if (searchedMinionCategory == null) {
                    return false;
                }
                searchedMinionCategory.clear();
                searchedMinionCategory = handleSearch(query);
                if (searchedMinionCategory == null) {
                    return false;
                }
                adapter = new MinionAdapter(getLayoutInflater(), searchedMinionCategory, getApplicationContext());
                grid.setAdapter(adapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.exit:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Exit");
                alertDialogBuilder
                        .setMessage("Click Yes to Exit from application.")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                System.exit(1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.language:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                if (item.getTitle().toString().equalsIgnoreCase("English"))
                    setLocale("en");
                else
                    setLocale("hi");
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    private ArrayList<MinionCategory> handleSearch(String query) {
        ArrayList<MinionCategory> tempMinionCategory = null;

        appData = (ApplicationData) getApplication();
        tempMinionCategory = new ArrayList<>();
        for (MinionCategory minionCategory : appData.getProductData()) {
            if (minionCategory.getName().toLowerCase().contains(query.toLowerCase()) || minionCategory.getInformation().toLowerCase().contains(query.toLowerCase())) {
                tempMinionCategory.add(minionCategory);
            }
        }
        if (tempMinionCategory.isEmpty()) {
            final Intent intent = new Intent(this, MainActivity.class);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Result");
            alertDialogBuilder
                    .setMessage("No Data Found. Try with another keywords.")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

        return tempMinionCategory;

    }

    public void setLocale(String lang) {

        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        onConfigurationChanged(conf);
        Intent intent = this.getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
//        getActivity().recreate();

        startActivity(intent);

    }

}
