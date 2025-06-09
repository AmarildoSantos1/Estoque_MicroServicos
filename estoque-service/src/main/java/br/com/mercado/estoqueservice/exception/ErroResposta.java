package br.com.mercado.estoqueservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErroResposta {
    private final String erro;
    private final String detalhes;
}
