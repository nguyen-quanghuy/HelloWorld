/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author QUANG HUY
 */
public class ResponseUtils{

    public ResponseUtils() {
    }
    
    public static void printError(final HttpServletResponse response, final int httpStatus, final String msg)
         throws IOException{
        
            response.setStatus(httpStatus);
            try (PrintWriter out = response.getWriter()) {
                out.println(String.format("Error: %s", msg));
            }
    }
    
}
