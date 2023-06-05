package com.hunbk.shop.controller;

import com.hunbk.shop.domain.AuthInfo;
import com.hunbk.shop.domain.Member;
import com.hunbk.shop.dto.member.LoginForm;
import com.hunbk.shop.dto.member.SignupForm;
import com.hunbk.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupForm", new SignupForm());
        return "members/signupForm";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute SignupForm signupForm,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasFieldErrors()) {
            //비밀번호 재확인 불일치
            if (!signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
                bindingResult.rejectValue("passwordCheck", "notSame", "비밀번호가 일치하지 않습니다.");
            }
            if (memberService.existsId(signupForm.getId())) {
                bindingResult.rejectValue("id", "exists", "이미 사용중인 아이디입니다.");
            }
            if (memberService.existsEmail(signupForm.getEmail())) {
                bindingResult.rejectValue("email", "exists", "이미 사용중인 이메일입니다.");
            }
        }
        if (bindingResult.hasErrors()) {
            return "members/signupForm";
        }

        Member signupMember = memberService.signup(signupForm);

        redirectAttributes.addFlashAttribute("signupMemberName", signupMember.getName());
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "members/loginForm";
        }

        AuthInfo authInfo = memberService.login(loginForm);
        if (authInfo == null) {
            bindingResult.reject("idOrPasswordMismatch", "아이디 또는 비밀번호가 일치하지 않습니다. 입력하신 내용을 다시 확인해주세요.");
            return "members/loginForm";
        }
        log.info("authInfo.memberNo={}", authInfo.getMemberNo());

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.AUTH_INFO, authInfo);

        return "redirect:/";
    }
}
