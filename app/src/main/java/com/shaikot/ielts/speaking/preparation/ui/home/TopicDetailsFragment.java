package com.shaikot.ielts.speaking.preparation.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.shaikot.ielts.speaking.preparation.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class TopicDetailsFragment extends Fragment {

    private String[] questions, answers;
    RecyclerView recyclerView;
    List<QuestionAndAnswersModel> qaList = new ArrayList<>();
    private String topicName;

    private AdView mAdView;

    public TopicDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_topic_details, container, false);


        Bundle bundle = this.getArguments();
        if(bundle != null){
            topicName = bundle.getString("TopicName");
        }

        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(topicName);



        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //admob add
                MobileAds.initialize(requireContext(), new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                    }
                });


                mAdView = view.findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();

                mAdView.loadAd(adRequest);


                mAdView.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        // Code to be executed when an ad finishes loading.
                        super.onAdLoaded();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        // Code to be executed when an ad request fails.
                        //Toast.makeText(getContext(), "Add Loaded Failed", Toast.LENGTH_SHORT).show();

                        super.onAdFailedToLoad(adError);
                        mAdView.loadAd(adRequest);
                    }

                    @Override
                    public void onAdOpened() {
                        // Code to be executed when an ad opens an overlay that
                        // covers the screen.
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdClicked() {
                        // Code to be executed when the user clicks on an ad.
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the user is about to return
                        // to the app after tapping on an ad.
                        super.onAdClosed();

                    }
                });

            }
        }, 10);





        if(topicName.equals("Accommodation")){
            questions = getResources().getStringArray(R.array.accommodation_questions);
            answers = getResources().getStringArray(R.array.accommodation_answers);
        }
        if(topicName.equals("Art")){
            questions = getResources().getStringArray(R.array.art_questions);
            answers = getResources().getStringArray(R.array.art_answers);
        }
        if(topicName.equals("Birthdays")){
            questions = getResources().getStringArray(R.array.birthdays_questions);
            answers = getResources().getStringArray(R.array.birthdays_answers);
        }
        if(topicName.equals("Books")){
            questions = getResources().getStringArray(R.array.books_questions);
            answers = getResources().getStringArray(R.array.books_answers);
        }
        if(topicName.equals("Celebrity")){
            questions = getResources().getStringArray(R.array.celebrity_questions);
            answers = getResources().getStringArray(R.array.celebrity_answers);
        }
        if(topicName.equals("Clothes & Fashion")){
            questions = getResources().getStringArray(R.array.clothesAndFashion_questions);
            answers = getResources().getStringArray(R.array.clothesAndFashion_answers);
        }
        if(topicName.equals("Computer")){
            questions = getResources().getStringArray(R.array.computer_questions);
            answers = getResources().getStringArray(R.array.computer_answers);
        }
        if(topicName.equals("Environment")){
            questions = getResources().getStringArray(R.array.environment_questions);
            answers = getResources().getStringArray(R.array.environment_answers);
        }
        if(topicName.equals("Family")){
            questions = getResources().getStringArray(R.array.family_questions);
            answers = getResources().getStringArray(R.array.family_answers);
        }
        if(topicName.equals("Food")){
            questions = getResources().getStringArray(R.array.food_questions);
            answers = getResources().getStringArray(R.array.food_answers);
        }
        if(topicName.equals("Friends")){
            questions = getResources().getStringArray(R.array.friends_questions);
            answers = getResources().getStringArray(R.array.friends_answers);
        }
        if(topicName.equals("Gift")){
            questions = getResources().getStringArray(R.array.gift_questions);
            answers = getResources().getStringArray(R.array.gift_answers);
        }
        if(topicName.equals("Health")){
            questions = getResources().getStringArray(R.array.health_questions);
            answers = getResources().getStringArray(R.array.health_answers);
        }
        if(topicName.equals("High School")){
            questions = getResources().getStringArray(R.array.highSchool_questions);
            answers = getResources().getStringArray(R.array.highSchool_answers);
        }
        if(topicName.equals("Hobby")){
            questions = getResources().getStringArray(R.array.hobby_questions);
            answers = getResources().getStringArray(R.array.hobby_answers);
        }
        if(topicName.equals("Hometown")){
            questions = getResources().getStringArray(R.array.hometown_questions);
            answers = getResources().getStringArray(R.array.hometown_answers);
        }
        if(topicName.equals("Internet")){
            questions = getResources().getStringArray(R.array.internet_questions);
            answers = getResources().getStringArray(R.array.internet_answers);
        }
        if(topicName.equals("Lifestyle")){
            questions = getResources().getStringArray(R.array.lifestyle_questions);
            answers = getResources().getStringArray(R.array.lifestyle_answers);
        }
        if(topicName.equals("Music")){
            questions = getResources().getStringArray(R.array.music_questions);
            answers = getResources().getStringArray(R.array.music_answers);
        }
        if(topicName.equals("Newspaper & Magazine")){
            questions = getResources().getStringArray(R.array.newspaperAndMagazine_questions);
            answers = getResources().getStringArray(R.array.newspaperAndMagazine_answers);
        }
        if(topicName.equals("Noise")){
            questions = getResources().getStringArray(R.array.noise_questions);
            answers = getResources().getStringArray(R.array.noise_answers);
        }
        if(topicName.equals("Patience")){
            questions = getResources().getStringArray(R.array.patience_questions);
            answers = getResources().getStringArray(R.array.patience_answers);
        }
        if(topicName.equals("Photography")){
            questions = getResources().getStringArray(R.array.photography_questions);
            answers = getResources().getStringArray(R.array.photography_answers);
        }
        if(topicName.equals("Sports")){
            questions = getResources().getStringArray(R.array.sports_questions);
            answers = getResources().getStringArray(R.array.sports_answers);
        }
        if(topicName.equals("Study")){
            questions = getResources().getStringArray(R.array.study_questions);
            answers = getResources().getStringArray(R.array.study_answers);
        }
        if(topicName.equals("Transportation")){
            questions = getResources().getStringArray(R.array.transportation_questions);
            answers = getResources().getStringArray(R.array.transportation_answers);
        }
        if(topicName.equals("Travel")){
            questions = getResources().getStringArray(R.array.travel_questions);
            answers = getResources().getStringArray(R.array.travel_answers);
        }
        if(topicName.equals("TV & Movies")){
            questions = getResources().getStringArray(R.array.tvAndMovies_questions);
            answers = getResources().getStringArray(R.array.tvAndMovies_answers);
        }
        if(topicName.equals("Weather")){
            questions = getResources().getStringArray(R.array.weather_questions);
            answers = getResources().getStringArray(R.array.weather_answers);
        }
        if(topicName.equals("Work")){
            questions = getResources().getStringArray(R.array.work_questions);
            answers = getResources().getStringArray(R.array.work_answers);
        }









        for(int i = 0; i< answers.length; i++){
            qaList.add(new QuestionAndAnswersModel(questions[i], answers[i],false));
        }

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        final RecyclerAdapter adapter = new RecyclerAdapter(getContext(), getActivity(),qaList);
        recyclerView.setAdapter(adapter);



        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.home, new HomeFragment()).commit();
                    Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(R.string.menu_home);
                    return true;
                }
                return false;
            }
        });






        return view;
    }


}





class QuestionAndAnswersModel {
    String question = "";
    String answer = "";
    Boolean expand = false;

    public QuestionAndAnswersModel(String question, String answer, Boolean expand) {
        this.question = question;
        this.answer = answer;
        this.expand = expand;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }
}