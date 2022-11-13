package com.shaikot.ielts.speaking.preparation.ui.rateUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shaikot.ielts.speaking.preparation.BuildConfig;
import com.shaikot.ielts.speaking.preparation.R;


public class RateUsFragment extends Fragment implements View.OnClickListener{

    private final ImageView[] imageViewStars = new ImageView[5];
    private ViewGroup linear_layout_RatingBar;
    private int star_number;
    private TextView text_view_submit;
    private ImageView imageViewRate;
    private TextView textViewDesc;

    public RateUsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_rate_us, container, false);

        this.text_view_submit = view.findViewById(R.id.text_view_submit);
        this.linear_layout_RatingBar = view.findViewById(R.id.linear_layout_RatingBar);
        this.text_view_submit.setOnClickListener(this);
        this.imageViewRate = view.findViewById(R.id.dialog_rating_icon);
        this.textViewDesc = view.findViewById(R.id.textViewRate);

        ImageView image_view_star_1 = view.findViewById(R.id.image_view_star_1);
        ImageView image_view_star_2 = view.findViewById(R.id.image_view_star_2);
        ImageView image_view_star_3 = view.findViewById(R.id.image_view_star_3);
        ImageView image_view_star_4 = view.findViewById(R.id.image_view_star_4);
        ImageView image_view_star_5 = view.findViewById(R.id.image_view_star_5);
        image_view_star_1.setOnClickListener(this);
        image_view_star_2.setOnClickListener(this);
        image_view_star_3.setOnClickListener(this);
        image_view_star_4.setOnClickListener(this);
        image_view_star_5.setOnClickListener(this);
        this.imageViewStars[0] = image_view_star_1;
        this.imageViewStars[1] = image_view_star_2;
        this.imageViewStars[2] = image_view_star_3;
        this.imageViewStars[3] = image_view_star_4;
        this.imageViewStars[4] = image_view_star_5;

        this.linear_layout_RatingBar.startAnimation(AnimationUtils.loadAnimation(requireContext(),R.anim.shake));
        this.star_number = 0;

        return view;
    }




    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.text_view_submit) {
            switch (id) {
                case R.id.image_view_star_1:
                    this.star_number = 1;
                    this.imageViewRate.setImageResource(R.drawable.ic_rate1_icon);
                    //this.textViewTitle.setText(getContext().getResources().getString(R.string.rating_title_1));
                    this.textViewDesc.setText(getContext().getResources().getString(R.string.rating_text_1));
                    setStarBar();
                    return;
                case R.id.image_view_star_2:
                    this.star_number = 2;
                    this.imageViewRate.setImageResource(R.drawable.ic_rate2_icon);
                    //this.textViewTitle.setText(getContext().getResources().getString(R.string.rating_title_1));
                    this.textViewDesc.setText(getContext().getResources().getString(R.string.rating_text_2));
                    setStarBar();
                    return;
                case R.id.image_view_star_3:
                    this.star_number = 3;
                    this.imageViewRate.setImageResource(R.drawable.ic_rate3_icon);
                    //this.textViewTitle.setText(getContext().getResources().getString(R.string.rating_title_1));
                    this.textViewDesc.setText(getContext().getResources().getString(R.string.rating_text_3));
                    setStarBar();
                    return;
                case R.id.image_view_star_4:
                    this.star_number = 4;
                    this.imageViewRate.setImageResource(R.drawable.ic_rate4_icon);
                    //this.textViewTitle.setText(getContext().getResources().getString(R.string.rating_title_2));
                    this.textViewDesc.setText(getContext().getResources().getString(R.string.rating_text_4));
                    setStarBar();
                    return;
                case R.id.image_view_star_5:
                    this.star_number = 5;
                    this.imageViewRate.setImageResource(R.drawable.ic_rate5_icon);
                    //this.textViewTitle.setText(getContext().getResources().getString(R.string.rating_title_2));
                    this.textViewDesc.setText(getContext().getResources().getString(R.string.rating_text_5));
                    setStarBar();
                    return;

                default:

            }
        } else if (this.star_number > 0) {
            requireContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)));
        } else {
            this.linear_layout_RatingBar.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.shake));
        }
    }



    /*
     * Set the Stars and perform the corresponding action.
     * */
    private void setStarBar() {
        for (int i = 0; i < this.imageViewStars.length; i++) {
            if (i < this.star_number) {
                this.imageViewStars[i].setImageResource(R.drawable.ic_round_star_on);
            } else {
                this.imageViewStars[i].setImageResource(R.drawable.ic_round_star);
            }
        }
    }

}