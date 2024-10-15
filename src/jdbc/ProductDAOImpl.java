package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements DAO {
	/* DAO <-> DB 연결 처리
	 * 
	 */
	
	// DB 연결 객체
	private Connection conn;
	// sql 구문을 실행시키는 기능을 가진 객체
	private PreparedStatement pst;
	// 쿼리문을 저장하는 스트링
	private String query="";
	
	public ProductDAOImpl() {
		// DBConnection class 생성(싱글톤) 연결
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	// sql 구문 처리! 왕 드디어!ㅋㅋ
	@Override
	public int insert(Product p) {
		// product 객체를 등록하고, isOk를 리턴
		System.out.println("insert DAOImpl success!!");
		query = "insert into product(pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			// ? 는 반드시 순서대로 처리 (자료형을 적어줘야함), 1부터 시작
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			// insert, update, delete => 1 row(s) affected; 처리만 나옴
			// 결과의 행 수만 리턴하는 처리는 >> executeUpdate(); : int로 리턴
			// select => 목록 >> executeQuery(); : ResultSet으로 리턴
			return pst.executeUpdate();
		} catch (SQLException e) {
			// insert error
			System.out.println("insert error!");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public List<Product> selectList() {
		// DB에서 리스트를 가져와서 리턴
		System.out.println("insert DAOImpl success!!");
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			// select => 목록 => executeQuery(); ResultSet으로 리턴
			ResultSet rs = pst.executeQuery();
			// ResultSet => List로 변환
			while(rs.next()) {
				list.add(new Product(rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getInt("price"), 
						rs.getString("regdate"), 
						rs.getString("madeby")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("list error!");
			e.printStackTrace();
		}
		
		
		return null;
	}
}
