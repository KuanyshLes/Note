package kz.production.kuanysh.notifications;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> itemlist = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Click on item", Toast.LENGTH_SHORT).show();
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemlist);
        ListView listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        itemlist.add("Coca-Cola");
        itemlist.add("Био-С");
        itemlist.add("Salted Caramel Square");
        itemlist.add("Red Berry Danish");
        itemlist.add("Chocolate Croissant");
        itemlist.add("Omelette");
        itemlist.add("Morning Slad");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Notification enabled", Toast.LENGTH_LONG).show();
                notification(position);
            }
        });
    }

    public void notification(int position) {
        NotificationCompat.Builder builder=(NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.icon))
                .setContentTitle("Notification from Tole")
                .setContentText("Left only 5 "+itemlist.get(position).toString());

        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder.build());

    }
}
