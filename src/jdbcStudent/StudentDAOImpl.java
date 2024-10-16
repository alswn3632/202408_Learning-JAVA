package jdbcStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements DAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public StudentDAOImpl() {
		// DatabaseConnection에서 생성한 Connection 객체를 가져와 연결
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	@Override
	public int insert(Student s) {
		// (1) 학생 등록
//		System.out.println("insert DAOImpl success!");
		query = "insert into student(st_name, st_num, st_birth, st_phone, st_addr) values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getSt_name());
			pst.setString(2, s.getSt_num());
			pst.setString(3, s.getSt_birth());
			pst.setString(4, s.getSt_phone());
			pst.setString(5, s.getSt_addr());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAOImpl insert error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> getList() {
		// (2) 학생 목록
//		System.out.println("getList DAOImpl success!");
		query = "select st_id, st_num, st_name, st_phone from student";
		List<Student> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Student(rs.getInt("st_id"), rs.getString("st_num"), rs.getString("st_name"), rs.getString("st_phone")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("DAOImpl getList error!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Student> getStudent(String name) {
		// (3) 학생 검색
//		System.out.println("getStudent DAOImpl success!");
		query = "select * from student where st_name = ?";
		List<Student> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Student(rs.getInt("st_id"), 
						rs.getString("st_num"), 
						rs.getString("st_name"), 
						rs.getString("st_birth"),
						rs.getString("st_phone"),
						rs.getString("st_addr"),
						rs.getString("st_regdate")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("DAOImpl getStudent error!");
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public int update(Student s) {
		// (4) 학생 정보 수정
//		System.out.println("update DAOImpl success!");
		query = "update student set st_phone = ?, st_addr = ? where st_id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, s.getSt_phone());
			pst.setString(2, s.getSt_addr());
			pst.setInt(3, s.getSt_id());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAOImpl update error!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int num) {
		// (5) 학생 정보 삭제
//		System.out.println("delete DAOImpl success!");
		query = "delete from student where st_id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, num);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DAOImpl delete error!");
			e.printStackTrace();
		}
		return 0;
	}


}
