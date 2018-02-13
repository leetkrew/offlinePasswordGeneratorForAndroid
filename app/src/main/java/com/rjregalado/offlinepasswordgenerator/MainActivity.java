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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private void CopyToClipBoard(EditText txtGeneratedPassword) {

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("generatedPassword", txtGeneratedPassword.getText());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(), "Copied to Clipboard", Toast.LENGTH_SHORT).show();
    }


    private View.OnClickListener btnCopy_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            CopyToClipBoard ((EditText)findViewById(R.id.txtGeneratedPassword));
        }
    };


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

            CopyToClipBoard ((EditText)findViewById(R.id.txtGeneratedPassword));
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
            Toast.makeText(getApplicationContext(), "Password Generated", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btngenerate = (Button)findViewById(R.id.btngenerate);
        Button btnGenerateAndCopy = (Button)findViewById(R.id.btnGenerateAndCopy);
        Button btnCopy = (Button)findViewById(R.id.btnCopy);
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
        btnCopy.setOnClickListener(btnCopy_Click);

        MobileAds.initialize(this, "ca-app-pub-0525976082076681~1925831515");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }
}
