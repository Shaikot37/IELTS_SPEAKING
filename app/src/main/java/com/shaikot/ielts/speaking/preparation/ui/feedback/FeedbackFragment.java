package com.shaikot.ielts.speaking.preparation.ui.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.shaikot.ielts.speaking.preparation.R;
import com.shaikot.ielts.speaking.preparation.databinding.FragmentFeedbackBinding;

public class FeedbackFragment extends Fragment {

    private FragmentFeedbackBinding binding;
    private TextView title, submit;
    private EditText feedback;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_feedback, container, false);


        feedback = view.findViewById(R.id.feedback);
        title = view.findViewById(R.id.txt);
        submit = view.findViewById(R.id.send_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feedback.getText()==null || feedback.getText().length()<3){
                    title.setText("Please write something valid!");
                }
                else{

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"shaikot357@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "IELTS App Feedback");
                    i.putExtra(Intent.EXTRA_TEXT   , feedback.getText().toString());
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        title.setText("There are no email clients installed");
                    }
                    catch (Exception ex) {
                        title.setText("Network Error");
                    }
                    title.setText("We love to hear from you");

                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}