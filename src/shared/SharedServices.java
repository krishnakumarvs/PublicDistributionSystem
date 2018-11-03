/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kakes
 */
public class SharedServices {

    static String dateFormat = "dd-MMM-yyyy";

    public static String convertDate(String timeStamp) {
        try {
            long time = Long.parseLong(timeStamp);
            Date d = new Date((long) time);
            DateFormat f = new SimpleDateFormat(dateFormat);
            return f.format(d);
        } catch (NumberFormatException e) {
            return "-";
        }

    }

    public static void clearRows(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public static String getOrderStatusMessage(String orderStatusId) {
        String orderStatus = "";
        if (orderStatusId == null) {
            orderStatus = "null";
        } else {
            if (orderStatusId.equals("0")) {
                orderStatus = "Not Granted";
            } else if (orderStatusId.equals("1")) {
                orderStatus = "Granted";
            } else if (orderStatusId.equals("2")) {
                orderStatus = "Received";
            }
        }

        return orderStatus;
    }
}
