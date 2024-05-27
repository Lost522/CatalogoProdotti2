package it.marconi.catalogoprodotti.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.marconi.catalogoprodotti.services.Prodotto;

import java.util.List;


@Controller
@RequestMapping("/prodotti")
public class prodottiControllers {
    @Autowired
    private ProdottiService prodottiService;

    @GetMapping
    public String visualizzaCatalogo(Model model) {
        List<Prodotto> prodottiCatalogo = prodottiService.getProdottiCatalogo();
        model.addAttribute("prodottiCatalogo", prodottiCatalogo);
        model.addAttribute("nuovoProdotto", new Prodotto());
        return "catalogo";
    }

    @PostMapping("/nuovo")
    public String aggiungiProdotto(@ModelAttribute("nuovoProdotto") Prodotto nuovoProdotto) {
        prodottiService.aggiungiProdotto(nuovoProdotto);
        return "redirect:/catalogo";
    }

    @GetMapping("/{codice}")
    public String visualizzaDettagli(@PathVariable("codice") String codice, Model model) {
        Prodotto prodotto = prodottiService.trovaProdottoPerCodice(codice);
        model.addAttribute("prodotto", prodotto);
        return "dettagli";
    }

    @PostMapping("/{codice}/elimina")
    public String eliminaProdotto(@PathVariable("codice") String codice) {
        prodottiService.eliminaProdotto(codice);
        return "redirect:/catalogo";
    }
}
