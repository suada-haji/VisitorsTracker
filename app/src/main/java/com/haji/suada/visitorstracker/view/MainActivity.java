package com.haji.suada.visitorstracker.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.haji.suada.visitorstracker.R;
import com.haji.suada.visitorstracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main );
        binding.startBtn.setOnClickListener(v -> startActivity(new Intent(
                MainActivity.this, RegisterVisitorActivity.class)));
    }
}
