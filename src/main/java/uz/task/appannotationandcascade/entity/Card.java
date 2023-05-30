package uz.task.appannotationandcascade.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.task.appannotationandcascade.entity.enums.PlasticType;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 3)
    private String cvv;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    @NotNull
    @Size(min = 4, max = 4)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PlasticType plasticType;

    @Column(name = "card_number", nullable = false, length = 16, unique = true)
    private String cardNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "card_validity", nullable = false)
    private LocalDate cardValidity;

    public Instant getExpirationDate() {
        return null;
    }

    public void setActive(boolean b) {

    }

    public void setExpirationDate(Instant expirationDate) {

    }

    public Card getBank() {
        return null;
    }

    public boolean getCvv() {
        return false;
    }

    public boolean getLastName() {
        return false;
    }

    public boolean getFirstName() {
        return false;
    }

    public Object getPassword() {
        return null;
    }

    public void setPassword(Object password) {

    }

    public boolean getPlasticType() {
        return false;
    }
}
