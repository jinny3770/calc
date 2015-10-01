package com.example.com.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button b1, b2, b3, b4, b5;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);

        findViewById(R.id.but1).setOnClickListener(myListener);
        findViewById(R.id.but2).setOnClickListener(myListener);
        findViewById(R.id.but3).setOnClickListener(myListener);
        findViewById(R.id.but4).setOnClickListener(myListener);
        findViewById(R.id.but5).setOnClickListener(myListener);


    }

    public Button.OnClickListener myListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s1, s2;
            double n1, n2;
            double result;

            s1 = edit1.getText().toString();
            s2 = edit2.getText().toString();

            if(s1.length()==0 || s2.length()==0) {
                Toast.makeText(getApplicationContext(), "값이 없습니다.", Toast.LENGTH_LONG);
                return;
            }

            else{

                try{
                    n1 = Double.parseDouble(s1);
                    n2 = Double.parseDouble(s2);

                }catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "숫자가 아닙니다.", Toast.LENGTH_LONG);
                    return;
                }

                switch(v.getId()){

                    case R.id.but1 :
                        result = n1 + n2;
                        break;

                    case R.id.but2 :
                        result = n1 - n2;
                        break;

                    case R.id.but3 :
                        result = n1 * n2;
                        break;

                    case R.id.but4 :

                        try{
                            result = n1 / n2;

                        }catch(ArithmeticException e){
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG);
                            return;
                        }
                        break;

                    case R.id.but5 :
                        result = n1 % n2;
                        break;

                    default : return;
                }
            }

            textView.setText("= " + Double.toString(result));
        }
    };
}
