package hungnp12.demo.daubep;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatDetailActivity extends AppCompatActivity {
    private ImageView back, avatar, avatar_chat1, avatar_chat2, avatar_chat3;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }

        back = findViewById(R.id.imgBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //
        User user = (User) bundle.get("object_user");
        avatar = findViewById(R.id.avatar);
        avatar_chat1 = findViewById(R.id.avatar_chat1);
        avatar_chat2 = findViewById(R.id.avatar_chat2);
        avatar_chat3 = findViewById(R.id.avatar_chat3);
        txtName = findViewById(R.id.txtName);

        String name = user.getName();
        int resourceID = user.getImage();
        avatar.setImageResource(resourceID);
        avatar_chat1.setImageResource(resourceID);
        avatar_chat2.setImageResource(resourceID);
        avatar_chat3.setImageResource(resourceID);
        txtName.setText(name);

    }
}