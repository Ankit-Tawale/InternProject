package com.example.asus.afinal;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.Objects;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    TextView setText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setText = (TextView) findViewById(R.id.setText2);
        String privacyPolicy = getString(R.string.privacy);
        String termsAndConditions = getString(R.string.terms);
        setText.setText(
                String.format(
                        "By signing Up, you accept and agree to App's Privacy Policy and Terms of Use.",
                        termsAndConditions,
                        privacyPolicy)
        );
        setText.setMovementMethod(LinkMovementMethod.getInstance());

        Pattern termsAndConditionsMatcher = Pattern.compile(termsAndConditions);
        Linkify.addLinks(setText, termsAndConditionsMatcher, "terms:");

        Pattern privacyPolicyMatcher = Pattern.compile(privacyPolicy);
        Linkify.addLinks(setText, privacyPolicyMatcher, "privacy:");
        setText.setLinkTextColor(Color.parseColor("#3da0ee"));
    }
}
