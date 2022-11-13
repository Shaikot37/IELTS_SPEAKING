package com.shaikot.ielts.speaking.preparation.ui.share;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shaikot.ielts.speaking.preparation.R;


public class ShareFragment extends Fragment {

    TextView msg;

    public ShareFragment() {
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
        View view = inflater.inflate(R.layout.fragment_share, container, false);

        String temp = getResources().getString(R.string.share_msg)+" \"https://play.google.com/store/apps/details?id=com.shaikot.ielts.speaking.preparation\" ";
        msg = view.findViewById(R.id.share_msg);
        msg.setText(temp);

        view.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareMessage();
            }
        });

        return view;
    }

    private void shareMessage(){
        StringBuilder msg = new StringBuilder();
        msg.append(getString(R.string.share_msg));
        msg.append("\n");
        msg.append("https://play.google.com/store/apps/details?id=com.shaikot.ielts.speaking.preparation");
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg.toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}