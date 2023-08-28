package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.models.Member;
import com.clubmatrix.crud.services.MemberService;
import com.clubmatrix.crud.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

  @Autowired
  private MemberService memberService;

  @Autowired
  private AuthUtil authUtil;

  @PostMapping
  public Member registerMember(@RequestBody Member member, @RequestHeader("Authorization") String token) {
    if (authUtil.validateToken(token) && authUtil.hasPermission(token, "register_member")) {
      return memberService.saveMember(member);
    }

    return null;
  }

  @GetMapping
  public List<Member> getAllMembers(@RequestHeader("Authorization") String token) {
    if (authUtil.validateToken(token) && authUtil.hasPermission(token, "view_members")) {
      return memberService.getAllMembers();
    }

    return null;
  }
}
