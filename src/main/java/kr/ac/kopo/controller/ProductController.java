package kr.ac.kopo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.product.service.ProductService;
import kr.ac.kopo.product.vo.ProductVO;

@SessionAttributes({"userVO"})
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/manager/addProduct")
    public String addProductForm(HttpSession session) {
        Boolean isAdmin = ((MemberVO)session.getAttribute("userVO")).getType().equals("A");
        if (isAdmin) {
            return "manager/addproduct";  
        } else {
            return "errorPage";  
        }
    }

    @PostMapping("/manager/addProduct")
    public String addProduct(ProductVO product, HttpSession session) {
    	Boolean isAdmin = ((MemberVO)session.getAttribute("userVO")).getType().equals("A");
        if (isAdmin != null && isAdmin) {
            productService.addProduct(product);
            return "redirect:/";
        } else {
            return "errorPage";
        }
    }
    
    @GetMapping("/product/viewproduct")
    public String listProducts(HttpServletRequest req) {
        List<ProductVO> products = productService.getAllProducts();
        req.setAttribute("productList", products);
        return "product/viewproduct";
    }

    @GetMapping("/product/editproduct/{no}")
    public String editProductForm(@PathVariable("no") String no, HttpServletRequest req, HttpSession session) {
    	Boolean isAdmin = ((MemberVO)session.getAttribute("userVO")).getType().equals("A");
    	System.out.println((MemberVO)session.getAttribute("userVO"));
        if (isAdmin != true) {
            return "redirect:/errorPage"; // 관리자 권한이 없으면 오류 페이지로 리다이렉트
        }
        // productId를 이용해서 해당 상품 정보 조회
        ProductVO product = productService.selectProduct(no);
        if (product == null) {
            return "redirect:/errorPage"; // 상품이 존재하지 않으면 오류 페이지로 리다이렉트
        }
        req.setAttribute("product", product);
        return "product/editproduct";
    }

    // 금융상품 수정 처리
    @PostMapping("/product/editproduct/{no}")
    public String editProduct(ProductVO product, @PathVariable("no") String no,HttpSession session,HttpServletRequest req) {
    	try {
	    	MemberVO mb = (MemberVO) session.getAttribute("userVO");
	    	System.out.println(mb);
	        if (mb==null||mb.getType().equals("U")) {
	            return "redirect:/errorPage"; // 관리자 권한이 없으면 오류 페이지로 리다이렉트
	        }
	        // ProductService를 이용해서 상품 정보 수정
	        product.setNo(Integer.parseInt(no));
	        System.out.println(product);
	        productService.updateProduct(product);
	        return "redirect:/product/viewproduct"; // 수정 후 상품 조회 페이지로 리다이렉트
    	} catch (Exception e) {
    		product = productService.selectProduct(no);
    		req.setAttribute("product", product);
    		return "/product/editproduct"; // 수정 후 상품 조회 페이지로 리다이렉트
    	}
    }



}
