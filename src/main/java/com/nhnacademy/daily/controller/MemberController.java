package com.nhnacademy.daily.controller;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.service.MemberService;
import com.nhnacademy.daily.service.MessageSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MessageSendService messageSendService;

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

    @PostMapping("/members")
    public ResponseEntity<List<Member>> registerMember(@RequestBody List<Member> members) {
        memberService.addMembers(members);
        messageSendService.sendJoinMessage(members);
        return ResponseEntity.ok(members);
    }
}
