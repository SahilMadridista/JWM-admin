package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jwmselldogs.consts.SharedPrefConsts;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

   androidx.appcompat.widget.Toolbar toolbar;
   private FirebaseAuth firebaseAuth;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);

      firebaseAuth = FirebaseAuth.getInstance();

      toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

      Spinner spinner = findViewById(R.id.age_spinner);
      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
              R.array.ageArray, android.R.layout.simple_spinner_item);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinner.setAdapter(adapter);


   }

}