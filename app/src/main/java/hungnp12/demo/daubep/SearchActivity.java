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

import hungnp12.demo.daubep.model.Post;

public class SearchActivity extends AppCompatActivity  {
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


        PostViewAdapter adapter = new PostViewAdapter(listPost);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                String keySearch = edtSearch.getText().toString();
                adapter.getFilter().filter(keySearch);
                return false;
            }
        });




    }
    public List<Post> initListData(List<Post> posts){
        posts = new ArrayList<Post>();
        Post post;

        for(int i=0;i<10;i++){
            post = new Post(i,R.drawable.bun_rieu,"Title:"+i+1,"Michael",Integer.toString(i+25),true);
            posts.add(post);
        }
        return posts;
    }


}