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
        contentPost.setText(pattern);
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

    private String pattern = "Nguyên liệu: \n" +
            "\n" +
            "5 cánh gà \n" +
            "Hành khô, tỏi, nước mắm, tiêu xay, dầu ăn, muối, hạt nêm, đường\n" +
            "Chuẩn bị:\n" +
            "\n" +
            "Cánh gà rửa sạch, dùng một ít muối để chà xát nhẹ lên phần da để khử mùi tanh. Xả lại với nước rồi để ráo. Sau đó cắt theo khớp hoặc chặt nhỏ tùy ý.\n" +
            "Lấy 1 củ hành khô, 2 tép tỏi, bóc vỏ, băm hoặc ép nát.\n" +
            "Lấy tiếp 10-12 tép tỏi, đập dập và cắt hạt lựu nhỏ, để riêng.\n" +
            "Cho cánh gà vào tô, ướp vào 1/3 muỗng cafe hạt nêm, 1 muỗng cafe đường, 2 muỗng cafe nước mắm. Sau đó vắt nước hành tỏi băm vào thịt gà, bã để lại. Trộn đều và ướp từ 15p.\n" +
            "Pha nước mắm theo công thức 3 thìa cơm nước mắm + 2 thìa đường + 1/3 muỗng tiêu xay, khuấy cho hỗn hợp tan.\n" +
            "Cách chế biến:\n" +
            "\n" +
            "Bước 1: Đặt chảo lên bếp, cho dầu vào đợi đến khi dầu nóng rồi cho cánh gà vào chiên (dầu chỉ cao khoảng 1cm và cho từ miếng lớn tới nhỏ). Lưu ý nên để lửa trung bình và lật từng miếng gà cho vàng đều các mặt. Chiên từ 15-20 phút, miếng nào vàng thì gắp ra trước.\n" +
            "Bước 2: Sau khi chiên xong, đổ dầu dư ra, dùng khăn giấy lau sạch chảo. Tiếp tục cho một muỗng cafe dầu vào chảo để phi hành tỏi đã chuẩn bị. Tỏi đã ngả vàng và dậy mùi thì vớt ra.\n" +
            "Bước 3: Đổ phần bã hành tỏi băm nát vào phi thơm, đổ bát nước mắm vào chảo, vặn lửa nhỏ nhất, cho hết cánh gà đã chiên vào chảo nước mắm đảo đều 3-4 phút, trộn tỏi đã phi vào, tắt bếp, nhấc chảo ra khỏi bếp.\n" +
            "Bước 4: Trình bày cánh gà chiên ra chảo là bạn đã có món cánh gà chiên nước mắm thơm lừng rồi!";

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