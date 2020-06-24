package com.example.jwmselldogs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.example.jwmselldogs.consts.SharedPrefConsts;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

   FirebaseAuth firebaseAuth;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(R.layout.activity_main);

      /*firebaseAuth = FirebaseAuth.getInstance();

      firebaseAuth.createUserWithEmailAndPassword("fartmagazine@gmail.com","qwerty123")
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                       startActivity(new Intent(MainActivity.this,LoginActivity.class));
                       finish();
                    }

                    else{
                       Toast.makeText(getApplicationContext(),"Can't register",Toast.LENGTH_LONG).show();
                    }
                 }
              });*/


      SharedPreferences preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
      final int loginStatus = preferences.getInt("login", SharedPrefConsts.NO_LOGIN);

      new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {

            if(loginStatus == SharedPrefConsts.USER_LOGIN){
               startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }else {
               startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }

            finish();

         }
      }, 2500);

   }


}