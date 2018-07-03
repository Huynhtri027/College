package eslam.example.com.college;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;

public class StartActivity extends AppCompatActivity {

    ImageView logoImage;
    Button loginButton;

    public static final String LOGIN_EXTRA = "login_extra";
    public static final String LOGIN_STUDENT_EXTRA = "student";
    public static final String LOGIN_CONTROL_EXTRA = "control";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_start);
        logoImage = findViewById(R.id.logo_image);
    }

    public void studentButton(View view) {
        Intent intent = new Intent(this,LogInActivity.class);
        intent.putExtra(LOGIN_EXTRA,LOGIN_STUDENT_EXTRA);
        startActivity(intent,anim().toBundle());
    }

    public void controlButton(View view) {
        Intent intent = new Intent(this,LogInActivity.class);

        startActivity(intent,anim().toBundle());
    }

    public ActivityOptions anim(){
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(logoImage,"imageTransition");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
        return options;
    }

}
