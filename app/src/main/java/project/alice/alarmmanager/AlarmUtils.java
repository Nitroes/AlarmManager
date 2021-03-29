package project.alice.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class AlarmUtils {
    public AlarmManager am = null;
    public String START_ACTION="android.intent.action.START_REC";
    public Context context;
    public AlarmUtils(Context context){
        this.context=context;
        am=(AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }
    public void setAlarm(){
        int intervalMillis = 24 * 3600 * 1000;
        Date date=new Date(System.currentTimeMillis());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,16);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Intent intent=new Intent();
        intent.setAction(START_ACTION);
        intent.setClass(context,AlarmReceiver.class);
        PendingIntent sender=PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        am.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000 , sender);
    }
    public void clearAlarm(){
        Intent intent=new Intent();
        intent.setAction(START_ACTION);
        intent.setClass(context,AlarmReceiver.class);
        PendingIntent sender=PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        am.cancel(sender);
    }
}
