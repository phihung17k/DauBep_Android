package hungnp12.demo.daubep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserContactAdapter extends RecyclerView.Adapter<UserContactAdapter.UserContactViewHolder> implements Filterable {
    private List<UserContact> listUser;
    private List<UserContact> listUserOld;
    private Context context;

    public UserContactAdapter(Context context, List<UserContact> listUser) {
        this.listUser = listUser;
        listUserOld = listUser;
        this.context = context;
    }


    @NonNull
    @Override
    public UserContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_contact, parent, false);
        return new UserContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserContactViewHolder holder, int position) {
        UserContact user = listUser.get(position);
        if (user == null) {
            return;
        }

        holder.imgUser.setImageResource(user.getAvatar());
        holder.imgMessage.setImageResource(user.getMessIcon());
        holder.txtName.setText(user.getName());
        holder.txtLocation.setText(user.getLocation());
        holder.layoutContactItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(user);
            }
        });
    }


    private void onClickGoToDetail(UserContact user) {
        Intent intent = new Intent(context, ChatDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user_contact", user);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public void release() {
        context = null;
    }

    @Override
    public int getItemCount() {
        if (listUser != null) {
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
                if (strSearch.isEmpty()) {
                    listUser = listUserOld;
                } else {
                    List<UserContact> list = new ArrayList<>();
                    for (UserContact user : listUserOld) {
                        if (user.getName().toLowerCase().contains(strSearch.toLowerCase())) {
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
                listUser = (List<UserContact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class UserContactViewHolder extends RecyclerView.ViewHolder {// interact with item_user.xml
        private LinearLayout layoutContactItem;
        private TextView txtName, txtLocation;
        private CircleImageView imgUser;
        private ImageView imgMessage;

        public UserContactViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutContactItem = itemView.findViewById(R.id.layout_contact_item);
            imgUser = itemView.findViewById(R.id.imgUser);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            imgMessage = itemView.findViewById(R.id.imgMessage);
            txtName = itemView.findViewById(R.id.txtName);

        }
    }
}
