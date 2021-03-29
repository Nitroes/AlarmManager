package project.alice.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MSG","Alarm");
        AlarmUtils utils=new AlarmUtils(context);
        utils.setAlarm();
    }
}
