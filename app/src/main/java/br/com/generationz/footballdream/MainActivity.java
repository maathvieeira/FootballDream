package br.com.generationz.footballdream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvGame;
    private AdView mAdView;
    private ImageView imgCab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-2111681283486733~2482561171");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        imgCab = (ImageView) findViewById(R.id.imgCab);
        Picasso.get().load("http://fodr.tech/imgApp/cab.png").into(imgCab);

        lvGame = (ListView) findViewById(R.id.lvGame);

        lvGame.setOnItemClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fodr.tech/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GameService service = retrofit.create(GameService.class);

        Call<List<Game>> games = service.getGames();

        games.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                if(response.isSuccessful()){
                    List<Game> listaGames = response.body();

                    GameAdapter adapter = new GameAdapter(getApplicationContext(),
                            listaGames, "http://fodr.tech/imgP/");

                    lvGame.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Game game = (Game)adapterView.getItemAtPosition(i);
        //Toast.makeText(this, game.getTime1()+"X"+game.getTime2(), Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, DetalhesActivity.class);
        intent.putExtra("time1",game.getTime1());
        intent.putExtra("time2",game.getTime2());
        intent.putExtra("estadio", game.getEstadio());
        intent.putExtra("data", game.getData());
        intent.putExtra("campeonato", game.getIdCampeonato());
        intent.putExtra("canal", game.getIdCanal());

        startActivity(intent);
    }
}
