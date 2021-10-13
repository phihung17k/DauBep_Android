package hungnp12.demo.daubep;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private RecyclerView rcvUsers;
    private UserContactAdapter userContactAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        rcvUsers = findViewById(R.id.rcvUsers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUsers.setLayoutManager(linearLayoutManager); // provides similar functionality to ListView

        userContactAdapter = new UserContactAdapter(this, getListUsers());
        rcvUsers.setAdapter(userContactAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUsers.addItemDecoration(itemDecoration);


        searchView = findViewById(R.id.svInput);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userContactAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userContactAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private List<UserContact> getListUsers() {
        List<UserContact> list = new ArrayList<>();
        list.add(new UserContact("Evil_Gwi", R.drawable.kontum, R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Be Cun", R.drawable.becun, R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("To To", R.drawable.toto,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Alex", R.drawable.avatar_first,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Nung Nguyen", R.drawable.avatar_second,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Teo Le", R.drawable.avatar_third,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Tun Tun", R.drawable.avatar_fourth,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Min Min", R.drawable.avatar_fifth,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Natto", R.drawable.avatar_sixth,  R.drawable.telephone, R.drawable.messenger));
        list.add(new UserContact("Ruby", R.drawable.avatar_seventh,  R.drawable.telephone, R.drawable.messenger));
        return list;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(userContactAdapter != null){
            userContactAdapter.release();
        }
    }


    public void clickContactBack(View view) {
        finish();
    }
}