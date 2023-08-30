package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.dto.MemberRequestDTO;
import com.clubmatrix.crud.dto.MemberResponseDTO;
import com.clubmatrix.crud.services.MemberService;
import com.clubmatrix.crud.utils.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/members")
public class MemberController {

  @Autowired
  private MemberService memberService;

  @Autowired
  private AuthUtil authUtil;

  @PostMapping
  public ResponseEntity<?> registerMember(@RequestBody MemberRequestDTO memberDTO, HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "edit_members")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    MemberResponseDTO registeredMember = memberService.registerMember(memberDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredMember);
  }

  @GetMapping
  public ResponseEntity<?> getAllMembers(HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "view_members")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    List<MemberResponseDTO> members = memberService.getAllMembers();
    return ResponseEntity.ok(members);
  }
}
