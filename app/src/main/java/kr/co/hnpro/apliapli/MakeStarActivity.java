package kr.co.hnpro.apliapli;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MakeStarActivity extends BaseActivity implements View.OnClickListener{

    private android.widget.Button leftBottomStarBtn;
    private android.widget.Button leftTopStarBtn;
    private android.widget.Button rightBottomStarBtn;
    private android.widget.Button rightTopStarBtn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_star);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        /*leftTopStarBtn.setOnClickListener(this);
        leftBottomStarBtn.setOnClickListener(this);*/

        leftTopStarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNormalStar();
                resultTxt.setGravity(Gravity.LEFT);
            }


        });

        leftBottomStarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printReverseStar();
                resultTxt.setGravity(Gravity.LEFT);
            }
        });

        rightTopStarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNormalStar();
                resultTxt.setGravity(Gravity.RIGHT);
            }
        });

        rightBottomStarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printReverseStar();
                resultTxt.setGravity(Gravity.RIGHT);
            }
        });
    }

    private void printReverseStar() {

        String starStr = "";

        for (int i=5; i>0; i--){
            for (int j=0; j<i; j++){
                starStr += "*";
            }
            starStr += "\n";
        }

        resultTxt.setText(starStr);
    }

    private void printNormalStar() {

        String starStr = "";

        for (int i=0; i<5; i++){
            for (int j=0; j<i; j++){
                starStr += "*";
            }
            starStr += "\n";
        }

        resultTxt.setText(starStr);
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.rightTopStarBtn = (Button) findViewById(R.id.rightTopStarBtn);
        this.rightBottomStarBtn = (Button) findViewById(R.id.rightBottomStarBtn);
        this.leftTopStarBtn = (Button) findViewById(R.id.leftTopStarBtn);
        this.leftBottomStarBtn = (Button) findViewById(R.id.leftBottomStarBtn);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.leftBottomStarBtn){
            // 맞다 = > 구구단 버튼이 눌림.

            Toast.makeText(mContext, "leftBottomStarBtn 버튼 클릭", Toast.LENGTH_SHORT).show();
            String rs = "";
            for (int i=0; i<5; i++){
                for (int j=0; j<5; j++){
                    if (j<=i){
                        rs += "*";
                    }
                    else if (j>i){
                        rs += " ";
                    }
                    else {
                        rs += "\\n";
                    }
                }
            }
            resultTxt.setText(rs);
        }
        else if (view.getId() == R.id.leftTopStarBtn){
            // 별찍기 버튼 클릭
            Toast.makeText(mContext, "leftTopStarBtn 버튼 클릭", Toast.LENGTH_SHORT).show();
        }
    }
}
