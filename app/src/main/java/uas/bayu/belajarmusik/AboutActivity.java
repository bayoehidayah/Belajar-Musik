package uas.bayu.belajarmusik;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton mBackBtn;
    private CardView mIgCard;
    private CardView mGithubCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initView();
    }

    private void initView() {
        mBackBtn = (FloatingActionButton) findViewById(R.id.backBtn);
        mIgCard = (CardView) findViewById(R.id.igCard);
        mGithubCard = (CardView) findViewById(R.id.githubCard);

        mBackBtn.setOnClickListener(this);
        mIgCard.setOnClickListener(this);
        mGithubCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backBtn:
                onBackPressed();
                finish();
                break;
            case R.id.igCard:
                toInstagram();
                break;
            case R.id.githubCard:
                toGithub();
                break;
        }
    }

    public void toInstagram(){
        try {
            Intent ig = new Intent(Intent.ACTION_SEND);
            ig.setPackage("com.instagram.android");
            startActivity(ig);
        }
        catch (Exception e){
            Intent ig = new Intent(Intent.ACTION_VIEW);
            ig.addCategory(Intent.CATEGORY_BROWSABLE);
            ig.setData(Uri.parse("https://www.instagram.com/bayoehidayah"));
            startActivity(ig);
        }
    }

    public void toGithub(){
        Intent github = new Intent(Intent.ACTION_VIEW);
        github.addCategory(Intent.CATEGORY_BROWSABLE);
        github.setData(Uri.parse("https://github.com/bayoehidayah"));
        startActivity(github);
    }
}