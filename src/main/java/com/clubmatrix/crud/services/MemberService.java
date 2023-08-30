package com.clubmatrix.crud.services;

import com.clubmatrix.crud.dto.MemberRequestDTO;
import com.clubmatrix.crud.dto.MemberResponseDTO;
import com.clubmatrix.crud.models.Address;
import com.clubmatrix.crud.models.Login;
import com.clubmatrix.crud.models.Member;
import com.clubmatrix.crud.repositories.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  @Autowired
  private LoginService loginService;

  @Autowired
  private AddressService addressService;

  public MemberResponseDTO registerMember(MemberRequestDTO memberDTO) {
    Address address = addressService.saveAddress(
        new Address(memberDTO.street, memberDTO.city, memberDTO.state, memberDTO.postalCode, memberDTO.country));
    Login login = loginService
        .saveLogin(new Login(memberDTO.name, memberDTO.email, memberDTO.password, memberDTO.phone, address));

    Member savedMember = memberRepository.save(new Member(login, memberDTO.paymentDetails, Member.Status.ACTIVE));
    return convertToDTO(savedMember);
  }

  public List<MemberResponseDTO> getAllMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  private MemberResponseDTO convertToDTO(Member member) {
    return new MemberResponseDTO(
        member.getId(),
        member.getLogin().getName(),
        member.getLogin().getEmail(),
        member.getLogin().getPhone(),
        member.getLogin().getAddress().getStreet(),
        member.getLogin().getAddress().getCity(),
        member.getLogin().getAddress().getState(),
        member.getLogin().getAddress().getPostalCode(),
        member.getLogin().getAddress().getCountry(),
        member.getPaymentDetails(),
        member.getStatus());
  }
}
