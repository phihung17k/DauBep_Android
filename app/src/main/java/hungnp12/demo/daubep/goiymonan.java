package hungnp12.demo.daubep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class goiymonan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goiymonan);
    }

    public void chitietnauan(View view) {
        Intent intent = new Intent(this , ChiTietMonAnActivity.class);
        startActivity(intent);
    }

    public void clickToContact(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }


    public void chitietnauanhai(View view) {
        Intent intent = new Intent(this , FoodDetailActivity.class);
        startActivity(intent);
    }
    public void chitietnauanba(View view) {
        Intent intent = new Intent(this , chitietnauanba.class);
        startActivity(intent);
    }

    public void chitietnauanbon(View view) {
        Intent intent = new Intent(this , chitietnauanbon.class);
        startActivity(intent);
    }
    public void clickAbcde(View view) {
        finish();
    }

    public void clickToHome(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}