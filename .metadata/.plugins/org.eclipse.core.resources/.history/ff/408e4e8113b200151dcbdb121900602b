package webservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Services {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url1 = "jdbc:mysql://127.0.0.1:3306/record";
	private static final String url2 = "jdbc:mysql://127.0.0.1:3306/shuzi";
	private static final String user = "root";
	private static final String password = "123456";
	private static  Integer num = 0;
	private static  String name = "";
	private static  ArrayList<String> namearr = new ArrayList();
	private static  String score = "";
	private static  ArrayList<Integer> scorearr = new ArrayList();
	public void readRecord()
	{

        num = 0;
        name = "";
        score = "";
        namearr.clear();
        scorearr.clear();
		try {

		// 加载驱动程序

		Class.forName(driver);

		// 连续数据库

		Connection conn1 = DriverManager.getConnection(url1, user, password);
		Connection conn2 = DriverManager.getConnection(url2, user, password);

		// statement用来执行SQL语句

		Statement st1 = conn1.createStatement();
		Statement st2 = conn2.createStatement();

		// 要执行的SQL语句

		String sql = "select * from record ORDER BY TIME ASC";
		
		ResultSet rs = st1.executeQuery(sql);
		int time;
		while(rs.next()) { 
        String temp = rs.getString("name");
		namearr.add(temp);
		time = rs.getInt("time");
		int temp2 = 100-(time-40)/2;
		scorearr.add( new Integer(temp2));  

		} 
		
		sql = "select count(*) as n from record";
		rs = st1.executeQuery(sql);
		int num1=0,num2=0;
		while(rs.next()) {
		num1 = rs.getInt("n");
		}
		rs = st2.executeQuery(sql);
		while(rs.next()) {
			num2 = rs.getInt("n");
		}
		num = num1+num2;
		

		sql = "select * from record ORDER BY SCORE ASC";
		rs = st2.executeQuery(sql);
	    int i=0;
		while(rs.next()) {
		    int temp = rs.getInt("score");
		    String temp2 = rs.getString("name");
		    Boolean flag = false;
			for(;i<num1&&flag==false;){
				if(scorearr.get(i)<temp){
					scorearr.add(1);
					namearr.add("");
					for(int f=num1-1; f>=i;f--){
						scorearr.set(f+1, scorearr.get(f));
						namearr.set(f+1, namearr.get(f));
						}
					scorearr.set(i,temp);
					namearr.set(i, temp2);
					flag=true;
				}
				else i++;
			}
			if(flag = false){
			scorearr.add(temp);
			namearr.add(temp2);
			}
		
        } 
		for(i=0;i<namearr.size();i++){
			name += namearr.get(i) + "$";
			score += scorearr.get(i).toString() + "$";
		}
		
		
		st1.close();
		st2.close();
		conn1.close();
		conn2.close();
		}catch(ClassNotFoundException e) {   
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
			} catch(SQLException e) {   
			e.printStackTrace();   
			} catch(Exception e) {   
			e.printStackTrace();   
			}   
	}
	
	public int queryPlayerNum(){
		readRecord();
		return num;
	}
	public String queryPlayerName(){
		
	    
		return name;
	}
	public String queryPlayerRank(){
		return score;
	}
	

}
