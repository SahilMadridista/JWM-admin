package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePasswordActivity extends AppCompatActivity {

   androidx.appcompat.widget.Toolbar toolbar;
   EditText NewPass,ConfirmNewPass;
   Button ChangePassword;
   private FirebaseAuth firebaseAuth;
   ProgressDialog dialog;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_change_password);

      firebaseAuth = FirebaseAuth.getInstance();

      NewPass = findViewById(R.id.new_pass_et);
      ConfirmNewPass = findViewById(R.id.cnf_new_pass_et);
      ChangePassword = findViewById(R.id.change_pass_btn);

      dialog = new ProgressDialog(this);
      dialog.setCancelable(false);
      dialog.setMessage("Changing password...");

      toolbar = findViewById(R.id.change_pass_toolbar);
      setSupportActionBar(toolbar);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      ChangePassword.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            PasswordChange();
         }
      });


   }

   private void PasswordChange() {

      String newpass = NewPass.getText().toString().trim();
      String cnfnewpass = ConfirmNewPass.getText().toString().trim();

      if(newpass.isEmpty()){
         NewPass.setError("Please fill this");
         NewPass.requestFocus();
         return;
      }

      if(newpass.length()<6){
         NewPass.setError("Password must be at least 6 characters long");
         NewPass.requestFocus();
         return;
      }

      if(cnfnewpass.isEmpty()){
         ConfirmNewPass.setError("Please fill this");
         ConfirmNewPass.requestFocus();
         return;
      }

      if(!newpass.equals(cnfnewpass)){
         ConfirmNewPass.setError("Password doesn't match");
         ConfirmNewPass.requestFocus();
         return;
      }

      dialog.show();

      FirebaseUser user = firebaseAuth.getCurrentUser();

      user.updatePassword(newpass)
              .addOnCompleteListener(new OnCompleteListener<Void>() {
                 @Override
                 public void onComplete(@NonNull Task<Void> task) {

                    if(task.isSuccessful()){
                       dialog.dismiss();
                       Toast.makeText(getApplicationContext(),"Password changed",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                       finish();
                    }

                    else{
                       dialog.dismiss();
                       Toast.makeText(getApplicationContext(),"Can't change password right now. Please try again",Toast.LENGTH_LONG).show();

                    }

                 }
              });

   }
}