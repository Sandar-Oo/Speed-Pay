package com.cronocode.materialloginpage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.text.BreakIterator;

public class LogIn extends AppCompatActivity {
    public EditText log_email, log_pwd;
    Button btn_log;
    TextView signup;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        log_email = findViewById(R.id.inputEmail);
        log_pwd = findViewById(R.id.inputPassword);
        signup = findViewById(R.id.gotoRegister);
        btn_log = findViewById(R.id.btnLogin);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(LogIn.this, "User Sign in ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LogIn.this, Custom_navi.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LogIn.this, "Sign in to continue ", Toast.LENGTH_SHORT).show();
                }
            }
        };
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LogIn.this,SignUp.class);
                startActivity(i);
                finish();
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  userEmail=log_email.getText().toString();
                String userPwd=log_pwd.getText().toString();
                if(userEmail.isEmpty()){
                    log_email.setError("Check your email ");
                    log_email.requestFocus();
                }else if(userPwd.isEmpty()){
                    log_pwd.setError("Enter Password!");
                    log_pwd.requestFocus();
                }else if(userEmail.isEmpty() && userPwd.isEmpty()){
                    Toast.makeText(LogIn.this,"Fields Empty!",Toast.LENGTH_SHORT).show();
                }else if(!(userEmail.isEmpty()&& userPwd.isEmpty())){
                    firebaseAuth.signInWithEmailAndPassword(userEmail,userPwd).addOnCompleteListener(
                           LogIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(LogIn.this,"Not successful",Toast.LENGTH_SHORT).show();

                                    }else{
                                        startActivity(new Intent(LogIn.this,Custom_navi.class));
                                    }
                                }
                            });
                }else{
                    Toast.makeText(LogIn.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected  void onStart() {

        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }


  /* private static final String TAG = "LogIn";
    public FirebaseAuth mAuth;
    EditText emailTextInput;
    EditText passwordTextInput;
    Button signInButton;
    Text forgotPassword;
    Text sendVerify;
    Text signup;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextInput = findViewById(R.id.inputEmail);
        passwordTextInput = findViewById(R.id.inputPassword);
        signInButton = findViewById(R.id.btnLogin);
        forgotPassword = findViewById(R.id.forgotPassword);
        sendVerify= findViewById(R.id.verify);
        signup=findViewById(R.id.gotoRegister);




        mAuth = FirebaseAuth.getInstance();


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (emailTextInput.getText().toString().contentEquals("")) {


                  //  errorView.setText("Email cant be empty");


                } else if (passwordTextInput.getText().toString().contentEquals("")) {

                   // errorView.setText("Password cant be empty");

                } else {


                    mAuth.signInWithEmailAndPassword(emailTextInput.getText().toString(), passwordTextInput.getText().toString())
                            .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        if (user != null) {
                                            if (user.isEmailVerified()) {


                                                System.out.println("Email Verified : " + user.isEmailVerified());
                                                Intent HomeActivity = new Intent(LogIn.this, Custom_navi.class);
                                                setResult(RESULT_OK, null);
                                                startActivity(HomeActivity);
                                                LogIn.this.finish();


                                            } else {

                                                ((View) sendVerify).setVisibility(View.VISIBLE);
                                            //    errorView.setText("Please Verify your EmailID and SignIn");

                                            }
                                        }

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(LogIn.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        if (task.getException() != null) {
                                           // errorView.setText(task.getException().getMessage());
                                        }

                                    }

                                }
                            });


                }


            }
        });






    }*/
}



