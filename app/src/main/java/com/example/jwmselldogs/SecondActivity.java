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

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.main_menu,menu);
      return super.onCreateOptionsMenu(menu);

   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {

      switch (item.getItemId()) {


         case R.id.upi_discount_plans:
            // Add Code here


         case R.id.change_pass:
            // Add code here

            startActivity(new Intent(getApplicationContext(), ChangePasswordActivity.class));
            break;


         case R.id.signout:
            // Add code here

            SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("login", SharedPrefConsts.NO_LOGIN);
            editor.apply();
            finish();

            firebaseAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();


         default:
            return super.onOptionsItemSelected(item);

      }

      return true;

   }

}