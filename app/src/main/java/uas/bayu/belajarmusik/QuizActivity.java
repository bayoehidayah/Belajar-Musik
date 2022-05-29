package uas.bayu.belajarmusik;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uas.bayu.belajarmusik.utils.QuestionDatas;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mBackBtn;
    private TextView mQuizQuestions;
    private ImageView mQuizImage;
    private TextView mQuizText;
    private CardView mBtnA;
    private CardView mBtnB;
    private CardView mBtnC;
    private CardView mBtnD;
    private TextView mBtnAText;
    private TextView mBtnBText;
    private TextView mBtnCText;
    private TextView mBtnDText;

    private int currentQuestionIndex = 0, totalCorrectQuestions = 0;
    private List<String> questions;
    private Map<String, Integer> imageList;
    private Map<String, Map<String, Boolean>> questionAnswer;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initView();
        initData();
        displayData();
    }

    private void initData() {
        questionAnswer = QuestionDatas.getQuestionsList();
        questions = new ArrayList<>(questionAnswer.keySet());
        imageList = QuestionDatas.getImageList();

        Log.d("Questions Answer", String.valueOf(questionAnswer));
        Log.d("Questions", String.valueOf(questions));
        Log.d("Image List", String.valueOf(imageList));
    }

    private void setAnswersToList() {
        ArrayList<String> questionKey = new ArrayList(questionAnswer.get(questions.get(currentQuestionIndex)).keySet());
        mBtnAText.setText(questionKey.get(0));
        mBtnBText.setText(questionKey.get(1));
        mBtnCText.setText(questionKey.get(2));
        mBtnDText.setText(questionKey.get(3));
    }

    private void initView() {
        mBackBtn = (FloatingActionButton) findViewById(R.id.backBtn);
        mQuizQuestions = (TextView) findViewById(R.id.quizQuestions);
        mQuizImage = (ImageView) findViewById(R.id.quizImage);
        mQuizText = (TextView) findViewById(R.id.quizText);
        mBtnA = (CardView) findViewById(R.id.btnA);
        mBtnB = (CardView) findViewById(R.id.btnB);
        mBtnC = (CardView) findViewById(R.id.btnC);
        mBtnD = (CardView) findViewById(R.id.btnD);
        mBtnAText = (TextView) findViewById(R.id.btnAText);
        mBtnBText = (TextView) findViewById(R.id.btnBText);
        mBtnCText = (TextView) findViewById(R.id.btnCText);
        mBtnDText = (TextView) findViewById(R.id.btnDText);

        mBackBtn.setOnClickListener(this);
        mBtnA.setOnClickListener(this);
        mBtnB.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnD.setOnClickListener(this);
    }

    private void displayData() {
        mQuizImage.setImageResource(imageList.get(questions.get(currentQuestionIndex)));
        mQuizText.setText(questions.get(currentQuestionIndex));
        mQuizQuestions.setText("Soal " + (currentQuestionIndex + 1) + "/" + questions.size());
        setAnswersToList();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        boolean answer = false;

        if (id == R.id.backBtn) {
            onBackPressed();
            finish();
        } else {
            if (currentQuestionIndex == (questions.size() - 1)) {
                bundle = new Bundle();
                bundle.putInt("correctAnswer", totalCorrectQuestions);
                bundle.putInt("totalQuestion", questions.size());

                Intent i = new Intent(this, QuizResultActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            } else {
                if (id == R.id.btnA) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnAText.getText());
                } else if (id == R.id.btnB) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnBText.getText());
                } else if (id == R.id.btnC) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnCText.getText());
                } else if (id == R.id.btnD) {
                    answer = questionAnswer.get(questions.get(currentQuestionIndex)).get(mBtnDText.getText());
                }

                if (answer) {
                    Toast.makeText(this, "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
                    totalCorrectQuestions++;
                }
                else{
                    Toast.makeText(this, "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();
                }

                currentQuestionIndex++;
                displayData();
            }
        }
    }
}