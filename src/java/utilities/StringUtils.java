/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author QUANG HUY
 */
public class StringUtils {

    private StringUtils() {
    }
    
    public static boolean isEmpty(final String s){
        return s == null || "".equals(s);
    }
}
