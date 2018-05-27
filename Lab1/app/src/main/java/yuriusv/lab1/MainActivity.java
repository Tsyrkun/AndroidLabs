package yuriusv.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button _buttonOk, _buttonCancel;
    Spinner _spinnerMessageType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItems();
        initHandlers();
        initValues();
    }

    private void initItems() {
        _buttonOk = (Button)findViewById(R.id.buttonOk);
        _buttonCancel = (Button)findViewById(R.id.buttonCancel);

        _spinnerMessageType = (Spinner)findViewById(R.id.spinner);
    }

    private void initHandlers() {
        _buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClicked(true);
            }
        });

        _buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClicked(false);
            }
        });
    }

    private void initValues() {
        String spinnerValues[] = {"C#", "Java", "Python"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerValues);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        _spinnerMessageType.setAdapter(spinnerArrayAdapter);
    }

    private String getSelectedValue() {
        return _spinnerMessageType.getSelectedItem().toString();
    }

    private void handleButtonClicked(boolean isOk) {
        String textToShow = String.format("%s is %s", getSelectedValue(), isOk ? "Ok": "Canceled");
        Toast.makeText(MainActivity.this, textToShow, Toast.LENGTH_SHORT).show();
    }
}
