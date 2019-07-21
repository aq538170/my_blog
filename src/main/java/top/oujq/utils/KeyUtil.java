package top.oujq.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/21 7:17
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static synchronized String genUniqueKey(String str){
        java.text.SimpleDateFormat sm=new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;

        return str + sm.format(new Date()) + String.valueOf(number);
    }

//    public static void main(String[] args){
//
//        System.out.println(genUniqueKey("bk"));
//    }
}
