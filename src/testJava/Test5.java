package testJava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Test5 {

	public static void main(String[] args) {
//		String now = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		System.out.println(now);
		
		//System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd").format(getLastDayOfWeek(2016,2)));
		System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd").format(getFirstDayOfWeek(2016,0)));
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		//test();
		System.out.println(getFDayOfWeek(2016,0));
		//System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd").format(getFDayOfWeek(2016,2)));
	}
	
	private static void test(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		for(String s:list){
			if("aa".equals(s)){
				s="aaaaa";
			}
		}
		System.out.println(list);
	}
	
	
	public static String getFDayOfWeek(int year, int week) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, week * 7);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.setTime(calendar.getTime());
        calendar1.set(Calendar.DAY_OF_WEEK,calendar1.getFirstDayOfWeek());
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime());
	}
	  /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = calendar;//(Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }
    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
    	System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd").format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }
    
    /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }
    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
    	//System.out.println(new java.text.SimpleDateFormat("yyyy-MM-dd").format(date));
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }
}
