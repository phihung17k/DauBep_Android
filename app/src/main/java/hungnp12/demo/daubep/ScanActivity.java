package hungnp12.demo.daubep;

import static java.lang.Thread.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ScanActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    private ListView listView;
    private List<String> listString;
    private Button btnScan, btnNext;
    private CodeScannerView scannerView;
//    private MaterialAdapter adapter;
    private TextView stateScan;
    private boolean isScanAgain = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        stateScan = findViewById(R.id.stateScan);

//        listString = new ArrayList<>();
//        listString.add("Bún");
//        listString.add("Rau cải cúc");
//        listString.add("Thịt lợn");
//        listString.add("Thịt bò");
        btnScan = findViewById(R.id.btnScan);
//        btnNext = findViewById(R.id.btnNext);
//        listView = findViewById(R.id.listViewMaterial);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        adapter = new MaterialAdapter(this,
//                android.R.layout.simple_list_item_multiple_choice,
//                new ArrayList<>());
//        listView.setAdapter(adapter);
        Intent intent = getIntent();
        if(intent.getStringExtra("ScanAgain") != null){
            isScanAgain = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    public void startScan(View view) {
        stateScan.setText("Đang Quét ...");
        new Handler().postDelayed(new Runnable() {
            public void run() {
//                Toast.makeText(ScanActivity.this, "Đã quét xong", Toast.LENGTH_SHORT).show();
                Intent resultIntent;
                System.out.println("MESSAGE:"+isScanAgain);
                if(isScanAgain){
                    resultIntent = new Intent(ScanActivity.this, CongThucNauAnActivity.class);
                    ArrayList<String> material = new ArrayList<>();
                    material.add("Bắp cải");
                    material.add("Cà chua");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    material.add("Muop dang");
                    resultIntent.putExtra("info",material);
                    stateScan.setText("");
                    setResult(Activity.RESULT_OK,resultIntent);
                    Toast.makeText(ScanActivity.this, "Đã quét xong", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    resultIntent = new Intent(ScanActivity.this, CongThucNauAnActivity.class);
                    resultIntent.putExtra("info", new String[]{"Bắp cải", "Cà chua"});
                    stateScan.setText("");
                    Toast.makeText(ScanActivity.this, "Đã quét xong", Toast.LENGTH_SHORT).show();
                    startActivity(resultIntent);
                }
//                System.out.println("isScanAgain "+isScanAgain);
//                if(isScanAgain){
//                    Intent intent = getIntent();
//                    intent.putExtra("info", new String[]{"Bắp cải", "Cà chua", "Mướp đắng", "Rau Xanh", "Nước dừa", "Bắp cải", "Cà chua", "Mướp đắng", "Rau Xanh"});
//                    setResult(RESULT_OK, intent);
//                    finish();
//                } else {
//                    Intent intent = new Intent(ScanActivity.this, CongThucNauAnActivity.class);
//                    intent.putExtra("info", new String[]{"Bắp cải", "Cà chua"});
//                    stateScan.setText("");
//                    startActivity(intent);
//                }

            }
        }, 5000);
    }

    private void updateAdapter(){
//        adapter.list.clear();
//        adapter.list.addAll(listString);
//        adapter.notifyDataSetChanged();
//        stateScan.setText("");
    }

//    public void clickToNextPage(View view) {
//        Intent intent = new Intent(this, CongThucNauAnActivity.class);
//        intent.putExtra("info", "Bún");
//        startActivity(intent);
//    }

    public void backToBeforePage(View view) {
        finish();
    }

//    public class MaterialAdapter extends ArrayAdapter<String> {
//
//        ArrayList<String> list = new ArrayList<>();
//        private TextView text;
//
//        public MaterialAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
//            super(context, resource, objects);
//            list = objects;
//        }
//
//        @NonNull
//        @Override
//        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            View view = null;
//
//            LayoutInflater inflater = getLayoutInflater();
//            view = inflater.inflate(R.layout.list_row, parent, false);
//            TextView textView = view.findViewById(R.id.txtItem);
//            Button btnDelete = view.findViewById(R.id.btnDelete);
//            btnDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    list.remove(position);
//                    adapter.notifyDataSetChanged();
//                    Toast.makeText(ScanActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
//                }
//            });
//            if (list.size() > 0) {
//                textView.setText(list.get(position));
//            }
//            return view;
//        }
//    }
}

