package hungnp12.demo.daubep;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hungnp12.demo.daubep.model.ItemClickListener;
import hungnp12.demo.daubep.model.Post;


public class CommunityFragment extends Fragment implements ItemClickListener {
    private ImageButton btnSearch,btnMenu;
    private Button btnFeatured,btnRecent;
    private RecyclerView recyclerView;
    private PostViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
     private List<Post> fixedListPost;
    private List<Post> listPost;

   private ViewGroup mContainer;
    public CommunityFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forum, container, false);
        mContainer = container;
        btnSearch = view.findViewById(R.id.btnSearch);

        btnFeatured = view.findViewById(R.id.btnFeatured);
        btnRecent = view.findViewById(R.id.btnMostRecent);
        recyclerView = view.findViewById(R.id.postList);
        System.out.println("MESSAGE:"+recyclerView);
        fixedListPost = initListData(fixedListPost);
        listPost = fixedListPost;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        adapter = new PostViewAdapter(listPost,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        btnFeatured = view.findViewById(R.id.btnFeatured);
        btnRecent = view.findViewById(R.id.btnMostRecent);

        btnFeatured.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPost = fixedListPost;
                adapter.setListPost(listPost);
                adapter.notifyDataSetChanged();
            }
        });
        btnRecent.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
               listPost = listPost.stream().filter(i -> i.getId()%2==0).collect(Collectors.toList());
                adapter.setListPost(listPost);
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    public List<Post> initListData(List<Post> posts){
        posts = new ArrayList<Post>();
        Post post;
        post = new Post(1,R.drawable.chicken,"Cách làm gà chiên  ngon?","Long",Integer.toString(15),true);
        posts.add(post);
        post = new Post(2,R.drawable.bun_rieu,"Cách nấu bún riêu?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(3,R.drawable.thiheo,"Bí quyết ướp thịt?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(4,R.drawable.caloc,"Khử tanh cá hiệu quả?","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(5,R.drawable.rau2,"Chia sẻ cách tỉa rau!!","Michael",Integer.toString(15),true);
        posts.add(post);
        post = new Post(6,R.drawable.rau2,"Chia sẻ cách tỉa rau!!","Michael",Integer.toString(15),true);
        posts.add(post);
        return posts;
    }

    @Override
    public void onclickItem(int position) {
        Intent intent = new Intent(getActivity(),DetailPostActivity.class);
        intent.putExtra("post",listPost.get(position));
        startActivity(intent);
    }
}