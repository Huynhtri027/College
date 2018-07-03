package eslam.example.com.college;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eslam.example.com.college.fragments.DashboardFragment;
import eslam.example.com.college.fragments.ProfileFragment;
import eslam.example.com.college.models.Posts;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private boolean control = false;
    private int first = 1;
    FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction()
                            .replace(R.id.head_container, new ProfileFragment())
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    // Create a new head BodyPartFragment
                    DashboardFragment headFragment2 = new DashboardFragment();
                    // Add the fragment to its container using a FragmentManager and a Transaction
                    fragmentManager.beginTransaction()
                            .replace(R.id.head_container, headFragment2)
                            .commit();
                    return true;

                case R.id.settings:
                    SettingsFragment settingsFragment = new SettingsFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.head_container, settingsFragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (control) {
            navigation.findViewById(R.id.settings).setVisibility(View.GONE);
        }
            ProfileFragment headFragment = new ProfileFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.head_container, headFragment)
                    .commit();
    }


}
