package br.com.generationz.footballdream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class DetalhesActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgTime1;
    private ImageView imgTime2;
    private ImageView imgCanal;
    private ImageView imgAc;
    private TextView txtCamp;
    private TextView txtEstadio;
    private TextView txtData;
    private Button btnVoltar;
    private AdView mAdView;
    private AdView mAdView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        MobileAds.initialize(this, "ca-app-pub-2111681283486733~2482561171");

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);

        imgTime1 = (ImageView) findViewById(R.id.imgTime1);
        imgTime2 = (ImageView) findViewById(R.id.imgTime2);
        imgCanal = (ImageView) findViewById(R.id.imgCanal);
        imgAc = (ImageView) findViewById(R.id.imgAc);
        txtCamp = (TextView) findViewById(R.id.txtCamp);
        txtEstadio = (TextView) findViewById(R.id.txtEstadio);
        txtData = (TextView) findViewById(R.id.txtDataDet);

        Intent intent = getIntent();
        String time1 = intent.getStringExtra("time1");
        String time2 = intent.getStringExtra("time2");
        String estadio = intent.getStringExtra("estadio");
        String data = intent.getStringExtra("data");
        String campeonato = intent.getStringExtra("campeonato");
        String canal = intent.getStringExtra("canal");

        Picasso.get().load("http://fodr.tech/imgG/"+time1+".png").into(imgTime1);
        Picasso.get().load("http://fodr.tech/imgG/"+time2+".png").into(imgTime2);
        Picasso.get().load("http://fodr.tech/imgCanais/"+canal+".png").into(imgCanal);
        Picasso.get().load("http://fodr.tech/imgApp/ac.png").into(imgAc);

        txtCamp.setText(campeonato);
        txtEstadio.setText(estadio);
        txtData.setText(data);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
