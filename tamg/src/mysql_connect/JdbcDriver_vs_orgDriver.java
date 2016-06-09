package mysql_connect;

//此程序用来比较com.mysql.jdbc.Driver与org.gjt.mm.mysql.Driver
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
  
public class JdbcDriver_vs_orgDriver {  
  
    public static void main(String[] args) throws Exception {  
        //实际上两种加载驱动的方式都是一样的，最后（源码里面）都是调用的com.mysql.jdbc.Driver驱动  
	        //之所以还存在加载org.gjt.mm.mysql.Driver驱动，原因是为了向下兼容，其实这个类里面就只是  
        //返回了一个对于com.mysql.jdbc.Driver一个引用而已  
        getConnByJdbcDriver();  
        //getConnByOrgDriver();  
        PreparedStatement psmt = conn.prepareStatement("select * from user");  
        ResultSet rs = psmt.executeQuery();  
        while (rs.next()) {  
            System.out.println("姓名：" + rs.getString(1));  
        }  
    }  
  
    private static Connection conn;  
  
    /**通过加载com.mysql.jdbc.Driver驱动类来获取连接 
     * @throws Exception 
     */  
    public static void getConnByJdbcDriver() throws Exception {  
        String url = "jdbc:mysql://localhost/test?user=root&password=123456&characterEncoding=utf-8";  
        // 加载驱动  
        Class clazz = Class.forName("com.mysql.jdbc.Driver");  
        System.out.println("驱动名称" + clazz.getName());  
        // 建立连接  
        conn = DriverManager.getConnection(url);  
    }  
      
    /**通过加载org.gjt.mm.mysql.Driver驱动类来获取连接 
     * @throws Exception 
     */  
    public static void getConnByOrgDriver() throws Exception {  
        String url = "jdbc:mysql://localhost/test?user=root&password=123456&characterEncoding=utf-8";  
        // 加载驱动  
        Class clazz = Class.forName("org.gjt.mm.mysql.Driver");  
        System.out.println("驱动名称" + clazz.getName());  
        // 建立连接  
        conn = DriverManager.getConnection(url);  
    }  
  
      
}  
