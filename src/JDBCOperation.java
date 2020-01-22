
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class JDBCOperation {
	
	/**
	 * @method getConn() 获取数据库的连接
	 * @return Connection
	 */
	public Connection getConn() {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/ITPproject";
		String username = "postgres";
		String password = "postgres123";
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * @method insert(Student student) 
	 * @return int
	 */
	public int insert(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "insert into students (id,Name,Sex,Age) values(?,?,?,?)";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1, student.getId());
	        pstmt.setString(2, student.getName());
	        pstmt.setString(3, student.getSex());
	        pstmt.setString(4, student.getAge());
	        i = pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	/**
	 * @method delete(Student student) 删除表中数据
	 * @return int 成功删除表中数据条数
	 */
	public int delete(String name) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "delete from students where Name='" + name + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	/**
	 * @method update(Student student) 更改表中数据
	 * @return int 成功更改表中数据条数
	 */
	public int update(Student student) {
	    Connection conn = getConn();
	    int i = 0;
	    String sql = "update students set Age='" + student.getAge() + "' where Name='" + student.getName() + "'";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + i);
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	/**
	 * @method Integer getAll() 查询并打印表中数据
	 * @return Integer 查询并打印表中数据
	 */
	public Integer getAll() {
	    Connection conn = getConn();
	    String sql = "select * from students";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}