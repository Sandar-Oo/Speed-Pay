package com.cronocode.materialloginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class SignUp extends AppCompatActivity
{
    public EditText get_email,get_password;
    Button get_signup,back;

    FirebaseAuth firebaesAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        firebaesAuth= FirebaseAuth.getInstance();
        get_email=findViewById(R.id.inputEmail);
        get_password=findViewById(R.id.inputPassword);
        get_signup=findViewById(R.id.btnSignup);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,LogIn.class));
                finish();
            }
        });
       get_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = get_email.getText().toString();
                String paswd = get_password.getText().toString();
                if (emailID.isEmpty()) {
                    get_email.setError("Check your email");
                    get_email.requestFocus();
                } else if (paswd.isEmpty()) {
                    get_password.setError("Set your password");
                    get_password.requestFocus();
                } else if (emailID.isEmpty() && paswd.isEmpty()) {
                    Toast.makeText(SignUp.this, "Fields Empty!", Toast.LENGTH_LONG).show();
                } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                    firebaesAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUp.this, Custom_navi.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
