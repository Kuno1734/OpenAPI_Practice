package com.book.bookprac.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;


    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto signupRequestDto){
        return memberService.signup(signupRequestDto);
    }


    @PostMapping("/signup/membercheck")
    public String membercehck(@RequestParam String email) {
        return memberService.membercheck(email);

    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        return memberService.login(loginRequestDto);
    }
}
