package br.com.mercado.estoqueservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigoBarras;
    private int quantidadeInicial;
    private double precoCusto;
    private double precoVenda;

    
    private long fornecedorId; 

    private long categoriaId; 

    private String unidadeMedida;
    private LocalDate dataEntrada;
}
