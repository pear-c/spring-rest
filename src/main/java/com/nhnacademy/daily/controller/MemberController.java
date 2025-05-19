package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMember(@PathVariable String id) {
        Member member = memberService.getMember(id);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getAllMembers(Pageable pageable) {
        List<Member> members = memberService.getMemberList();
        return ResponseEntity.ok(members);
    }
}
