package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes({"userVO"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/errorPage")
	public String error() {
		return "errorPage";
	}
	@GetMapping("/member/login")
    public String loginForm() {
        return "member/login";
    }

	@PostMapping("/member/login")
	public String login(MemberVO member, HttpServletRequest request) throws Exception {
	    HttpSession session = request.getSession();

	    // 사용자 로그인 시도
	    MemberVO loginVO = memberService.login(member);

	    if (loginVO != null) {
	        session.setAttribute("userVO", loginVO);
	        // 관리자 체크
	        if (loginVO.getType() == "U") { 
	            System.out.println("관리자 로그인 : " + session.getAttribute("userVO"));
	        } else {
	            System.out.println("일반 사용자 로그인 : " + session.getAttribute("userVO"));
	        }
	        return "redirect:/";
	    }

	    // 로그인 실패
	    return "member/re_login";
	}

	
	@GetMapping("/member/logout")
	public String logout(HttpSession session,SessionStatus stus) {
		stus.setComplete();
		//System.out.println(""+session.getAttribute("userVO"));
		return "redirect:/";
	}
	
	@GetMapping("/member/delete")
    public String showDeleteForm(HttpSession session, HttpSession ses) {
        MemberVO userVO = (MemberVO) session.getAttribute("userVO");
        if (userVO != null) {
            ses.setAttribute("userVO", userVO);
            ses.removeAttribute("errorMessage");
            return "member/deletecustomer";
        } else {
            return "redirect:/"; // 사용자 정보가 없는 경우, 홈으로 리다이렉트
        }
    }
	@PostMapping("/member/delete")
    public String deleteMember(@RequestParam("password") String password, HttpSession ses, SessionStatus stus) {
        try {
            MemberVO userVO = (MemberVO) ses.getAttribute("userVO");
            if (userVO != null) {
                // 비밀번호 확인 로직 추가
                if (memberService.checkPassword(userVO.getId(), password)) {
                    memberService.deleteCustomer(userVO.getId());
                    stus.setComplete();
                    return "redirect:/"; // 홈으로 리다이렉트
                } else {
                    // 비밀번호가 일치하지 않으면 다시 삭제 확인 페이지로
                    ses.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
                    ses.setAttribute("userVO", userVO);
                    return "member/deletecustomer";
                }
            } else {
                return "redirect:/"; // 사용자 정보가 없는 경우, 홈으로 리다이렉트
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }
    }
	
	@GetMapping("/member/signup")
	public String signupForm() {
		return "member/signup";
	}
	@PostMapping("/member/signup")
	public String signup(MemberVO member, HttpServletRequest request) throws Exception {
		System.out.println(member);
		if(!memberService.signup(member)) {
			// 회원가입 실패
			request.setAttribute("msg", "ID 중복");
			return "member/re_signup";
		} else {
			// 회원가입 성공
//			System.out.println(session.getAttribute("userVO"));
			return "redirect:/member/login";
		}
	}
}

