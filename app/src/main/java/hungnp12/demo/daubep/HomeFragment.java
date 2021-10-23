package hungnp12.demo.daubep;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private TextView headerHello;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        headerHello = getActivity().findViewById(R.id.header_hello);
        String stringHeaderHello = headerHello.getText().toString();
        SpannableString tempHello = new SpannableString(stringHeaderHello);
        int startIndex;
        if(stringHeaderHello.contains("Which")){
            startIndex = stringHeaderHello.indexOf("Which");
        } else {
            startIndex = stringHeaderHello.indexOf("Bạn");
        }

        tempHello.setSpan(new RelativeSizeSpan(2f), 0, startIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        tempHello.setSpan(new StyleSpan(Typeface.BOLD), 0, startIndex, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        headerHello.setText(tempHello);
    }


}