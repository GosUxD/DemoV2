package up.work.demoapp2.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import up.work.demoapp2.R;
import up.work.demoapp2.model.Storage;
import up.work.demoapp2.model.pojo.Result;

/**
 * Created by STT on 16.5.2016.
 */
public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "extra_title";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        String extraTitle = getIntent().getStringExtra(EXTRA_TITLE);

        Result result = Storage.getInstance().getResult(extraTitle);

        TextView mTextView = (TextView) findViewById(R.id.text_html);
        mTextView.setText(result.getHtml());
    }
}
