package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.example.jwmselldogs.consts.SharedPrefConsts;
import com.google.firebase.auth.FirebaseAuth;

public class SelectActivity extends AppCompatActivity {

   LottieAnimationView doctor,dog,item,upi;
   androidx.appcompat.widget.Toolbar toolbar;
   Button ChangePasswordButton,SignOut;
   private FirebaseAuth firebaseAuth;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_select);

      toolbar = findViewById(R.id.head_toolbar);
      setSupportActionBar(toolbar);

      firebaseAuth = FirebaseAuth.getInstance();

      ChangePasswordButton = findViewById(R.id.change_pass);
      SignOut = findViewById(R.id.signout);

      doctor = findViewById(R.id.add_doctor_view);
      dog = findViewById(R.id.add_dog_view);
      item = findViewById(R.id.add_item_view);
      upi = findViewById(R.id.upi_view);

      doctor.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),AddDoctorActivity.class));
         }
      });

      dog.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),SecondActivity.class));
         }
      });

      item.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),AddItemActivity.class));
         }
      });

      upi.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),UpiDiscountPlansActivity.class));
         }
      });

      ChangePasswordButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),ChangePasswordActivity.class));
         }
      });

      SignOut.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

            SharedPreferences preferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("login", SharedPrefConsts.NO_LOGIN);
            editor.apply();

            firebaseAuth.signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();


         }
      });


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


         case R.id.see_doc:
            // Add Code here



         case R.id.see_item:
            // Add code here



         case R.id.see_dogs:
            // Add code here




         default:
            return super.onOptionsItemSelected(item);

      }

   }

   @Override
   public void onBackPressed() {

      AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
      builder1.setMessage("Do you really want to exit ?").setCancelable(false)
              .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                    SelectActivity.super.onBackPressed();
                    finish();

                 }
              })

              .setNegativeButton("No", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                 }
              });
      AlertDialog alertDialog = builder1.create();
      alertDialog.show();
   }

}