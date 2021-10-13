package hungnp12.demo.daubep;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Activity;
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

import hungnp12.demo.daubep.model.ForumPostConstant;
import hungnp12.demo.daubep.model.Post;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton fabScan;
    private int currentPage = 0;

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
        fabScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
        }else{
            ActivityCompat.requestPermissions(this, new String[] {
                    Manifest.permission.CAMERA
            }, 6789);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int oldPageIndex = currentPage;
                    Fragment selectedFragment = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            if(currentPage != 0) {
                                currentPage = 0;
                                selectedFragment = new HomeFragment();
                            }
                            break;
                        case R.id.nav_community:
                            if(currentPage != 1) {
                                currentPage = 1;
                                selectedFragment = new CommunityFragment();
                            }
                            break;
                        case R.id.nav_personal:
                            if(currentPage != 3){
                                currentPage = 3;
                                selectedFragment = new PersonalFragment();}
                                break;
                        case R.id.nav_notification:
                            if(currentPage != 2) {
                                currentPage = 2;
                                selectedFragment = new NotificationFragment();
                            }
                            break;
                        default:
                            if(currentPage != 0) {
                                currentPage = 0;
                                selectedFragment = new HomeFragment();
                            }
                            break;
                    }
                    if(oldPageIndex != currentPage) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit();
                        return true;
                    }
                    return false;
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
    public void clicktoNguyenLieu(View view) {
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
            integrator.setBeepEnabled(true);
            integrator.initiateScan();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_CANCELED) {
            Intent intent = new Intent(this, CongThucNauAnActivity.class);
            intent.putExtra("info", "Bún");
            startActivity(intent);
        }
    }


    public void clickToShowChatDetail(View view) {
        Intent intent = new Intent(this, ChatDetailActivity.class);
        Bundle bundle = new Bundle();
        User user = new User(R.drawable.toto, "To To", "20 phút trước", "Đã gửi");
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void clickToNavigatorPost(View view) {
        Intent intent = new Intent(this, DetailPostActivity.class);
        Post post = new Post(1,R.drawable.chicken,"Cách làm gà chiên  ngon?","Long",Integer.toString(15),true);
        post.setContent(ForumPostConstant.CHICKEN);
        intent.putExtra("post", post);
        startActivity(intent);
    }
}