package uas.bayu.belajarmusik;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uas.bayu.belajarmusik.utils.LessonDatas;

public class LearnActivity extends AppCompatActivity implements View.OnClickListener {

    private String getLessonType;
    private FloatingActionButton mBackBtn;
    private ImageView mLessonImage;
    private TextView mLessonText;
    private TextView mTitleText;
    private CardView mBtnPrevious;
    private CardView mBtnNext;

    private int curentLessonData = 0;
    private List<String> datas;
    private Map<String, String> lessonDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initView();
        Bundle bundle = getIntent().getExtras();
        getLessonType = bundle.getString("menu");

        initData();
        displayData();
    }

    private void initData() {
        if (getLessonType.equals("music_tradisional")) {
            mTitleText.setText("Alat Musik Tradisional");
            lessonDatas = LessonDatas.getTradisionalLessons();
        } else {
            mTitleText.setText("Alat Musik Modern");
            lessonDatas = LessonDatas.getModernLessons();
        }

        datas = new ArrayList<>(lessonDatas.keySet());
    }

    private void initView() {
        mBackBtn = (FloatingActionButton) findViewById(R.id.backBtn);
        mLessonImage = (ImageView) findViewById(R.id.lessonImage);
        mLessonText = (TextView) findViewById(R.id.lessonText);
        mTitleText = (TextView) findViewById(R.id.titleText);
        mBtnPrevious = (CardView) findViewById(R.id.btnPrevious);
        mBtnNext = (CardView) findViewById(R.id.btnNext);

        mBackBtn.setOnClickListener(this);
        mBtnPrevious.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
    }

    public void displayData() {
        mLessonText.setText(lessonDatas.get(datas.get(curentLessonData)));
        mLessonImage.setImageResource(Integer.valueOf(datas.get(curentLessonData)));
        checkNomor();
    }

    private void checkNomor() {
        if (curentLessonData == 0) {
            mBtnNext.setEnabled(true);
            mBtnPrevious.setEnabled(false);
        } else if (curentLessonData == (lessonDatas.size() - 1)) {
            mBtnNext.setEnabled(false);
            mBtnPrevious.setEnabled(true);
        } else {
            mBtnNext.setEnabled(true);
            mBtnPrevious.setEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.backBtn) {
            onBackPressed();
            finish();
        } else {
            if (id == R.id.btnNext) {
                curentLessonData++;
            } else if (id == R.id.btnPrevious) {
                curentLessonData--;
            }

            displayData();
        }
    }
}