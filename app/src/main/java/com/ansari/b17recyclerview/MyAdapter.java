package com.ansari.b17recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Movie> movieList;

    public MyAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2,parent,false);

        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.genereTextView.setText(movie.getGenere());
        holder.yearTextView.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView,genereTextView,yearTextView;
        public MyViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewTitle);
            genereTextView = itemView.findViewById(R.id.textViewGenere);
            yearTextView = itemView.findViewById(R.id.textViewYear);
        }
    }
}
