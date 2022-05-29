package uas.bayu.belajarmusik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnTradisionalStart;
    private Button mBtnModernStart;
    private CardView mCardPlayQuiz;
    private CardView mCardAboutMe;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnTradisionalStart = (Button) findViewById(R.id.btnTradisionalStart);
        mBtnModernStart = (Button) findViewById(R.id.btnModernStart);
        mCardPlayQuiz = (CardView) findViewById(R.id.cardPlayQuiz);
        mCardAboutMe = (CardView) findViewById(R.id.cardAboutMe);

        mBtnModernStart.setOnClickListener(this);
        mBtnTradisionalStart.setOnClickListener(this);
        mCardPlayQuiz.setOnClickListener(this);
        mCardAboutMe.setOnClickListener(this);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnModernStart:
                intent = new Intent(this, LearnActivity.class);
                intent.putExtra("menu", "music_modern");
                startActivity(intent);
                break;
            case R.id.btnTradisionalStart:
                intent = new Intent(this, LearnActivity.class);
                intent.putExtra("menu", "music_tradisional");
                startActivity(intent);
                break;
            case R.id.cardPlayQuiz:
                intent = new Intent(this, QuizActivity.class);
                startActivity(intent);
                break;
            case R.id.cardAboutMe:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }
}