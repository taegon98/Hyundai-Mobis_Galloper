package com.server.service;

import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.repository.ManagerRepository;
import com.server.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;

    //회원가입
    @Transactional
    public Long join(Manager manager) {

        validateDuplicateUserId(manager);    //아이디 중복 검사
        managerRepository.save(manager);

        return manager.getId();
    }

    //아이디 중복 검사
    private void validateDuplicateUserId(Manager manager) {
        boolean usernameDuplicate = managerRepository.existsByUserId(manager.getUserId());
        if (usernameDuplicate) {
            throw new IllegalStateException("동일한 아이디가 이미 존재합니다.");
        }
    }

    //관리자 단건 조회 by PK
    public Manager findOne(Long id) {
        return managerRepository.findMemberById(id);
    }

    //관리자 단건 조회 by USERID
    public Manager findByUserId(String userId) {
        return managerRepository.findMemberByUserId(userId);
    }

    //회원 단건 조회 by TOKEN (car_serial #)
    public Manager findByTokenId(String token) {
        return managerRepository.findMemberByToken(token);
    }
}
