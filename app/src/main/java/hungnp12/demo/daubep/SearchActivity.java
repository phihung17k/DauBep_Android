package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import hungnp12.demo.daubep.model.ItemClickListener;
import hungnp12.demo.daubep.model.Post;

public class SearchActivity extends AppCompatActivity implements ItemClickListener {
    private EditText edtSearch;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Post> listPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        listPost = initListData(listPost);
        edtSearch = findViewById(R.id.edtSearch);
        recyclerView = findViewById(R.id.searchResult);


        PostViewAdapter adapter = new PostViewAdapter(listPost,this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                String keySearch = edtSearch.getText().toString();
                System.out.println("KEY:"+keySearch);
                adapter.getFilter().filter(keySearch);
                return true;
            }
        });




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
        return posts;
    }


    @Override
    public void onclickItem(int position) {
        Intent intent = new Intent(this,DetailPostActivity.class);
        intent.putExtra("post",listPost.get(position));
        startActivity(intent);
    }
    public void clickToBack(View view){
        finish();
    }
}