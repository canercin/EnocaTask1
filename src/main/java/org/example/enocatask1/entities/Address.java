package org.example.enocatask1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"addresses", "hibernateLazyInitializer"})
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Address(String address, User user) {
        this.address = address;
        this.user = user;
    }
}
