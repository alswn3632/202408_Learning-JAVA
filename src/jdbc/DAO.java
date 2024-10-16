package jdbc;

import java.util.List;

public interface DAO {

	int insert(Product p);

	List<Product> selectList();

	Product selectProduct(int pno);

	int update(Product p);

	int delete(int pno);
	
}
