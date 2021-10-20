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
        list.add(new UserContact("Evil_Gwi", "Cách bạn khoảng 5km", R.drawable.kontum, R.drawable.messenger));
        list.add(new UserContact("Be Cun", "Cách bạn khoảng 4km",R.drawable.becun, R.drawable.messenger));
        list.add(new UserContact("To To", "Cách bạn khoảng 3km",R.drawable.toto, R.drawable.messenger));
        list.add(new UserContact("Alex", "Cách bạn khoảng 5km",R.drawable.avatar_first, R.drawable.messenger));
        list.add(new UserContact("Nung Nguyen", "Cách bạn khoảng 3km",R.drawable.avatar_second, R.drawable.messenger));
        list.add(new UserContact("Teo Le", "Cách bạn khoảng 5km",R.drawable.avatar_third, R.drawable.messenger));
        list.add(new UserContact("Tun Tun", "Cách bạn khoảng 2km",R.drawable.avatar_fourth, R.drawable.messenger));
        list.add(new UserContact("Min Min", "Cách bạn khoảng 3km",R.drawable.avatar_fifth, R.drawable.messenger));
        list.add(new UserContact("Natto", "Cách bạn khoảng 5km",R.drawable.avatar_sixth, R.drawable.messenger));
        list.add(new UserContact("Ruby", "Cách bạn khoảng 4km",R.drawable.avatar_seventh, R.drawable.messenger));
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