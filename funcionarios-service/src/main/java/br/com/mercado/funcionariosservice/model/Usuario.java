package br.com.mercado.funcionariosservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataAdmissao;

    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private Setor setor;
}
