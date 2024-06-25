package kr.ac.kopo.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.product.dao.ProductDAO;
import kr.ac.kopo.product.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDao;

	@Override
	public void addProduct(ProductVO product) {
		productDao.insertProduct(product);
	}

	@Override
	public List<ProductVO> getAllProducts() {
		return productDao.selectAllProducts();
	}

	@Override
	public void updateProduct(ProductVO product) {
		productDao.updateProduct(product);
	}

	@Override
	public ProductVO getProductById(int productId) {
		return productDao.getProductById(productId);
	}

	@Override
	public ProductVO selectProduct(String productName) {
		return productDao.selectProduct(productName);
	}

}
