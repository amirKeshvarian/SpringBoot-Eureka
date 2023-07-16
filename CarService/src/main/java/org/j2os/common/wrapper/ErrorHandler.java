package org.j2os.common.wrapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ErrorHandler {
    private ErrorHandler(){}
    public static Map getError (Exception e){
        Map<String, String> map = new HashMap<>();
        e.printStackTrace();
        if (e instanceof ArithmeticException){
            map.put("CODE","101");
            map.put("MSG", e.getMessage());
        } else if (e instanceof SQLException) {
            map.put("CODE","102");
            map.put("MSG", e.getMessage());
        }else{
            map.put("CODE","1000");
            map.put("MSG", " call 2 support " + e.getMessage());
        }
        return map;
    }
}
