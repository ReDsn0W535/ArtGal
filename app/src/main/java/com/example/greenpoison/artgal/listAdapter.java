package com.example.greenpoison.artgal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;

import java.util.ArrayList;
import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.viewHolder> {



    List<Painting> paintings = null;
    public listAdapter(List<Painting> paintings){
        this.paintings = paintings;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //paintings = new ArrayList<Painting>();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder listViewHolder, int i) {
        Painting t = paintings.get(i);
        listViewHolder.name.setText(t.name);
        listViewHolder.url.setText(t.url);
    }

    @Override
    public int getItemCount() {
        return paintings.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView url;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameView);
            url = (TextView) itemView.findViewById(R.id.descrView);
        }
    }
}
