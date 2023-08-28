package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
