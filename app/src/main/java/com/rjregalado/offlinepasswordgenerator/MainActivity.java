package com.rjregalado.offlinepasswordgenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    private View.OnClickListener btnGenerateAndCopy_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            EditText txtGeneratedPassword = (EditText)findViewById(R.id.txtGeneratedPassword);
            EditText txtLength = (EditText)findViewById(R.id.txtLength);

            Switch boolPunctuations = (Switch)findViewById(R.id.chkPunctuations);
            Switch boolProgrammingCharacters = (Switch)findViewById(R.id.chkProgrammingCharacters);
            Switch boolSimilarCharacters = (Switch)findViewById(R.id.chkSimilarCharacters);
            Switch boolUpperCase = (Switch)findViewById(R.id.chkUpperCase);


            final generatePasswordHelper pass = new generatePasswordHelper();
            txtGeneratedPassword.setText( pass.generate(
                    Integer.valueOf(
                            String.valueOf(txtLength.getText())
                    )
                    , boolPunctuations.isChecked()
                    , boolProgrammingCharacters.isChecked()
                    , boolSimilarCharacters.isChecked()
                    , boolUpperCase.isChecked()


            )) ;


            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("generatedPassword", txtGeneratedPassword.getText());
            clipboard.setPrimaryClip(clip);

            Toast.makeText(getApplicationContext(), "Password Generated", Toast.LENGTH_LONG).show();

        }
    };

    private View.OnClickListener btnGenerate_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText txtGeneratedPassword = (EditText)findViewById(R.id.txtGeneratedPassword);
            EditText txtLength = (EditText)findViewById(R.id.txtLength);

            Switch boolPunctuations = (Switch)findViewById(R.id.chkPunctuations);
            Switch boolProgrammingCharacters = (Switch)findViewById(R.id.chkProgrammingCharacters);
            Switch boolSimilarCharacters = (Switch)findViewById(R.id.chkSimilarCharacters);
            Switch boolUpperCase = (Switch)findViewById(R.id.chkUpperCase);


            final generatePasswordHelper pass = new generatePasswordHelper();
            txtGeneratedPassword.setText( pass.generate(
                    Integer.valueOf(
                            String.valueOf(txtLength.getText())
                    )
                    , boolPunctuations.isChecked()
                    , boolProgrammingCharacters.isChecked()
                    , boolSimilarCharacters.isChecked()
                    , boolUpperCase.isChecked()


            )) ;
            Toast.makeText(getApplicationContext(), "Password Generated", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btngenerate = (Button)findViewById(R.id.btngenerate);
        Button btnGenerateAndCopy = (Button)findViewById(R.id.btnGenerateAndCopy);
        final EditText txtLength = (EditText)findViewById(R.id.txtLength);


        Switch boolPunctuations = (Switch)findViewById(R.id.chkPunctuations);
        Switch boolProgrammingCharacters = (Switch)findViewById(R.id.chkProgrammingCharacters);
        Switch boolSimilarCharacters = (Switch)findViewById(R.id.chkSimilarCharacters);
        Switch boolUpperCase = (Switch)findViewById(R.id.chkUpperCase);

        boolPunctuations.setChecked(true);
        boolProgrammingCharacters.setChecked(true);
        boolSimilarCharacters.setChecked(true);
        boolUpperCase.setChecked(true);


        txtLength.setText("12");
        btngenerate.setOnClickListener(btnGenerate_Click);
        btnGenerateAndCopy.setOnClickListener(btnGenerateAndCopy_Click);
    }
}
