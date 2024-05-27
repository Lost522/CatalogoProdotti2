package it.marconi.catalogoprodotti.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class prodotti {
    private String codice;
    private String nome;
    private String categoria;
    private int annoProduzione;
    private int quantità;
}
