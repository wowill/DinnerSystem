package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlServerDao {
	
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DinnerDB";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String user = "sa";
	private String pass = "123456";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public SqlServerDao() {
		
		init();
	}

	public void init() {
		
		
	}
	
	public void createConn(){			//���������ݿ������
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			
			System.out.println("���ݿ����ӳɹ���");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String sql){				//��������
		
		try {
			createConn();
			
			stmt.execute(sql);
			System.out.println("����ɹ���");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(String sql){				//�޸�����
		
		createConn();
		try {
			stmt.execute(sql);
			
			System.out.println("Update OK !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void delete(String sql){				//ɾ������
		
		createConn();
		try {
			stmt.execute(sql);
			
			System.out.println("delete OK !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> select(String sql, int[] a){				//��ѯ����
		
		createConn();
		ArrayList<String> list = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				String st = "";
				for(int i = 0; i < a.length; i++){
					st += rs.getString(a[i])+" ";
				}
				st.trim();
				list.add(st);
			}
			System.out.println("slect OK ! ");
//			for(int i = 0; i < list.size(); i++){
//				System.out.println(list.get(i));
//			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void close(){				//�ر���Դ
		
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
