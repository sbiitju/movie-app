package mvvmpractice.shahin.movieappp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mvvmpractice.shahin.movieappp.R;
import mvvmpractice.shahin.movieappp.service.model.Result;
import mvvmpractice.shahin.movieappp.viewmodel.MyVIewHolder;

public class MovieListAdapter extends RecyclerView.Adapter<MyVIewHolder> {
    private Context mContext;
    private List<Result> resultList;

    public MovieListAdapter(Context mContext, List<Result> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public MyVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.card,null);
        return new MyVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVIewHolder holder, int position) {
        holder.textView.setText(resultList.get(position).getTitle());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/original/"+resultList.get(position).getPosterPath()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }
}
