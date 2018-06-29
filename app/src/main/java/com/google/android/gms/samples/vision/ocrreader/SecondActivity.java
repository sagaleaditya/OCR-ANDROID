package com.google.android.gms.samples.vision.ocrreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.samples.vision.ocrreader.OcrDetectorProcessor;
import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;

import com.google.android.gms.samples.vision.ocrreader.ui.camera.GraphicOverlay;
import com.google.android.gms.vision.text.TextBlock;

import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {
    ////////////////////

    ////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        /////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("text_received");


        //TextView textView2 = (TextView) findViewById(R.id.numberid);
        TextView textstate = (TextView) findViewById(R.id.Stateview);
        TextView textdept = (TextView) findViewById(R.id.Department);
        TextView texttypeoftrans = (TextView) findViewById(R.id.typeoftransporter);
        TextView texttype = (TextView) findViewById(R.id.type);
        TextView textnumber = (TextView) findViewById(R.id.number);
        TextView textexpiry = (TextView) findViewById(R.id.expiry);

        GraphicOverlay<OcrGraphic> graphicOverlay;
        graphicOverlay = (GraphicOverlay<OcrGraphic>) findViewById(R.id.graphicOverlay);
        OcrDetectorProcessor OCR = new OcrDetectorProcessor(graphicOverlay);
        message = OCR.textrec;
        String lines[] = message.split("\\r?\\n");
        int l = lines.length;

        textstate.setText("State: " + lines[l-6]);
        textdept.setText("Department: " + lines[l-5]);
        texttypeoftrans.setText("Transporter: " + lines[l-4]);
        texttype.setText("Type: " + lines[l-3]);
        textnumber.setText("Number: "+ lines[l-2]);
        textexpiry.setText("Expiration Date" + lines[l-1]);
        //textView1.setText("State: " + lines[l-5]);
        ////////////////////////////////////
        configureBackButton();
    }

    private void configureBackButton(){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }
}
