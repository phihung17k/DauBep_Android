package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView headerHello;
    private BottomNavigationView bottomNavigationView;
    private ImageView imageView;
    private Button btnMeat2;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(true);

//
//        //if you have an activity, you can use setContentView from the DataBindingUtils. Don't forget to delete the generic setContentView
//        HelloWorldBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_my_activity);
//
//
////Once you have accomplished the above, you can access your data-bound fields like this:
//        binding.hello.setText(“Hello”);
//        binding.world1.world.setText(“First World”);
//        binding.world2.world.setText(“Second World”);

        headerHello = findViewById(R.id.header_hello);
        String stringHeaderHello = headerHello.getText().toString();
        SpannableString tempHello = new SpannableString(stringHeaderHello);
        int startIndex;
        if(stringHeaderHello.contains("Which")){
            startIndex = stringHeaderHello.indexOf("Which");
        } else {
            startIndex = stringHeaderHello.indexOf("Bạn");
        }

        tempHello.setSpan(new RelativeSizeSpan(2f), 0, startIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tempHello.setSpan(new StyleSpan(Typeface.BOLD), 0, startIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        headerHello.setText(tempHello);

    }
}
