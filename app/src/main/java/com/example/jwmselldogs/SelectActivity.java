package com.example.jwmselldogs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends AppCompatActivity {

   com.airbnb.lottie.LottieAnimationView doctor,dog,item,upi;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_select);

      doctor = findViewById(R.id.add_doctor_view);
      dog = findViewById(R.id.add_dog_view);
      item = findViewById(R.id.add_item_view);
      upi = findViewById(R.id.upi_view);

      doctor.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

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

         }
      });

      upi.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            startActivity(new Intent(getApplicationContext(),UpiDiscountPlansActivity.class));
         }
      });

   }
}