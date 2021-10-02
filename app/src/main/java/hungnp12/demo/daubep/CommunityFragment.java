package hungnp12.demo.daubep;

import android.content.Intent;
import android.os.Bundle;

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

import hungnp12.demo.daubep.model.ItemClickListener;
import hungnp12.demo.daubep.model.Post;


public class CommunityFragment extends Fragment implements ItemClickListener {
    private ImageButton btnSearch,btnMenu;
    private Button btnFeatured,btnRecent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
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
        listPost = initListData(listPost);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        adapter = new PostViewAdapter(listPost,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

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
        Intent intent = new Intent(getActivity(),DetailPostActivity.class);
        intent.putExtra("post",listPost.get(position));
        startActivity(intent);
    }
}