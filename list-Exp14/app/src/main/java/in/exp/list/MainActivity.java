package in.exp.list;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private String[] list = {"India", "China", "South Korea", "USA", "Japan"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

//        ArrayAdapter<String> adpter = new ArrayAdapter<String>(this, R.layout.activity_list, R.id.text, list);
//        ArrayAdapter<String> adpter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        ArrayAdapter<String> adpter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adpter);

    }
}