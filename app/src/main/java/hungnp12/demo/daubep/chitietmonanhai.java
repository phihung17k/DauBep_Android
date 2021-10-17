package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chitietmonanhai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietmonanhai);
    }
    public void clickToContacthai(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
    public void clickAbcdefg(View view) {
        finish();
    }
}