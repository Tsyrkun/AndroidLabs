package com.example.asdf.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnOpen;
    EditText txtInput;
    CheckBox changeMode;

    public static final String EXTRA_MESSAGE = "com.example.asdf.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = (EditText) findViewById(R.id.txtInput);
        changeMode = (CheckBox) findViewById(R.id.changeMode);

        changeMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    txtInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else {
                    txtInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(FileFunctions.saveToFile(txtInput.getText().toString())){
                    Toast.makeText(MainActivity.this, "Saved to file.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Error when saving to file.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(v);
            }
        });
    }

    public void sendData(View view){
        String data = FileFunctions.ReadFile(MainActivity.this);
        Intent intent = new Intent(this, DisplayFileActivity.class);
        intent.putExtra(EXTRA_MESSAGE, data);
        startActivity(intent);
    }


}
