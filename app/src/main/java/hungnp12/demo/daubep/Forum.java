package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import hungnp12.demo.daubep.model.Post;

public class Forum extends AppCompatActivity {
    private ImageButton btnSearch,btnMenu;
    private Button btnFeatured,btnRecent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Post> listPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        btnSearch = findViewById(R.id.btnSearch);
        btnMenu = findViewById(R.id.btnCollapse);
        btnFeatured = findViewById(R.id.btnFeatured);
        btnRecent = findViewById(R.id.btnMostRecent);
        recyclerView = findViewById(R.id.postList);
        listPost = initListData(listPost);



        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        adapter = new PostViewAdapter(listPost);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void ClickToSearch(View view) {
        Intent intent = new Intent(Forum.this,SearchActivity.class);
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

        for(int i=0;i<10;i++){
            post = new Post(i,R.drawable.bun_rieu,"How to cook chicken?","Michael",Integer.toString(i+25),true);
            posts.add(post);
        }
        return posts;
    }
}