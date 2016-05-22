package info.devexchanges.welcomescreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int colors[] = {android.R.color.holo_orange_dark, android.R.color.holo_purple,
            android.R.color.holo_blue_dark, android.R.color.holo_green_dark};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return ViewPagerFragment.getInstance(position, colors[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
