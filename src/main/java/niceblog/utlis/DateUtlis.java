package niceblog.utlis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GeorgeDon on 2017/11/27.
 */
public class DateUtlis {

    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}
