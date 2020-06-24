package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jwmselldogs.consts.SharedPrefConsts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

   /*private FirebaseAuth firebaseAuth;
   private FirebaseFirestore firestore;*/

   String email = "fartmagazine81@gmail.com";
   String password = "qwerty123";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(R.layout.activity_main);

      TextView app = findViewById(R.id.app_name_text);
      app.animate().alpha(1).setDuration(1000);

      /*firebaseAuth = FirebaseAuth.getInstance();
      firestore = FirebaseFirestore.getInstance();*/

      /*firebaseAuth.createUserWithEmailAndPassword(email,password)
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                       String userid = firebaseAuth.getCurrentUser().getUid();
                       DocumentReference documentReference = firestore.collection("Admin")
                               .document(userid);

                       Admin admin = new Admin();

                       admin.AdminEmail = email;
                       admin.UID = userid;

                       documentReference.set(admin)
                               .addOnSuccessListener(new OnSuccessListener<Void>() {
                                  @Override
                                  public void onSuccess(Void aVoid) {

                                     Toast.makeText(getApplicationContext(),"Admin aa gaya"
                                     ,Toast.LENGTH_LONG).show();

                                  }
                               });

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
      }, 2000);

   }


}