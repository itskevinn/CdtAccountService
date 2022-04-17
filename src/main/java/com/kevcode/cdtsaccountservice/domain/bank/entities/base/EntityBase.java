package com.kevcode.cdtsaccountservice.domain.bank.entities.base;


import javax.persistence.*;

@MappedSuperclass
public class EntityBase {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
