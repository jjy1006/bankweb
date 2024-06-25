package kr.ac.kopo.product.dao;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.product.vo.ProductVO;

public interface ProductDAO {

	List<ProductVO> selectAllProducts();

	String selectProductType(int no);

	void insertProduct(ProductVO product);

	List<String> selectAllProductNames();

	ProductVO getProductById(int productId);

	ProductVO selectProduct(String productName);

	void updateProduct(ProductVO product);

	List<Integer> getProductByName(String productName);

	String selectProductName(Long accountNumber);
}
