package bpc.dis.materialedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DisMaterialEditText disMaterialEditText = findViewById(R.id.disMaterialEditText);
        findViewById(R.id.btn_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disMaterialEditText.showError();
            }
        });
        findViewById(R.id.btn_hide_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disMaterialEditText.hideError();
            }
        });
    }

}
