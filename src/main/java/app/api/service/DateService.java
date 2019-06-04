package app.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;

@Service
public class DateService {

    public DateService() {
    }

    public Boolean isValidDate(String inDate) {
        
        if(inDate == null || inDate.isEmpty()) {
            throw new IllegalArgumentException("date is null or empty");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {

            dateFormat.parse(inDate.trim());

        } catch (ParseException pe) {
            return false;
        }
        return true;

    }

}
