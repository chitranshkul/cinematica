package com.esdproject.academiq.token;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<Token, Integer> {


//  static Token findBytoken(String jwtToken) {
//  }

  @Query("SELECT t FROM Token t WHERE t.token = :jwtToken")
  Optional<Token> findByToken(@Param("jwtToken") String jwtToken);

  @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<Token> findAllValidTokenByUser(Integer id);


}
