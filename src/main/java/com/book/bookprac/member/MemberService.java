package com.book.bookprac.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public String signup(SignupRequestDto signupRequestDto) {

        // email 중복확인
        membercheck(signupRequestDto.getEmail());

        // 저장 하기
        memberRepository.save(Member.builder().
                email(signupRequestDto.getEmail()).
                password(signupRequestDto.getPassword()).
                nickname(signupRequestDto.getNickname()).
                build());
        return "회원가입 성공";
    }

    @Transactional
    public String membercheck(String email) {
        Optional<Member> findMember = memberRepository.findByEmail(email);
        if (findMember.isEmpty()) {
            throw new RuntimeException("이메일 중복 예외입니다.");
        }

        return "사용가능한 이메일 입니다";
    }




}
