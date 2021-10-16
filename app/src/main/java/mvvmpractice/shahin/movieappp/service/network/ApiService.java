package mvvmpractice.shahin.movieappp.service.network;

import mvvmpractice.shahin.movieappp.service.model.MovieModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/3/movie/top_rated?api_key=c6215ac2504f93954eb05efa4c2527bb")
    Call<MovieModel> getTopRatedMovie();

}
