package info.devexchanges.welcomescreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {

    public static ViewPagerFragment getInstance(int position, int bgColor) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("background", bgColor);
        fragment.setArguments(args);

        return fragment;
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        TextView title = (TextView)rootView.findViewById(R.id.title);
        TextView content = (TextView)rootView.findViewById(R.id.content);
        View relativeLayout = rootView.findViewById(R.id.container);
        ImageView image = (ImageView)rootView.findViewById(R.id.logo);

        image.setImageResource(R.drawable.logo);
        relativeLayout.setBackgroundColor(getResources().getColor(getArguments().getInt("background")));
        title.setText("Welcome, this is Page: " + (getArguments().getInt("position") + 1));
        content.setText(getString(R.string.lorem_ipsum));
        Log.d("Fragment", "position: " + title.getText().toString());
    }
}
