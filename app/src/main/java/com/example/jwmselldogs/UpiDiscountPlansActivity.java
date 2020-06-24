package com.example.jwmselldogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpiDiscountPlansActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firestore;
    EditText upiID,Discount, OneET, SixET, TwelveET;
    String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi_discount_plans);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        upiID = findViewById(R.id.upi_et);
        Discount = findViewById(R.id.discount_et);

        OneET = findViewById(R.id.one_month);
        SixET = findViewById(R.id.six_months);
        TwelveET = findViewById(R.id.one_year);

        assert firebaseAuth.getCurrentUser()!=null;

        UserID = firebaseAuth.getCurrentUser().getUid();

        final DocumentReference documentReference = firestore.collection("Admin")
                .document(UserID);

        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    assert documentSnapshot != null;
                    upiID.setText(documentSnapshot.getString("Upi"));
                    Discount.setText(documentSnapshot.getString("DiscountPercentage"));
                    OneET.setText(documentSnapshot.getString("OneMonthPrice"));
                    SixET.setText(documentSnapshot.getString("SixMonthPrice"));
                    TwelveET.setText(documentSnapshot.getString("TwelveMonthsPrice"));

                    Toast.makeText(getApplicationContext(),"Current data loaded",Toast.LENGTH_LONG)
                            .show();

                }

                else{
                    Toast.makeText(getApplicationContext(),"Data load error",Toast.LENGTH_LONG)
                            .show();
                }

            }

        });

    }

}