package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import hungnp12.demo.daubep.model.Comment;
import hungnp12.demo.daubep.model.Post;

public class DetailPostActivity extends AppCompatActivity {
    static private Post post;
    private TextView postTitle, contentPost, btnLike, btnCmt, btnShare;
    private ImageButton likeIcon, cmtIcon, shareIcon;
    private ImageView imgView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Comment> cmtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_post);
        post = (Post) getIntent().getSerializableExtra("post");
        postTitle = findViewById(R.id.postTitle);
        contentPost = findViewById(R.id.txtContent);

        imgView = findViewById(R.id.postImg);

        btnLike = findViewById(R.id.btnLike);
        btnCmt = findViewById(R.id.btnCmt);
        btnShare = findViewById(R.id.btnShare);

        likeIcon = findViewById(R.id.likeIcon);
        cmtIcon = findViewById(R.id.cmtIcon);
        shareIcon = findViewById(R.id.shareIcon);

        postTitle.setText(post.getTitle());
        contentPost.setText(post.getContent());
        imgView.setImageResource(post.getImg());

        cmtList = getComments(cmtList);
        recyclerView = findViewById(R.id.cmtView);
        adapter = new CommentAdapter(cmtList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void clickToLike(View view) {
        boolean isLike = post.isLike();
        if (!isLike) {
            likeIcon.setImageResource(R.drawable.fill_heart_foreground);
            post.setLike(true);
        } else {
            likeIcon.setImageResource(R.drawable.unfill_heart_foreground);
            post.setLike(false);
        }
    }

    public void clickToCMT(View view) {
    }

    public void clickToBack(View view) {
        finish();
    }



    public List<Comment> getComments(List<Comment> comments) {
        comments = new ArrayList<Comment>();
        Comment cmt;
        cmt = new Comment("Thanh Huy", "12/11/2020", R.drawable.avatar_first, "Nếu có bất kỳ sự kiểm soát chất lượng nào xảy ra đối với KFC Bromma, nhà hàng này sẽ bị đóng cửa ngay lập tức. Chúng tôi đã nhiều lần thử ăn ở KFC Bromma và lần nào cũng tệ hơn lần khác.");
        comments.add(cmt);
        cmt = new Comment("Hai Dang", "12/11/2020", R.drawable.avatar_second, "Nếu có bất kỳ sự kiểm soát chất lượng nào xảy ra đối với KFC Bromma, nhà hàng này sẽ bị đóng cửa ngay lập tức. Chúng tôi đã nhiều lần thử ăn ở KFC Bromma và lần nào cũng tệ hơn lần khác.");
        comments.add(cmt);
        cmt = new Comment("Minh Nhat", "12/11/2020", R.drawable.avatar_third, "Nếu có bất kỳ sự kiểm soát chất lượng nào xảy ra đối với KFC Bromma, nhà hàng này sẽ bị đóng cửa ngay lập tức. Chúng tôi đã nhiều lần thử ăn ở KFC Bromma và lần nào cũng tệ hơn lần khác.");
        comments.add(cmt);
        cmt = new Comment("Phi Hung", "12/11/2020", R.drawable.avatar_fourth, "Nếu có bất kỳ sự kiểm soát chất lượng nào xảy ra đối với KFC Bromma, nhà hàng này sẽ bị đóng cửa ngay lập tức. Chúng tôi đã nhiều lần thử ăn ở KFC Bromma và lần nào cũng tệ hơn lần khác.");
        comments.add(cmt);
        return comments;
    }
}