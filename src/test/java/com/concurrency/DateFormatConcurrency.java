package com.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatConcurrency {

    public static void main(String args[] ){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date today = new Date();
        Date tomorrow = new Date( today.getTime() + 1000 * 60 * 60 * 24 );
        
        System.out.println(today);
        System.out.println(tomorrow);
        
        Thread thread1 = new Thread( new Thread1(dateFormat, today));
        thread1.start();
        
        Thread thread2 = new Thread( new Thread2(dateFormat, tomorrow));
        thread2.start();
        
    }
    
    
    static class Thread1 implements Runnable{
        
        
        public Thread1(SimpleDateFormat dateFormat, Date date) {
            super();
            this.dateFormat = dateFormat;
            this.date = date;
        }

        private SimpleDateFormat  dateFormat ;
        
        private Date date;

        @Override
        public void run() {
            
            for(;;){
                
                String strDate = dateFormat.format( date);
                
                if( !"2017-08-17".equals(strDate)){
                    
                    System.err.println("today=" + strDate);
                    System.exit(0);
                }/*end if*/
            }/*end for */
        }
        
    }/* end class */

    
    static class Thread2 implements Runnable{

        public Thread2(SimpleDateFormat dateFormat, Date date) {
            super();
            this.dateFormat = dateFormat;
            this.date = date;
        }
        
        private SimpleDateFormat dateFormat;
        
        private Date date;
        
        @Override
        public void run() {
           
            for( ; ; ){
                
                String strDate = dateFormat.format( date );
                
                if(!"2017-08-18".equals( strDate ) ){
                    System.err.println("tomorrow=" + strDate);
                    System.exit(0);
                }
            }
            
        }
        
    }
    
}
