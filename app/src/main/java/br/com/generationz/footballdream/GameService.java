package br.com.generationz.footballdream;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GameService {
    @GET("lista_game.php")
    Call<List<Game>> getGames();

}
