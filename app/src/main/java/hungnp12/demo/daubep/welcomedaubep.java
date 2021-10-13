package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcomedaubep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomedaubep);
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
        }else{
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.CAMERA
            }, 6789);
        }
    }

    public void clickToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickToInputMaterial(View view) {
        Intent intent = new Intent(this, NhapCongThuc.class);
        startActivity(intent);
    }

    public void clickToScan(View view) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivity(intent);
    }
}