package jdbcStudent;

import java.util.List;

public interface Service {

	int insert(Student s);

	List<Student> getList();

	List<Student> getStudent(String name);

	int update(Student s);

	int delete(int num);

}
