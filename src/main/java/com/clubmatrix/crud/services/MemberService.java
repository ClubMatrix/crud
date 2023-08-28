package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.Member;
import com.clubmatrix.crud.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  public Member saveMember(Member member) {
    return memberRepository.save(member);
  }

  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }
}
