package com.example.asus.afinal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.Objects;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    TextView setText1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String privacyPolicy = getString(R.string.privacy);
        String termsAndConditions = getString(R.string.terms);
        setText1 =(TextView)findViewById(R.id.setText1);
        setText1.setText(
                String.format(
                        "By signing Up, you accept and agree to App's Privacy Policy and Terms of Use.",
                        termsAndConditions,
                        privacyPolicy)
        );
       setText1.setMovementMethod(LinkMovementMethod.getInstance());

        Pattern termsAndConditionsMatcher = Pattern.compile(termsAndConditions);
        Linkify.addLinks(setText1, termsAndConditionsMatcher, "terms:");

        Pattern privacyPolicyMatcher = Pattern.compile(privacyPolicy);
        Linkify.addLinks(setText1, privacyPolicyMatcher, "privacy:");
        setText1.setLinkTextColor(Color.parseColor("#3da0ee"));
    }
}
