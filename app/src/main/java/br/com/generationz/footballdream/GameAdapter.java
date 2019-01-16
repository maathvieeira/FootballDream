package br.com.generationz.footballdream;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class GameAdapter extends BaseAdapter {
    private Context ctx;
    private List<Game> games;
    private String pathFotos;

    public GameAdapter(Context ctx, List<Game> games, String pathFotos) {
        this.ctx = ctx;
        this.games = games;
        this.pathFotos = pathFotos;
    }

    @Override
    public int getCount() {
        return games.size();
    }

    @Override
    public Object getItem(int i) {
        return games.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Game game = games.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_game, null);

        //tela inicial
        ImageView imgTime1 = (ImageView) linha.findViewById(R.id.imgTimeUm);
        ImageView imgTime2 = (ImageView) linha.findViewById(R.id.imgTimeDois);
        TextView txtTime1 = (TextView) linha.findViewById(R.id.timeUm);
        TextView txtTime2 = (TextView) linha.findViewById(R.id.timeDois);
        TextView txtCamp = (TextView) linha.findViewById(R.id.nomeCamp);
        TextView txtData = (TextView) linha.findViewById(R.id.txtData);

        //tela inicial
        Picasso.get().load(pathFotos+game.getTime1()+".png").into(imgTime1);
        Picasso.get().load(pathFotos+game.getTime2()+".png").into(imgTime2);
        txtTime1.setText(game.time1);
        txtTime2.setText(game.time2);
        txtCamp.setText(game.idCampeonato);
        txtData.setText(game.data);


        return linha;
    }
}
