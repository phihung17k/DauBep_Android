package hungnp12.demo.daubep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>  implements Filterable {
    private List<User> listUser;
    private List<User> listUserOld;
    private Context context;

    public UserAdapter(Context context, List<User> listUser){
        this.listUser = listUser;
        listUserOld = listUser;
        this.context = context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = listUser.get(position);
        if(user == null){
            return;
        }

        holder.imgUser.setImageResource(user.getImage());
        holder.txtName.setText(user.getName());
        holder.txtNote.setText(user.getNote());
        holder.txtStatus.setText(user.getStatus());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(user);
            }
        });
    }

    private void onClickGoToDetail(User user) {
        Intent intent = new Intent(context, ChatDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void release(){
        context = null;
    }

    @Override
    public int getItemCount() {
        if(listUser != null){
            return listUser.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if(strSearch.isEmpty()){
                    listUser = listUserOld;
                }else{
                    List<User> list = new ArrayList<>();
                    for (User user:listUserOld){
                        if(user.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(user);
                        }
                    }

                    listUser = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listUser;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listUser = (List<User>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{// interact with item_user.xml
        private LinearLayout layoutItem;
        private CircleImageView imgUser;
        private TextView txtName, txtNote, txtStatus;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layout_item);
            imgUser = itemView.findViewById(R.id.imgUser);
            txtName = itemView.findViewById(R.id.txtName);
            txtNote = itemView.findViewById(R.id.txtNote);
            txtStatus = itemView.findViewById(R.id.txtStatus);
        }
    }
}
