package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import hungnp12.demo.daubep.model.ItemClickListener;
import hungnp12.demo.daubep.model.Post;

public class Forum_IGNORE extends AppCompatActivity implements ItemClickListener {
    private ImageButton btnSearch,btnMenu;
    private Button btnFeatured,btnRecent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Post> listPost;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_forum);
        btnSearch = findViewById(R.id.btnSearch);
//        btnMenu = findViewById(R.id.btnCollapse);
        btnFeatured = findViewById(R.id.btnFeatured);
        btnRecent = findViewById(R.id.btnMostRecent);
        recyclerView = findViewById(R.id.postList);
        listPost = initListData(listPost);

        //botom navigation
        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(1).setEnabled(true);


        layoutManager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);

        adapter = new PostViewAdapter(listPost,this);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    public void ClickToSearch(View view) {
        Intent intent = new Intent(Forum_IGNORE.this,SearchActivity.class);
        startActivity(intent);
    }
//    public void clickGoDetail(View view){
//        // edit later, it's just example
//        System.out.println("Event:"+view.toString());
//        Intent intent = new Intent(Forum.this,DetailPostActivity.class);
//        startActivity(intent);
//    }
    public void ClickToShowMenu(View view) {
    }

    public void clickToLoadFeatureT(View view) {
    }

    public void clickToLoadRecentT(View view) {
    }
    public List<Post> initListData(List<Post> posts){
        posts = new ArrayList<Post>();
        Post post;
        post = new Post(1,R.drawable.chicken,"Cách làm gà chiên  ngon?","Long",Integer.toString(15),true);
        posts.add(post);
        post = new Post(1,R.drawable.bun_rieu,"Cách nấu bún riêu?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(1,R.drawable.thiheo,"Bí quyết ướp thịt?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(1,R.drawable.caloc,"Khử tanh cá hiệu quả?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(1,R.drawable.rau2,"Chia sẻ cách tỉa rau!!","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(1,R.drawable.rau2,"Chia sẻ cách tỉa rau!!","Michael",Integer.toString(15),true);
        posts.add(post);
        return posts;
    }

    @Override
    public void onclickItem(int position) {
        Intent intent = new Intent(this,DetailPostActivity.class);
        startActivity(intent);
    }
}