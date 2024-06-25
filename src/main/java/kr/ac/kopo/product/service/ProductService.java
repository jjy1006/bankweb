package kr.ac.kopo.product.service;


import java.util.List;
import java.util.Map;

import kr.ac.kopo.product.vo.ProductVO;

public interface ProductService {
	
	void addProduct(ProductVO product);

	List<ProductVO> getAllProducts();

	ProductVO getProductById(int productId);

	ProductVO selectProduct(String productName);

	public void updateProduct(ProductVO product);
}
