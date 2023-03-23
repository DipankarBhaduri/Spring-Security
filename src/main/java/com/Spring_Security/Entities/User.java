package com.Spring_Security.Entities ;
import lombok.AllArgsConstructor ;
import lombok.Builder ;
import lombok.Data;
import lombok.NoArgsConstructor ;
import javax.persistence.* ;

@Entity
@AllArgsConstructor
@Builder
@Data
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int id ;

    private String name ;
    private String password ;
    private String email ;
}
