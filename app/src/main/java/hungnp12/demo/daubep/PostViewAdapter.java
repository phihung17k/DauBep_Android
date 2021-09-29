package hungnp12.demo.daubep;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import hungnp12.demo.daubep.model.ItemClickListener;
import hungnp12.demo.daubep.model.Post;

public class PostViewAdapter extends RecyclerView.Adapter<PostViewAdapter.PostViewHolder> implements Filterable{
    private List<Post> postList;
    private List<Post>  staticList;
    static private  ItemClickListener clickListener;
    public PostViewAdapter(List<Post> list, ItemClickListener clickListener) {

        this.staticList = list;
        this.postList = list;
        this.clickListener = clickListener;

    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        PostViewHolder holder = new PostViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            Post post = postList.get(position);
            holder.title.setText(post.getTitle());
            holder.name.setText(post.getName());
            holder.replyNum.setText(post.getNumReply() + " Replies");
            if(post.isLike()){
                holder.iconAction.setImageResource(R.drawable.fill_heart_foreground);
            }else{
                holder.iconAction.setImageResource(R.drawable.unfill_heart_foreground);
            }
            holder.circleImageView.setImageResource(post.getImg());
            if (position==postList.size()-1){
                holder.itemView.setPadding(0,0,0,200);
            }
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchKey = charSequence.toString();

                if(searchKey.isEmpty()){
                    postList = staticList;
                }else{
                    List<Post> tempPost = new ArrayList<Post>();

                    for(Post post:staticList){

                        if(post.getTitle().toLowerCase().contains(searchKey.toLowerCase())){

                            tempPost.add(post);
                        }
                    }
                    postList = tempPost;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values =  postList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                postList = (ArrayList<Post>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }



    public static class PostViewHolder extends RecyclerView.ViewHolder{
        private TextView title,name,replyNum;
        private ImageButton iconAction;
        private CircleImageView circleImageView;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitle);
            name = itemView.findViewById(R.id.txtName);
            replyNum = itemView.findViewById(R.id.txtReply);
            iconAction = itemView.findViewById(R.id.imageButton);
            circleImageView = itemView.findViewById(R.id.imgUser);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onclickItem(getAdapterPosition());
                }
            });

        }

    }

}
