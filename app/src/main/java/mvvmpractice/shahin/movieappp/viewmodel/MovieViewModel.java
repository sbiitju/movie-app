package mvvmpractice.shahin.movieappp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import mvvmpractice.shahin.movieappp.service.model.Result;
import mvvmpractice.shahin.movieappp.service.reporsitory.MovieRepo;

public class MovieViewModel extends AndroidViewModel {
    public MovieRepo movieRepo;
    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepo=MovieRepo.getMovieRepoInstance(application);

    }

    public LiveData<List<Result>> getData()
    {
        return movieRepo.getTopratedMovieLis();
    }
}
