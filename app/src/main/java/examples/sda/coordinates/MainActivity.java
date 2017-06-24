package examples.sda.coordinates;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    private static String latitiude;
    private static String longtitude;

    @BindView(R.id.lat)
    protected EditText lat;

    @BindView(R.id.lng)
    protected EditText lng;

    @BindView(R.id.button)
    protected Button button;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick (R.id.button)
    public void showMap () {

        latitiude = lat.getText().toString();
        longtitude = lng.getText().toString();

        Uri geoLocation = Uri.parse("geo:0,0?q="+latitiude+","+longtitude+"?z=20");
        Intent intent = new Intent(Intent.ACTION_VIEW, geoLocation);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }
}
