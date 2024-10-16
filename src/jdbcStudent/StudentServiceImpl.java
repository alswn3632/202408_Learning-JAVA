package jdbcStudent;

import java.util.List;

public class StudentServiceImpl implements Service {
	
	private DAO dao;
	
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
	}
	
	@Override
	public int insert(Student s) {
		// (1) 학생 등록
//		System.out.println("insert ServiceImpl success!");
		return dao.insert(s);
	}

	@Override
	public List<Student> getList() {
		// (2) 학생 목록
//		System.out.println("getList ServiceImpl success!");
		return dao.getList();
	}

	@Override
	public List<Student> getStudent(String name) {
		// (3) 학생 검색
//		System.out.println("getStudent ServiceImpl success!");
		return dao.getStudent(name);
	}

	@Override
	public int update(Student s) {
		// (4) 학생 정보 수정
//		System.out.println("update ServiceImpl success!");
		return dao.update(s);
	}

	@Override
	public int delete(int num) {
		// (5) 학생 정보 삭제
//		System.out.println("delete ServiceImpl success!");
		return dao.delete(num);
	}

}
