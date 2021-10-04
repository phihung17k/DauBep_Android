package hungnp12.demo.daubep;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new HomeFragment()).commit();

        fabScan = findViewById(R.id.fabScan);
        fabScan.setOnClickListener(fabListen);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_community:
                            selectedFragment = new CommunityFragment();
                            break;
                        default:
                            selectedFragment = new HomeFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit();
                    return true;
                }
            };

    // for forum searching
    public void ClickToSearch(View view) {
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    public void clicktoCongThuc(View view) {
        Intent intent = new Intent(this, CongThucNauAnActivity.class);
        startActivity(intent);
    }

    public void clickToChat(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    private View.OnClickListener fabListen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
            integrator.setPrompt("Get something");
            integrator.setBeepEnabled(true);
            integrator.setOrientationLocked(true);
            integrator.setCaptureActivity(Capture.class);
            integrator.addExtra("info", "Bún");
            integrator.setTimeout(4000);
            integrator.initiateScan();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(this, CongThucNauAnActivity.class);
        intent.putExtra("info", "Bún");
        startActivity(intent);
    }
}