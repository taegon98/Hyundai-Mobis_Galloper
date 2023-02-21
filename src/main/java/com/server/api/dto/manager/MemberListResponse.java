package com.server.api.dto.manager;

import com.server.domain.Manager;
import com.server.domain.Member;
import lombok.Data;
@Data
public class MemberListResponse {
    private String name;
    private String userId;
    private String telephone;
    private String childName;
    private String token;

    public MemberListResponse(Member member) {
        this.name = member.getName();
        this.userId = member.getUserId();
        this.telephone = member.getTelephone();
        this.childName = member.getChildName();
        this.token = member.getToken();
    }

    public static MemberListResponse toDTO(Member member) {
        return new MemberListResponse(member);
    }
}
