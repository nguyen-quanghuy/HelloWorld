/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.regex.Pattern;

/**
 *
 * @author QUANG HUY
 */
public class NumberUtils {

    public NumberUtils() {
    }
    
    private final static Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    
    public static boolean isNumeric(final String strNum){
        if(strNum == null){
            return false;
        }
        return NUMERIC_PATTERN.matcher(strNum).matches();
    } 
    
    public static boolean isNotNumeric(final String strNum){
        return !isNumeric(strNum);
    }
}
