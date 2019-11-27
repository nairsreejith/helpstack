package centennial.ca.helpstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartPage extends Activity {

    FirebaseUser firebaseUser;

    protected void onStart() {
        super.onStart();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(StartPage.this, MainPage.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_page);

    }

    public void btnSignUpClicked(View view) {
        startActivity(new Intent(StartPage.this, RegisterPage.class));
    }

    public void btnLoginClick(View view) {
        startActivity(new Intent(StartPage.this, LoginPage.class));
    }
}
