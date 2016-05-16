package up.work.demoapp2.view.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import up.work.demoapp2.R;
import up.work.demoapp2.view.fragments.ListFragment;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity);

        FragmentManager fm = getSupportFragmentManager();
        Fragment mFragment = new ListFragment();

        fm.beginTransaction()
                .add(R.id.contentFrame, mFragment)
                .commit();


    }
}
