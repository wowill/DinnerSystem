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
	
	public void createConn(){			//建立与数据库的连接
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			
			System.out.println("数据库连接成功！");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(String sql){				//插入数据
		
		try {
			createConn();
			
			stmt.execute(sql);
			System.out.println("插入成功！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
	}
	
	synchronized public void cAndSUP(String data, int auth){			//处理客户端用户传来的修改数据请求
		
		try{
			createConn();
			if(auth == 1){
				userUpdate(data);
			}
			else if(auth == 0){
				serverUpdate(data);
			}
			
		}catch(SQLException sqle){
			sqle.getStackTrace();
		}
	}
	
	public void serverUpdate(String data) throws SQLException{
		String sql = "";
		boolean flag = false;
		String sa[] = data.split(",");
		int la[] = new int[sa.length];
		int so[] = new int[sa.length];
		for(int i = 0; i < sa.length; i++){
			String sp[] = sa[i].split(" ");
			int lId = Integer.parseInt(sp[0]);
			int pId = Integer.parseInt(sp[1]);
			int pNum = Integer.parseInt(sp[2]);
			sql = "select * from ItemToDetails where perID = "+(pId+1)+" and ItemID = " + (lId+1);
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				int leaveNum = Integer.parseInt(rs.getString(4));
				int soldNum = Integer.parseInt(rs.getString(5));
				la[i] = leaveNum;
				so[i] = soldNum;
//				if(leaveNum < Integer.parseInt(pNum)){
//					PCV.commitStat = "F";
//					flag = true;
//					break;
//				}
				
			}

//			if(flag){
//				break;
//			}
		}
		if(!flag){
//			PCV.commitStat = "T";
			for(int i = 0; i < sa.length; i++){
				String sp[] = sa[i].split(" ");
				int lId = Integer.parseInt(sp[0]);
				int pId = Integer.parseInt(sp[1]);
				int pNum = Integer.parseInt(sp[2]);
				
				sql = "update ItemToDetails set leave = "+ (la[i] + pNum) + " where perID = "+(pId+1)+" and ItemID = " + (lId+1);
				System.out.println(sql);
				stmt.execute(sql);
				System.out.println("服务端添加补给成功！");
			}
		}
		
		close();
	}
	
	public void userUpdate(String data) throws NumberFormatException, SQLException{
		String sql = "";
		boolean flag = false;
		String sa[] = data.split(",");
		int la[] = new int[sa.length];
		int so[] = new int[sa.length];
		for(int i = 0; i < sa.length; i++){
			String sp[] = sa[i].split(" ");
			int lId = Integer.parseInt(sp[0]);
			int pId = Integer.parseInt(sp[1]);
			int pNum = Integer.parseInt(sp[2]);
			sql = "select * from ItemToDetails where perID = "+(pId+1)+" and ItemID = " + (lId+1);
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				int leaveNum = Integer.parseInt(rs.getString(4));
				int soldNum = Integer.parseInt(rs.getString(5));
				la[i] = leaveNum;
				so[i] = soldNum;
				if(leaveNum < pNum){
					PCV.commitStat = "F";
					flag = true;
					break;
				}
				
			}

			if(flag){
				break;
			}
		}
		if(!flag){
			PCV.commitStat = "T";
			for(int i = 0; i < sa.length; i++){
				String sp[] = sa[i].split(" ");
				int lId = Integer.parseInt(sp[0]);
				int pId = Integer.parseInt(sp[1]);
				int pNum = Integer.parseInt(sp[2]);
				
				sql = "update ItemToDetails set leave = "+ (la[i] - pNum) + ", sold = "+ (so[i] + pNum)+" where perID = "+(pId+1)+" and ItemID = " + (lId+1);
				stmt.execute(sql);
			}
		}
		
		close();
	}
	
	public void update(String sql){				//修改数据
		
		createConn();
		try {
			stmt.execute(sql);
			
			System.out.println("Update OK !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		
	}
	
	public void delete(String sql){				//删除数据
		
		createConn();
		try {
			stmt.execute(sql);
			
			System.out.println("delete OK !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
	}
	
	public ArrayList<String> select(String sql, int[] a){				//查询数据
		
		createConn();
		ArrayList<String> list = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				
				String st = "";
				for(int i = 0; i < a.length; i++){
					st += rs.getString(a[i])+" ";
				}
				st = st.trim();
				list.add(st);
			}
			System.out.println("slect OK ! ");

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		close();
		return list;
		
	}
	
	public void close(){				//关闭资源
		
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
		System.out.println("Close OK!");
		
	}
	
}
