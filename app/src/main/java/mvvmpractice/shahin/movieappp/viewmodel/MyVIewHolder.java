package mvvmpractice.shahin.movieappp.viewmodel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import mvvmpractice.shahin.movieappp.R;

public class MyVIewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public MyVIewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.mimage);
        textView=itemView.findViewById(R.id.movieName);
    }
}
