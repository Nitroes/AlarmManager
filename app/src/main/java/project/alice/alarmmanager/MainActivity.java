package project.alice.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmUtils utils=new AlarmUtils(getApplicationContext());

        findViewById(R.id.button).setOnClickListener(v->{
            TimePickerView pvTime = new TimePickerBuilder(MainActivity.this, new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    long time=date.getTime();
                    if (date.before(new Date(System.currentTimeMillis()))){
                        time+=24 * 3600 * 1000;
                    }
                    Toast.makeText(MainActivity.this, DateFormat.format("dd HH:mm:ss",time), Toast.LENGTH_SHORT).show();
                }
            })
                    .setType(new boolean[]{false, false, false, true, true, false})
                    .build();

            pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
            pvTime.show();
//            utils.setAlarm();
        });
        findViewById(R.id.button2).setOnClickListener(v->{
            utils.clearAlarm();
        });
    }
}