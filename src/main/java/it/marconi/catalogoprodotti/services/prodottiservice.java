package it.marconi.catalogoprodotti.services;

import java.util.ArrayList;
import java.util.List;

public class prodottiservice {
    private List<Prodotto> prodottiCatalogo = new ArrayList<>();

    public List<Prodotto> getProdottiCatalogo() {
        return prodottiCatalogo;
    }
    public void aggiungiProdotto(Prodotto prodotti) {
        prodottiCatalogo.add(prodotto);
    }
    
    public void svuotaCatalogo() {
        prodottiCatalogo.clear();
    }
    
    public void eliminaProdotto(String codice) {
        prodottiCatalogo.removeIf(prodotto -> prodotto.getCodice().equals(codice));
    }
    
    public Prodotto trovaProdottoPerCodice(String codice) {
        return prodottiCatalogo.stream()
                .filter(prodotto -> prodotto.getCodice().equals(codice))
                .findFirst()
                .orElse(null);
    }
}
