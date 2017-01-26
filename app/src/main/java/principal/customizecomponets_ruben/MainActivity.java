package principal.customizecomponets_ruben;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import principal.customizecomponets_ruben.TartaGrafica;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TartaGrafica tarta =(TartaGrafica)findViewById(R.id.pie_chart);
        float[] data = {300, 300, 300, 300, 300};
        tarta.setData(data);
    }
}
