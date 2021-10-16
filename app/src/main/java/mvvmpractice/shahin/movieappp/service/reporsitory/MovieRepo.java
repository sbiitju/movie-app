package mvvmpractice.shahin.movieappp.service.reporsitory;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import mvvmpractice.shahin.movieappp.service.model.MovieModel;
import mvvmpractice.shahin.movieappp.service.model.Result;
import mvvmpractice.shahin.movieappp.service.network.ApiService;
import mvvmpractice.shahin.movieappp.service.network.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepo {
    private static Context mContext;
    public static MovieRepo movieRepo;
    private MovieModel movieModel;
    private MutableLiveData<List<Result>> results;
    public static MovieRepo getMovieRepoInstance(Context context){
        if(movieRepo==null){
            mContext=context;
            movieRepo=new MovieRepo();
        }
        return movieRepo;
    }

    public MutableLiveData<List<Result>> getTopratedMovieLis(){
        if(results==null){
            results=new MutableLiveData<>();
        }
        ApiService apiService= RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<MovieModel> call=apiService.getTopRatedMovie();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel=response.body();
                results.postValue(movieModel.getResults());
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
        return  results;
    }
}
