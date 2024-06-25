package kr.ac.kopo.product.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.product.vo.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProductVO> selectAllProducts() {
		List<ProductVO> products = sqlSession.selectList("dao.ProductDAO.selectAllProducts");
		return products;
	}

	@Override
	public List<String> selectAllProductNames() {
		List<String> products = sqlSession.selectList("dao.ProductDAO.selectAllProductNames");
		return products;
	}

	@Override
	public String selectProductType(int productNo) {
		ProductVO pro = new ProductVO();
		pro.setNo(productNo);
		return sqlSession.selectOne("dao.ProductDAO.selectProType", pro);
	}

	@Override
	public void insertProduct(ProductVO product) {
		sqlSession.insert("dao.ProductDAO.insertProduct", product);
	}

	@Override
	public void updateProduct(ProductVO pr) {
		sqlSession.update("dao.ProductDAO.updateProduct", pr);
	}

	@Override
	public ProductVO getProductById(int productId) {
		return sqlSession.selectOne("dao.ProductDAO.getProductById", productId);
	}

	@Override
	public ProductVO selectProduct(String productName) {
		System.out.println(productName);
		return sqlSession.selectOne("dao.ProductDAO.selectProduct", productName);
	}

	@Override
	public List<Integer> getProductByName(String productName) {
		System.out.println(productName);
		return sqlSession.selectList("dao.ProductDAO.selectByName", productName);
	}

	@Override
	public String selectProductName(Long accountNumber) {
		return sqlSession.selectOne("selectProductName", accountNumber);
	}
}
