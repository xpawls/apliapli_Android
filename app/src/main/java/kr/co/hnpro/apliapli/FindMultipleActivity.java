package kr.co.hnpro.apliapli;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
    작성일 : 2018년 2월 24일
    작성자 : 김형남
    제작의도 : 입력한 두 숫자의 최소공배수를 찾아 결과로 출력.

    설명
    최소공배수 => 3, 5

 */

public class FindMultipleActivity extends BaseActivity {

    private android.widget.EditText firstNumEdt;
    private android.widget.EditText secondNumEdt;
    private android.widget.Button findMultipleBtn;
    private android.widget.TextView resultTxt;
    private android.widget.LinearLayout resultLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_multiple);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        findMultipleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int fne = Integer.parseInt(firstNumEdt.getText().toString());
                int sne = Integer.parseInt(secondNumEdt.getText().toString());


                // 두개의 숫자의 최소공배수를 탐색. => JAVA 알고리즘
                // 1~숫자를 증가. 15 % 3 && 15 % 5 => 둘다 0이라면 두 숫자의 공배수.

                // ex. 6,10 => 6*10 = 60 이 값은 무조건 둘다 나눠떨어짐.

                int result = 0;
                for (int i = 1; i <= fne * sne; i++) {
                    if (i % fne == 0 && i % sne == 0) {
                        // 반복을 돌다가 둘다 0으로 나눠떨어진다 => 공배수를 찾았다.
                        // 지금 돌고 있는 i값 (처음으로 찾아낸 값)이 바로 최소공배수

                        result = i;
                        // 최소공배수를 찾아내면, 더이상 반복을 돌 필요가 X.
                        break;
                    }
                }
                String resultStr = String.format("%d 입니다", result);
                resultTxt.setText(resultStr);
                resultLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.resultLayout = (LinearLayout) findViewById(R.id.resultLayout);
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.findMultipleBtn = (Button) findViewById(R.id.findMultipleBtn);
        this.secondNumEdt = (EditText) findViewById(R.id.secondNumEdt);
        this.firstNumEdt = (EditText) findViewById(R.id.firstNumEdt);
    }
}
