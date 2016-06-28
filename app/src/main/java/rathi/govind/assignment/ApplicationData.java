package rathi.govind.assignment;

import android.app.Application;
import android.os.Build;

import java.util.ArrayList;

import rathi.govind.assignment.models.MinionCategory;

/**
 * It contains the offline catalogue of the MinionCategory's Data as ArrayList which can be available and accessible through out the application. <br>
 * When app get opened the ArrayList(MinionCategory data) is initialized by using initializedData() method. <br> To get the ArrayList of data
 * getProductData() method is need to be invoked.
 */
public class ApplicationData extends Application {
    ArrayList<MinionCategory> minionCategories = new ArrayList<>();

    int[] minionId = {
            R.drawable.minion_avatar,
            R.drawable.minion_black_widow,
            R.drawable.minion_demi_lovato,
            R.drawable.minion_iron_man,
            R.drawable.minion_joker,
            R.drawable.minion_lady_gaga,
            R.drawable.minion_xhr4,
            R.drawable.minion_xhr15,
            R.drawable.minion_selena_gomez,
            R.drawable.minion_jack_sparrow,
            R.drawable.minion_shakira,
            R.drawable.minion_spiderman,
            R.drawable.minion_xhr3
    };

    int[] minionInfo = {
            R.string.avatar_info,
            R.string.black_widow_info,
            R.string.demi_lovato_info,
            R.string.iron_man_info,
            R.string.joker_info,
            R.string.lady_gaga_info,
            R.string.kevin_info,
            R.string.hamada_info,
            R.string.selena_gomez_info,
            R.string.jack_sparrow_info,
            R.string.shakira_info,
            R.string.spiderman_info,
            R.string.bob_info
    };

    int[] minionName = {
            R.string.avatar,
            R.string.black_widow,
            R.string.demi_lovato,
            R.string.iron_man,
            R.string.joker,
            R.string.lady_gaga,
            R.string.kevin,
            R.string.hamada,
            R.string.selena_gomez,
            R.string.jack_sparrow,
            R.string.shakira,
            R.string.spiderman,
            R.string.bob
    };

    Double[] minionRatings = {6.5, 8.28, 7.34, 9.73, 9.0, 7.7, 6.98, 6.2, 7.96, 8.88, 8.16, 8.66, 9.34};

    /**
     * The product catalogue is build by invoking this method. The product data get stored in the form of ArrayList of MinionCategory Class.
     */
    public void intializeData() {


            minionCategories.clear();

            for (int i = 0; i < minionId.length; i++)
                minionCategories.add(new MinionCategory(minionId[i], getResources().getString(minionName[i]),
                        getResources().getString(minionInfo[i]), minionRatings[i]));

    }

    /**
     * Gives you the stored product data from catalogue.
     *
     * @return ArrayList object of MinionCategory class which contains data.
     */
    public ArrayList<MinionCategory> getProductData() {
        return minionCategories;
    }
}
