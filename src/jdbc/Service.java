package jdbc;

import java.util.List;

public interface Service {

	int insert(Product p);

	List<Product> getList();
	
}
