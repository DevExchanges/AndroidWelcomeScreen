package info.devexchanges.welcomescreen;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private View btnDone;
    private SessionManager session;
    private View skipLayout;
    private static int colors[] = {android.R.color.holo_orange_dark, android.R.color.holo_purple,
            android.R.color.holo_blue_dark, android.R.color.holo_green_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        session = new SessionManager(getApplicationContext());

        viewPager = (ViewPager) findViewById(R.id.pager);
        CirclePageIndicator pageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        btnDone = findViewById(R.id.done);
        skipLayout = findViewById(R.id.layout);
        skipLayout.setBackgroundColor(getResources().getColor(colors[0]));
        final View btnSkip = findViewById(R.id.skip);

        //set viewpager adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //set page indicator
        pageIndicator.setViewPager(viewPager);

        //set onpage changed listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Main", "pos:" + position + "  " + positionOffset + "  " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == viewPager.getAdapter().getCount() - 1) {
                    btnDone.setVisibility(View.VISIBLE);
                    btnSkip.setVisibility(View.GONE);
                } else {
                    btnDone.setVisibility(View.GONE);
                    btnSkip.setVisibility(View.VISIBLE);
                }

                skipLayout.setBackgroundColor(getResources().getColor(colors[position]));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        assert btnSkip != null;
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
            }
        });

        //close this screen when click "DONE"
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setIsFirst(false);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        session.setIsFirst(false);
    }
}
