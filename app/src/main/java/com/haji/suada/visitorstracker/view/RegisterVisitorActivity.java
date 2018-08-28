package com.haji.suada.visitorstracker.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haji.suada.visitorstracker.R;
import com.haji.suada.visitorstracker.databinding.ActivityRegisterVisitorBinding;
import com.haji.suada.visitorstracker.model.data.Visitor;
import com.haji.suada.visitorstracker.viewmodel.VisitorViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class RegisterVisitorActivity extends DaggerAppCompatActivity {

    private EditText visitorName;
    private EditText phoneNumber;
    private EditText visitingWho;
    private  Button button;

    private VisitorViewModel visitorViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private String visitor_name = "";
    private String phone_number = "";
    private String nameRegex;
    private String numberRegex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterVisitorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_register_visitor);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
        visitorViewModel = ViewModelProviders.of(this, viewModelFactory).get(VisitorViewModel.class);
        visitorName = binding.visitorNameEt;
        phoneNumber = binding.phoneNumberEt;
        visitingWho = binding.visitingWhoEt;

        button = binding.submitBtn;
        nameRegex =  getString(R.string.name_regex);
        numberRegex = getString(R.string.number_regex_pattern);
        init();

        button.setOnClickListener(v -> {
            if (button.isActivated()) {
                Visitor visitor = new Visitor();
                visitor.setVisitorName(visitorName.getText().toString());
                visitor.setPhoneNumber(phoneNumber.getText().toString());
                visitor.setVisitingWho(visitingWho.getText().toString());
                visitor.setVisitedDate(getCurrentTime());

                visitorViewModel.insert(visitor);
                finish();

            } else {
                validateVisitorname(visitor_name, phone_number);
            }
        });
    }

    public void init() {
        visitorName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                visitor_name = s.toString();

                if (visitor_name.matches(nameRegex) && visitor_name.length() <= 36 && phone_number.matches(numberRegex) && phone_number.length() <= 12) {
                    button.setActivated(true);
                } else {
                    button.setActivated(false);
                }
            }
        });

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                phone_number = s.toString();
                if (visitor_name.matches(nameRegex) && visitor_name.length() <= 36 && phone_number.matches(numberRegex) && phone_number.length() <= 12) {
                    button.setActivated(true);
                } else {
                    button.setActivated(false);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.getDefault());
        return sdf.format(new Date());
    }

    private void validateVisitorname(String visitorName, String phoneNumber) {
        if (TextUtils.isEmpty(visitorName)) {
            Toast.makeText(this, R.string.empty_visitor_name, Toast.LENGTH_SHORT).show();
        }
        if (visitorName.length() > 30) {
            Toast.makeText(this, R.string.visitor_name_length_long, Toast.LENGTH_SHORT).show();
        }
        if (!visitorName.matches(nameRegex)) {
            Toast.makeText(this, R.string.visitor_name_not_matching, Toast.LENGTH_SHORT).show();
        }
        if (!phoneNumber.matches(numberRegex)) {
            Toast.makeText(this, R.string.phone_number_not_marching_pattern, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
