package kz.aibek.nightclub.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;
}
