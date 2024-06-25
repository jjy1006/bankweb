package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.ac.kopo.account.service.AccountService;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.product.vo.ProductVO;
import kr.ac.kopo.transaction.vo.TransactionVO;

@SessionAttributes({"userVO"})
@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account/deposit")
	public String depositForm(HttpSession ses) {//계좌번호,입금액
		MemberVO cm = (MemberVO)ses.getAttribute("userVO");
		return cm==null? "member/login":"account/depositForm";
	}
	@PostMapping("/account/deposit")
	public String deposit(@RequestParam("amount") Long amount,@RequestParam("accNum") String accNum) {//계좌번호,입금액
		return accountService.deposit(accNum, amount) ? "account/depositSuccess":"account/depositForm";
	}
	
	
	@GetMapping("/account/sendMoney")
	public String sendMoneyForm(HttpSession ses) {//계좌번호,입금액
		MemberVO cm = (MemberVO)ses.getAttribute("userVO");
		return cm==null? "member/login":"account/sendMoneyForm";
	}
	@PostMapping("/account/sendMoney")//@RequestParam("a") Long a,
	public String sendMoney(HttpSession ses,@RequestParam("amount") Long amount,
			@RequestParam("senderAccNum") String senderAccNum,
			@RequestParam("receiverAccNum") String receiverAccNum,
			@RequestParam("PW") String PW){//보내는 계좌번호,받는 계좌번호,이체액,비밀번호
		
		System.out.println("이체 : "+senderAccNum+", "+receiverAccNum+", "+amount+", "+PW);//"이체 : "+senderAccNum+", "+receiverAccNum+", ",amount
		return accountService.sendMoney(Long.parseLong(senderAccNum),
				Long.parseLong(receiverAccNum), amount, PW,
				((MemberVO)ses.getAttribute("userVO")).getId())
				? "account/sendMoneySuccess":"account/sendMoneyForm";
	}

	@GetMapping("/account/withdraw")
    public String withdraw() {
        return "account/withdraw";
    }

	@PostMapping("/account/withdraw")
	public String withdrawForm(@RequestParam("amount") int amount, @RequestParam("accNum") String accNum, HttpServletRequest request) {
	    boolean success = accountService.withdraw(accNum, amount);
	    if (success) {
	        double newBalance;
	        try {
	            newBalance = accountService.getBalance(accNum);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "member/errorPage";
	        }
	        HttpSession session = request.getSession();
	        session.setAttribute("accNum", accNum);
	        session.setAttribute("amount", amount);
	        session.setAttribute("newBalance", newBalance);
	        
	        // 출금 성공 시 거래 로그 추가
	        /*try {
	            accountService.addTransactionLog("Withdraw", accNum, null, amount, new Date());
	        } catch (Exception e) {
	            e.printStackTrace();
	            // 거래 로그 추가 실패 시, 따로 처리 가능
	        }*/
	        
	        return "account/Successwithdraw";
	    } else {
	        return "/account/withdraw";
	    }
	}
	
	
	@GetMapping("/account/open")
	public String open(HttpServletRequest req) {
		List<ProductVO> pros = accountService.selectProducts();
		req.setAttribute("products", pros);
		return "account/open";
	}
	@PostMapping("/account/open")
	public String openAccount(AccountVO acc,HttpServletRequest req) throws Exception {
		System.out.println("acc : "+acc);
		System.out.println("acc : "+req.getParameter("productName"));
		HttpSession sesn = req.getSession();
		MemberVO cm = (MemberVO) sesn.getAttribute("userVO");
		if(cm==null)	return "/member/login";

		String accNum;
		do {
			accNum = generateAccountNumber();
		}while(!accountService.checkAccNum(accNum));
		
		int proNo = accountService.getProductNo((String)req.getParameter("productName"));
		acc.setProductNo(proNo);
		acc.setAccountNumber(accNum);
		acc.setOnwerId(cm.getId());
		
		accountService.openAccount(acc);
		return "redirect:/";
	}
	
	private String generateAccountNumber() {
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < 16; i++) {
	        sb.append(random.nextInt(10)); // 0-9 사이의 난수를 추가
	    }
	    return sb.toString();
	}
	
	@GetMapping("/account")
	public String selectAll(HttpServletRequest req,HttpSession ses) {
		MemberVO cm = (MemberVO) ses.getAttribute("userVO");
		if(cm==null) {	return "member/login";	}
		String id = cm.getId();
		List<AccountVO> accounts = accountService.selectAllAccount(id);
		List<String> proNames = new ArrayList<String>();
		for(AccountVO acc:accounts) {
			String name = accountService.selectProductName(Long.parseLong(acc.getAccountNumber()));
			proNames.add(name);
		}
		req.setAttribute("accountList", accounts);
		req.setAttribute("productList", proNames);
		return "account/selectAllAcc";
	}
	
	@GetMapping("/account/{accountNumber}")
	public String selectOne(@PathVariable("accountNumber") Long accountNumber,HttpServletRequest req) throws Exception{
		
		Map<String, Object> transAndAcc = accountService.selectTransacionList(accountNumber);
		AccountVO account = (AccountVO) transAndAcc.get("account");
		List<TransactionVO> Trans = (List<TransactionVO>) transAndAcc.get("trans");
		System.out.println("detailAcc : "+account);
		String productName = accountService.selectProductName(accountNumber);
		req.setAttribute("account", account);
		req.setAttribute("productName", productName);
		req.setAttribute("transactionList", Trans);
		return "account/selectacc";
	}

	@GetMapping("/account/product")
	public String viewproduct() throws Exception{
		return "product/viewproduct";
	}
}
