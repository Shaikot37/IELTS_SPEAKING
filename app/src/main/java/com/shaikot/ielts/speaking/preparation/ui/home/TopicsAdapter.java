package com.shaikot.ielts.speaking.preparation.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.shaikot.ielts.speaking.preparation.MainActivity;
import com.shaikot.ielts.speaking.preparation.R;

import java.util.Objects;


public class TopicsAdapter extends RecyclerView.Adapter<TopicsAdapter.viewHolder> {

    Context context;
    Activity activity;
    String[] topicsList;
    private InterstitialAd interstitialAd1;

    public TopicsAdapter(Context context, Activity activity, String[] topicList) {
        this.context = context;
        this.activity = activity;
        topicsList = topicList;
    }


    @Override
    public TopicsAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.topic_list_row, viewGroup, false);
        loadInterstitialAd();
        return new viewHolder(view);
    }



    @Override
    public void onBindViewHolder(final TopicsAdapter.viewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.name.setText(topicsList[position]);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (interstitialAd1 != null) {
                    interstitialAd1.show(activity);
                }

                Bundle bundle = new Bundle();
                bundle.putString("TopicName",topicsList[position]);
                TopicDetailsFragment fragment = new TopicDetailsFragment();
                fragment.setArguments(bundle);
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.home, fragment).addToBackStack(null).commit();

            }
        });


    }


    @Override
    public int getItemCount() {
        return topicsList.length;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public viewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);


        }
    }



    public void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(
                activity,
                activity.getString(R.string.admob_interstitial_id),
                adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialAd1 = interstitialAd;
                        //Toast.makeText(requireActivity(), "onAdLoaded()", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        interstitialAd1 = null;
                                        Log.d("TAG", "The ad was dismissed.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        interstitialAd1 = null;
                                        Log.d("TAG", "The ad failed to show.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        // Called when fullscreen content is shown.
                                        Log.d("TAG", "The ad was shown.");
                                    }
                                });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        interstitialAd1 = null;

                        //Toast.makeText(requireActivity(), "onAdFailedToLoad", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}