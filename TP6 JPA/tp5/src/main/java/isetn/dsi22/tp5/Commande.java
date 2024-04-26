package isetn.dsi22.tp5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Commande {
    
    @Autowired
    private CommandePetitDejeunerRepository commandeRepository;

    @GetMapping("/formulaire")
    public String afficherFormulaire(Model model) {
        model.addAttribute("commande", new PetitDejeuner());
        return "formulaire";
    }

    @PostMapping("/commande")
    public String traiterCommande(@ModelAttribute("commande") @Validated PetitDejeuner commande, BindingResult bindingResult, Model model) {
        // Vérifie s'il y a des erreurs de validation
        if (bindingResult.hasErrors()) {
            // S'il y a des erreurs, redirige vers le formulaire avec les erreurs
            return "formulaire";
        }

        // Si la validation réussit, sauvegarde la commande dans la base de données
        commandeRepository.save(commande);
        
        // Poursuit le traitement
        System.out.println(commande);
        model.addAttribute("commande", commande);
        return "recapitulatif";
    }
}
