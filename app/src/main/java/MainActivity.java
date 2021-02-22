import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt,passwordEt;
    private Button SignInButton;
    private TextView SignUp;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.email);
        passwordEt=findViewById(R.id.password);
        SignInButton=findViewById(R.id.login);
        progressDialog=new ProgressDialog(this);
        SignUp=findViewById(R.id.signUp);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void Login(){
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();
        if(TextUtils.isEmpty(email)){
            emailEt.setError("Enter your email");
            Toast.makeText(this, "please enter your email", Toast.LENGTH_LONG).show();

            return;
        }
        else if(TextUtils.isEmpty(password)){
            passwordEt.setError("Enter your password");
            Toast.makeText(this, "please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this,"Sign In fail!",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }
}
