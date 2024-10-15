package jdbc;

import java.util.List;

public interface DAO {

	int insert(Product p);

	List<Product> selectList();
	
}
