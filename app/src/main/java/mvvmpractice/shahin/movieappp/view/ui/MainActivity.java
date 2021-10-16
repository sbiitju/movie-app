package mvvmpractice.shahin.movieappp.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import mvvmpractice.shahin.movieappp.R;
import mvvmpractice.shahin.movieappp.service.model.Result;
import mvvmpractice.shahin.movieappp.view.adapter.MovieListAdapter;
import mvvmpractice.shahin.movieappp.viewmodel.MovieViewModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        model=new ViewModelProvider(this).get(MovieViewModel.class);
        model.getData().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                MovieListAdapter movieListAdapter=new MovieListAdapter(MainActivity.this,results);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(movieListAdapter);
            }
        });

    }
}