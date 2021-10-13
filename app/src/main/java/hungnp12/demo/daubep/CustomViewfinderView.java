package hungnp12.demo.daubep;

import android.content.Context;
import android.util.AttributeSet;

    import com.journeyapps.barcodescanner.ViewfinderView;

public class CustomViewfinderView extends ViewfinderView {
    private int scanLineTop = 0;
    private int scanLightHeight = 30;

    public CustomViewfinderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    
}
