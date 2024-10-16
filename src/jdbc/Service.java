package jdbc;

import java.util.List;

public interface Service {

	int insert(Product p);

	List<Product> getList();

	Product getProduct(int pno);

	int update(Product p);

	int delete(int pno);
	
}
