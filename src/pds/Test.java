/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kakes
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int cartItems[] = new int[3];
//        cartItems[0] = 34;
//        cartItems[1] = 35;
//        cartItems[2] = 36;
//        
//        String deleteQuery = "delete from retailer_cart where id in ( ";
//        for (int cartItem : cartItems) {
//            deleteQuery += cartItem + ",";
//        }
//        deleteQuery = deleteQuery.substring(0, deleteQuery.length()-1) + ")";
//        
//        
//        System.out.println("deleteQuery " + deleteQuery);

//        List<Integer> myList = new ArrayList<Integer>();
//        myList.add(2);
//        myList.add(4);
//        myList.add(3);
        Date d = new Date(Long.parseLong("1543516200000"));
        System.out.println("d" + d);;
        
    }
    
    static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list) {
            ret[i++] = e;
        }
        return ret;
    }
    
}
