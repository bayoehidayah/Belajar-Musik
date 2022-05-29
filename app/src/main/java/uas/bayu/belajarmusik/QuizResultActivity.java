package uas.bayu.belajarmusik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import uas.bayu.belajarmusik.utils.QuestionDatas;

public class QuizResultActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mBackBtn;
    private TextView mTotalPertanyaan;
    private TextView mTotalJawabanBenar;
    private TextView mTotalJawabanSalah;
    private TextView mTotalScore;
    private Button mBtnDone;

    private Bundle bundle;
    private int scorePerCorrectAnswer = 10;
    private int correctQuestion;
    private int totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        initView();

        bundle = getIntent().getExtras();
        correctQuestion = bundle.getInt("correctAnswer");
        totalScore = correctQuestion * scorePerCorrectAnswer;

        mTotalPertanyaan.setText(Integer.toString(bundle.getInt("totalQuestion")));
        mTotalJawabanBenar.setText(Integer.toString(correctQuestion));
        mTotalScore.setText(Integer.toString(totalScore));
        mTotalJawabanSalah.setText(Integer.toString((10 - correctQuestion)));
    }

    private void initView() {
        mBackBtn = (FloatingActionButton) findViewById(R.id.backBtn);
        mTotalPertanyaan = (TextView) findViewById(R.id.totalPertanyaan);
        mTotalJawabanBenar = (TextView) findViewById(R.id.totalJawabanBenar);
        mTotalJawabanSalah = (TextView) findViewById(R.id.totalJawabanSalah);
        mTotalScore = (TextView) findViewById(R.id.totalScore);
        mBtnDone = (Button) findViewById(R.id.btnDone);

        mBackBtn.setOnClickListener(this);
        mBtnDone.setOnClickListener(this);
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        finish();
        onBackPressed();
    }
}