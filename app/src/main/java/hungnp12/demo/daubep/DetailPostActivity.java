package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import hungnp12.demo.daubep.model.Post;

public class DetailPostActivity extends AppCompatActivity {
    static private Post post;

    private TextView postTitle,contentPost,btnLike,btnCmt,btnShare;
    private ImageButton likeIcon,cmtIcon,shareIcon;
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);

        postTitle = findViewById(R.id.postTitle);
        contentPost = findViewById(R.id.txtContent);
//        contentPost.setMovementMethod(new ScrollingMovementMethod());
        imgView = findViewById(R.id.postImg);

        btnLike = findViewById(R.id.btnLike);
        btnCmt = findViewById(R.id.btnCmt);
        btnShare = findViewById(R.id.btnShare);

        likeIcon = findViewById(R.id.likeIcon);
        cmtIcon = findViewById(R.id.cmtIcon);
        shareIcon = findViewById(R.id.shareIcon);

        post = new Post(1,R.drawable.chicken,"What is the secret to making great fried chicken?","Iris Shark","15",true);

        contentPost.setText(pattern);
    }

    public void clickToLike(View view) {
        boolean isLike = post.isLike();
        if(!isLike){
            likeIcon.setImageResource(R.drawable.fill_heart_foreground);
            post.setLike(true);
        }else{
            likeIcon.setImageResource(R.drawable.unfill_heart_foreground);
            post.setLike(false);
        }
    }

    public void clickToCMT(View view) {
    }

public void clickToBack(View view){
        finish();
}
    private String pattern = "Very hot oil at the beginning to make the outside crispy, then lower temperature thereafter to keep it from being overcooked on the outside while allowing it to cook through.\n" +
            "\n" +
            "Ideally, the chicken should be bone dry on the outside before it goes into the fat to keep water from immediately cooling down the oil. Patting it very dry or using flour will both work.\n" +
            "\n" +
            "KFC has the perfect process, which is off patent now but is hard to put into practice. The chicken is cooked at about 375 initially, and the chicken cools down the fat, but it’s cooked under pressure so that water boils at well over 212 and makes the center taste fried rather than boiled.";


}