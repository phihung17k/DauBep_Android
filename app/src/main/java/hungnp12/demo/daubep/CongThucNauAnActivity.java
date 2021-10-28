package hungnp12.demo.daubep;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class CongThucNauAnActivity extends AppCompatActivity {

    public static final int CREATE = 6789;
    private EditText email, edtAddNL, edtAddKlg;
    private Button submit, btnAddNL ;
    private ChipGroup chipGroup;
    private Button btn , btn2 , btn3 ,btn4 , btn5 , btn6;
    Boolean btn2Flag = false ;
    private Spinner spAdd;
    private String selectedKL;
    private TextView txtQuantity;

    private ListView listView;
    private MaterialAdapter materialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_thuc_nau_an);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3) ;
        btn4 = findViewById(R.id.button4);
        btn5= findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        listView = findViewById(R.id.lvMaterial);
        spAdd = findViewById(R.id.spnAddP);
        txtQuantity = findViewById(R.id.quantity);

        List<String> newData = new ArrayList<>();
        newData.add("gam");
        newData.add("kilogam");
        newData.add("lit");
        newData.add("mililit ");

        ArrayAdapter<String> dataAdapterA = new ArrayAdapter<>(CongThucNauAnActivity.this ,
                android.R.layout.simple_spinner_item, newData);
        dataAdapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAdd.setAdapter(dataAdapterA);
        spAdd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedKL = spAdd.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Intent intent = getIntent();
        ArrayList<String> temp = new ArrayList<>();
        String[] arr = intent.getStringArrayExtra("info");
        if(arr != null && arr.length > 0){
            for (String s : arr) {
                temp.add(s);
                System.out.println("itemmmmmmmmmmmmm "+s);
            }
            System.out.println("lengthaaaaaaaaaaa temp: "+temp.size());
            materialAdapter = new MaterialAdapter(this,
                    android.R.layout.simple_list_item_multiple_choice,
                    temp);
            materialAdapter.notifyDataSetChanged();
//            listView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150));
//            listView.setVisibility(View.VISIBLE);
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) listView.getLayoutParams();
//            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
//            params.height = 130;
//            listView.setLayoutParams(params);
            listView.setVisibility(View.VISIBLE);
            listView.setAdapter(materialAdapter);
            txtQuantity.setText("Số lượng: " + arr.length);

        } else {
//            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) listView.getLayoutParams();
//            params.width = 0;
//            params.height = 0;
//            LayoutParams layoutParams = view.getLayoutParams();
//            layoutParams.width = newWidth;
//            view.setLayoutParams(layoutParams);
//            listView.setLayoutParams(params);
            listView.setVisibility(View.GONE);
            txtQuantity.setText("Bạn chưa quét");
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2Flag == false){
                    btn.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn2Flag == false){
                    btn2.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn2.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }



            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn2Flag == false){
                    btn3.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn3.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }



            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2Flag == false){
                    btn4.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn4.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }


            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn2Flag == false){
                    btn5.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn5.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }



            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn2Flag == false){
                    btn6.setTextColor(Color.parseColor("#ef4c29"));
                    btn2Flag = true ;
                }else {
                    btn6.setTextColor(Color.parseColor("#000000"));
                    System.out.println(btn2Flag);
                    btn2Flag = false ;
                }



            }
        });

//        edtMaterial = findViewById(R.id.edtMaterial);
//        Intent intent = this.getIntent();
//        if(intent.getStringExtra("info") != null){
//            edtMaterial.setText(intent.getStringExtra("info"));
//        }
//        email = findViewById(R.id.editText) ;
//        submit = findViewById(R.id.submitEmail) ;
        chipGroup = findViewById(R.id.chipGroup);

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String emailText  = email.getText().toString();
//                setChips(emailText);
//                Toast.makeText( CongThucNauAnActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                    email.setText("");
//            }
//        });

        btnAddNL = findViewById(R.id.btnAddMaterial);
        edtAddNL = findViewById(R.id.edtAddMaterial);
        edtAddKlg = findViewById(R.id.edtAddPrice);

        String materialCategory = intent.getStringExtra("materialX");
        if(materialCategory!=null){
            edtAddNL.setText(materialCategory);
        }

        btnAddNL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String materialString = edtAddNL.getText().toString();
                String klString = edtAddKlg.getText().toString();
                if(materialString.isEmpty() || klString.isEmpty()){
                } else {
                    String total = edtAddNL.getText().toString() + " - " + edtAddKlg.getText().toString() + " " + selectedKL;
                    setChips(total);
                    Toast.makeText(CongThucNauAnActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    edtAddNL.setText("");
                    edtAddKlg.setText("");
                    spAdd.setSelection(0);
                }
            }
        });
    }


    public void goiymonan(View view) {
        Intent intent = new Intent(this , goiymonan.class);
        startActivity(intent);
    }
    public void clickToBack(View view){
        finish();
    }

    public void setChips(String e){
        final Chip chip  = (Chip) this.getLayoutInflater().inflate(R.layout.single_input_chip_layout , null , false);
        chip.setText(e);
        chip.setOnCloseIconClickListener(new View.OnClickListener(){

            public void onClick(View view){
                chipGroup.removeView(chip);
                Toast.makeText(CongThucNauAnActivity.this, "Đã xóa " + chip.getText().toString(), Toast.LENGTH_SHORT).show();


            }
        });
        chipGroup.addView(chip);
    }

    public void clickAbc(View view) {
        finish();
    }

    public void clickToScanAgain(View view) {

        Intent intent = new Intent(this, ScanActivity.class);
        intent.putExtra("isScanAgain","true");
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                super.onActivityResult(requestCode, resultCode, data);
                ArrayList<String> list = data.getStringArrayListExtra("info");
                System.out.println("MESSAGE:"+list);
                materialAdapter = new MaterialAdapter(this,
                        android.R.layout.simple_list_item_multiple_choice,
                        list);
                listView.setVisibility(View.VISIBLE);
                listView.setAdapter(materialAdapter);
                materialAdapter.notifyDataSetChanged();
                txtQuantity.setText("Số lượng: " + list.size());

//                ArrayList<String> temp = new ArrayList<>();
//                String[] arr = getIntent().getStringArrayExtra("info");
//                System.out.println("arr "+arr.length);
//                if(arr != null && arr.length > 0){
//                    for (String s : arr) {
//                        temp.add(s);
//                    }
//                    materialAdapter = new MaterialAdapter(this,
//                            android.R.layout.simple_list_item_multiple_choice,
//                            temp);
//                    listView.setAdapter(materialAdapter);
//                    materialAdapter.notifyDataSetChanged();
//                } else {
//                    txtNotScanning.setText("Bạn chưa quét");
//                }
            }
        }

    }

    public class MaterialAdapter extends ArrayAdapter<String> {

        ArrayList<String> list = new ArrayList<>();
        private TextView text;
        private Spinner spnTL;

        public MaterialAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
            super(context, resource, objects);
            list = objects;
        }

        public void setList(ArrayList<String> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = null;

            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.list_row, parent, false);
            TextView txtMaterial = view.findViewById(R.id.txtMaterial);

            spnTL = view.findViewById(R.id.spnP);

            List<String> dataSrc = new ArrayList<>();
            dataSrc.add("gam");
            dataSrc.add("kilogam");
            dataSrc.add("lit");
            dataSrc.add("mililit ");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(CongThucNauAnActivity.this ,
                    android.R.layout.simple_spinner_item, dataSrc);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnTL.setAdapter(dataAdapter);

            Button btnDelete = view.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    materialAdapter.notifyDataSetChanged();
                    Toast.makeText(CongThucNauAnActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                }
            });
            if (list.size() > 0) {
                txtMaterial.setText(list.get(position));
            }
            return view;
        }
    }

    public void clickToHome3(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}