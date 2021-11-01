package hungnp12.demo.daubep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import hungnp12.demo.daubep.data.Data;

public class FoodDetailActivity extends AppCompatActivity {

    private ImageView imgHeader, imgArrow;
    private TextView txtFoodName, txtRatingStarNumber, txtAmountUserRating, txtUsername,
            txtEstimatedTime, txtSetPerson, txtFoodDetailMaterial, txtStep1, txtStep2, txtStep3,
            txtStep4, txtUserCmtName, txtUserCmtRating, txtCmt;
    private RatingBar rsRatingStar, rsUserCmtRating;
    private CircleImageView civUserImage, civUserCmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        imgArrow = findViewById(R.id.imgArrow);
        imgHeader = findViewById(R.id.imgHeader);
        txtFoodName = findViewById(R.id.txtFoodName);
        txtRatingStarNumber = findViewById(R.id.txtRatingStarNumber);
        txtAmountUserRating = findViewById(R.id.txtAmountUserRating);
        txtUsername = findViewById(R.id.txtUsername);
        txtEstimatedTime = findViewById(R.id.txtEstimatedTime);
        txtSetPerson = findViewById(R.id.txtSetPerson);
        txtFoodDetailMaterial = findViewById(R.id.txtFoodDetailMaterial);
        txtStep1 = findViewById(R.id.txtStep1);
        txtStep2 = findViewById(R.id.txtStep2);
        txtStep3 = findViewById(R.id.txtStep3);
        txtStep4 = findViewById(R.id.txtStep4);
        txtUserCmtName = findViewById(R.id.txtUserCmtName);
        txtUserCmtRating = findViewById(R.id.txtUserCmtRating);
        txtCmt = findViewById(R.id.txtCmt);
        rsRatingStar = findViewById(R.id.rsRatingStar);
        rsUserCmtRating = findViewById(R.id.rsUserCmtRating);
        civUserImage = findViewById(R.id.civUserImage);
        civUserCmt = findViewById(R.id.civUserCmt);

        Intent intent = getIntent();
        int stt = intent.getIntExtra("stt", 0);
        imgHeader.setImageResource(Data.imgHeaders.get(stt));
        txtFoodName.setText(Data.txtFoodNames.get(stt));
        txtRatingStarNumber.setText(Data.txtRatingStarNumbers.get(stt));
        txtAmountUserRating.setText(Data.txtAmountUserRatings.get(stt));
        txtUsername.setText(Data.txtUsernames.get(stt));
        txtEstimatedTime.setText(Data.txtEstimatedTimes.get(stt));
        txtSetPerson.setText(Data.txtSetPersons.get(stt));
        txtFoodDetailMaterial.setText(Data.txtFoodDetailMaterials.get(stt));
        txtStep1.setText(Data.txtStep1s.get(stt));
        txtStep2.setText(Data.txtStep2s.get(stt));
        txtStep3.setText(Data.txtStep3s.get(stt));
        txtStep4.setText(Data.txtStep4s.get(stt));
        txtUserCmtName.setText(Data.txtUserCmtNames.get(stt));
        txtUserCmtRating.setText(Data.txtUserCmtRatings.get(stt));
        txtCmt.setText(Data.txtCmts.get(stt));
        rsRatingStar.setRating(Float.parseFloat(Data.rsRatingStars.get(stt)));
        rsUserCmtRating.setRating(Float.parseFloat(Data.rsUserCmtRatings.get(stt)));
        civUserImage.setImageResource(Data.civUserImages.get(stt));
        civUserCmt.setImageResource(Data.civUserCmts.get(stt));

        imgArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}