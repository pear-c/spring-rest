package com.nhnacademy.daily.service;

import com.nhnacademy.daily.exception.ResourceNotFoundException;
import com.nhnacademy.daily.model.Locale;
import com.nhnacademy.daily.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {
    private Map<String, Member> memberMap;

    public MemberService() {
        this.memberMap = new HashMap<>();
        Member member = new Member("1", "유재석",  50, "A", Locale.KO);
        memberMap.put(member.getId(), member);
    }

    public Member getMember(String id){
        //TODO
        if(!memberMap.containsKey(id)){
            throw new ResourceNotFoundException();
        }
        return memberMap.get(id);
    }

    public List<Member> getMemberList() {
        return new ArrayList<>(memberMap.values());
    }
}
