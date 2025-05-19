package com.nhnacademy.daily.service;

import com.nhnacademy.daily.model.Member;
import com.nhnacademy.daily.model.MessagePayload;
import com.nhnacademy.daily.model.MessageSendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageSendService {

    private final MessageSendClient messageSendClient;

    public void sendJoinMessage(List<Member> members) {
        for (Member member : members) {
            String text = "신규 회원가입: " + member.getName();
            MessagePayload payload = new MessagePayload("알림봇", text);
            messageSendClient.sendMessage(payload);
        }
    }
}
