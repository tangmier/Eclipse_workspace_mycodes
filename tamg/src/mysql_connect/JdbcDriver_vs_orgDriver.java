package mysql_connect;

//�˳��������Ƚ�com.mysql.jdbc.Driver��org.gjt.mm.mysql.Driver
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
  
public class JdbcDriver_vs_orgDriver {  
  
    public static void main(String[] args) throws Exception {  
        //ʵ�������ּ��������ķ�ʽ����һ���ģ����Դ�����棩���ǵ��õ�com.mysql.jdbc.Driver����  
	        //֮���Ի����ڼ���org.gjt.mm.mysql.Driver������ԭ����Ϊ�����¼��ݣ���ʵ����������ֻ��  
        //������һ������com.mysql.jdbc.Driverһ�����ö���  
        getConnByJdbcDriver();  
        //getConnByOrgDriver();  
        PreparedStatement psmt = conn.prepareStatement("select * from user");  
        ResultSet rs = psmt.executeQuery();  
        while (rs.next()) {  
            System.out.println("������" + rs.getString(1));  
        }  
    }  
  
    private static Connection conn;  
  
    /**ͨ������com.mysql.jdbc.Driver����������ȡ���� 
     * @throws Exception 
     */  
    public static void getConnByJdbcDriver() throws Exception {  
        String url = "jdbc:mysql://localhost/test?user=root&password=123456&characterEncoding=utf-8";  
        // ��������  
        Class clazz = Class.forName("com.mysql.jdbc.Driver");  
        System.out.println("��������" + clazz.getName());  
        // ��������  
        conn = DriverManager.getConnection(url);  
    }  
      
    /**ͨ������org.gjt.mm.mysql.Driver����������ȡ���� 
     * @throws Exception 
     */  
    public static void getConnByOrgDriver() throws Exception {  
        String url = "jdbc:mysql://localhost/test?user=root&password=123456&characterEncoding=utf-8";  
        // ��������  
        Class clazz = Class.forName("org.gjt.mm.mysql.Driver");  
        System.out.println("��������" + clazz.getName());  
        // ��������  
        conn = DriverManager.getConnection(url);  
    }  
  
      
}  
