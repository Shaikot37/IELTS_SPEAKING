package com.shaikot.ielts.speaking.preparation.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.shaikot.ielts.speaking.preparation.R;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    Context context;
    Activity activity;
    List<QuestionAndAnswersModel> qAnsList;

    public RecyclerAdapter(Context context, Activity activity, List<QuestionAndAnswersModel> qaList) {
        this.context = context;
        this.activity = activity;
        this.qAnsList = qaList;
    }


    @Override
    public RecyclerAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_topic_single, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.viewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.question.setText(qAnsList.get(position).getQuestion());
        holder.answer.setText(qAnsList.get(position).getAnswer());

        if (qAnsList.get(position).expand) {
            holder.expandedView.setVisibility(View.VISIBLE);
            holder.dropdownSymbol.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_up_24);
        } else {
            holder.expandedView.setVisibility(View.GONE);
            holder.dropdownSymbol.setBackgroundResource(R.drawable.ic_baseline_arrow_drop_down_24);
        }

        holder.questionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qAnsList.get(position).expand = !qAnsList.get(position).expand;
                notifyDataSetChanged();
            }
        });

    }


    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView question, answer, dropdownSymbol;
        RelativeLayout expandedView;
        LinearLayout questionView;

        public viewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            answer = itemView.findViewById(R.id.answer);
            dropdownSymbol = itemView.findViewById(R.id.dropdown_symbol);
            expandedView = itemView.findViewById(R.id.expanded_view);
            questionView = itemView.findViewById(R.id.linear);

        }
    }


    @Override
    public int getItemCount() {
        return qAnsList.size();
    }

}








