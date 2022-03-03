package com.example.znolite.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.znolite.R;
import com.example.znolite.Tests.ActivityContentTests;
import com.example.znolite.model.CardTestItem;
import java.util.List;


public class AllTestAdapter extends RecyclerView.Adapter<AllTestAdapter.ViewHolder> {

    private LayoutInflater inflater;
    List<CardTestItem> cards;
    Context context;

    public AllTestAdapter(Context context, List<CardTestItem> cards) {
        this.cards = cards;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_test_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardTestItem c = cards.get(position);
        holder.titleCardTest.setText(c.getName());
        holder.percent.setText(c.getPercentCorrectAnswers());
        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityContentTests activityContentTests = new ActivityContentTests();
                Intent i = new Intent(context, ActivityContentTests.class);
                i.putExtra("key_name", holder.titleCardTest.getText());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);



            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleCardTest;
        CardView cd;
        TextView percent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleCardTest = itemView.findViewById(R.id.title_test_item);
            cd = itemView.findViewById(R.id.card_item_test);
            percent = itemView.findViewById(R.id.indificator_of_correct_answers);
        }
    }
}
