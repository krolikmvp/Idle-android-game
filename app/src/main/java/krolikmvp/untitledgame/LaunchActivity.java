package krolikmvp.untitledgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.logo);
        mImageView.setImageResource(R.drawable.testlogo);
        Thread thread = new Thread(){

          public void run(){

              try {
                  sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              finally{
                  Intent intent = new Intent("android.intent.action.MAIN_MENU");
                  startActivity(intent);
              }

          }

        };
        thread.start();
    }
}
