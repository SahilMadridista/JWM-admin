package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jwmselldogs.consts.SharedPrefConsts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

   FirebaseAuth firebaseAuth;
   ProgressDialog progressDialog;
   EditText EmailEditText, PasswordEditText;
   CheckBox CheckBX;
   Button LoginBTN;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

      firebaseAuth = FirebaseAuth.getInstance();

      EmailEditText = findViewById(R.id.email_et);
      PasswordEditText = findViewById(R.id.pass_et);
      CheckBX = findViewById(R.id.chk_box);
      LoginBTN = findViewById(R.id.login_btn);

      CheckBX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
               PasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
               PasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
         }
      });

      LoginBTN.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            AdminLogin();
         }
      });

      progressDialog = new ProgressDialog(this);
      progressDialog.setCancelable(false);
      progressDialog.setMessage("Logging in...");


   }

   private void AdminLogin() {

      String email = EmailEditText.getText().toString().trim();
      String pass = PasswordEditText.getText().toString().trim();

      if(email.isEmpty()){
         EmailEditText.setError("Please enter your email");
         EmailEditText.requestFocus();
         return;
      }

      if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
         EmailEditText.setError("Enter a valid email address");
         EmailEditText.requestFocus();
         return;
      }

      if(pass.isEmpty()){
         PasswordEditText.setError("Please enter password");
         PasswordEditText.requestFocus();
         return;
      }

      if(pass.length()<6){
         PasswordEditText.setError("Password must be at least 6 characters long");
         PasswordEditText.requestFocus();
         return;
      }

      progressDialog.show();

      firebaseAuth.signInWithEmailAndPassword(email,pass)
              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                       SharedPreferences preferences = getApplicationContext()
                               .getSharedPreferences("MyPref", MODE_PRIVATE);
                       SharedPreferences.Editor editor = preferences.edit();
                       editor.putInt("login", SharedPrefConsts.USER_LOGIN);
                       editor.apply();


                       startActivity(new Intent(getApplicationContext(),SelectActivity.class));
                       finish();
                       progressDialog.dismiss();
                       Toast.makeText(LoginActivity.this,"Admin logged in",
                               Toast.LENGTH_LONG).show();

                    }

                    else{

                       progressDialog.dismiss();
                       Toast.makeText(LoginActivity.this,"Some error occurred. Please check details",
                               Toast.LENGTH_LONG).show();

                    }

                 }
              });


   }

}