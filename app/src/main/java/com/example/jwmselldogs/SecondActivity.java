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

public class SecondActivity extends AppCompatActivity {

   androidx.appcompat.widget.Toolbar toolbar;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_second);

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

         case R.id.Update_UPI:
            // Add code here



         case R.id.discount:
            // Add Code here


         case R.id.sub_plans:
            // Add code here


         case R.id.change_pass:


         case R.id.signout:
            // Add code here


         default:
            return super.onOptionsItemSelected(item);

      }

   }

}