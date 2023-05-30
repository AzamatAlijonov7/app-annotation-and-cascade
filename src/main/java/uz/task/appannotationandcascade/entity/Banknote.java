package uz.task.appannotationandcascade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "banknotes")
public class Banknote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal denomination;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "atm_id", nullable = false)
    private Atm atm;

}
