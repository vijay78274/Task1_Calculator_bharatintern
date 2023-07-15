package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = findViewById(R.id.result);
        final TextView express = findViewById(R.id.express);

        final Button clr = findViewById(R.id.clr);
        final Button del = findViewById(R.id.del);
        final Button minbtn = findViewById(R.id.minbtn);
        final Button modbtn = findViewById(R.id.modbtn);
        final Button divbtn = findViewById(R.id.divbtn);
        final Button addbtn = findViewById(R.id.addbtn);
        final Button eqbtn = findViewById(R.id.eqbtn);
        final Button decbtn = findViewById(R.id.decbtn);
        final Button mulbtn = findViewById(R.id.mulbtn);
        final Button btn0 = findViewById(R.id.btn0);
        final Button btn1 = findViewById(R.id.btn1);
        final Button btn2 = findViewById(R.id.btn2);
        final Button btn3 = findViewById(R.id.btn3);
        final Button btn4 = findViewById(R.id.btn4);
        final Button btn5 = findViewById(R.id.btn5);
        final Button btn6 = findViewById(R.id.btn6);
        final Button btn7 = findViewById(R.id.btn7);
        final Button btn8 = findViewById(R.id.btn8);
        final Button btn9 = findViewById(R.id.btn9);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0+");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar=='.'){
                        express.setText(expression.substring(0,expression.length()-1)+"+");
                    }
                    else
                        express.setText(expression+ "+");
                }
            }
        });
        minbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0-");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar=='.'){
                        express.setText(expression.substring(0,expression.length()-1)+"-");
                    }
                    else
                        express.setText(expression+ "-");
                }
            }
        });
        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0*");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar=='.'){
                        express.setText(expression.substring(0,expression.length()-1)+"*");
                    }
                    else
                        express.setText(expression+ "*");
                }
            }
        });
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0/");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar=='.'){
                        express.setText(expression.substring(0,expression.length()-1)+"/");
                    }
                    else
                        express.setText(expression+ "/");
                }
            }
        });
        modbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0%");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar =='.'){
                        express.setText(expression.substring(0,expression.length()-1)+"%");
                    }
                    else
                        express.setText(expression+ "%");
                }
            }
        });
        eqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String myresult = "";
                Scriptable scriptable = rhino.initStandardObjects();
                myresult = rhino.evaluateString(scriptable,expression,"JavaScript",1,null).toString();
                result.setText(myresult);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(!expression.isEmpty()){
                    express.setText(expression.substring(0,expression.length()-1));
                }
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express.setText("");
                result.setText("");
            }
        });
        decbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                if(expression.isEmpty()){
                    express.setText("0.");
                }
                else{
                    final char lastchar = expression.charAt(expression.length()-1);
                    if(lastchar == '+' || lastchar == '-' || lastchar == '*' || lastchar == '/' || lastchar == '%' || lastchar == '.'){
                        express.setText(expression.substring(0,expression.length()-1)+".");
                    }
                    else {
                        express.setText(expression + ".");
                    }
                }
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String expression = express.getText().toString();
                express.setText(expression + "9");
            }
        });
    }
}