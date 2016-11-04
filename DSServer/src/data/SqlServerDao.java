package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerDao {
	
	private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=DinnerDB";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String user = "sa";
	private String pass = "123456";
	private Connection conn = null;
	private Statement stmt = null;
	
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
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String sql){				//��������
		
		try {
			stmt.execute(sql);
			System.out.println("����ɹ���");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(){				//�޸�����
		
	}
	
	public void delete(){				//ɾ������
		
	}
	
	public void select(){				//��ѯ����
		
	}
	
	public void close(){				//�ر���Դ
		
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
