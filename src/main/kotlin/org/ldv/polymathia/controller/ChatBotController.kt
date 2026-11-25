package org.ldv.polymathia.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ChatBotController {

    // La page d'accueil (/) est maintenant gérée par ChatController (Sprint 1, Séance 2).

    // Formulaire de connexion -> http://localhost:8080/connexion
    @GetMapping("/connexion")
    fun connexion(): String {
        // Affiche le template src/main/resources/templates/auth/connexion.html
        return "auth/connexion"
    }

    // Envoi du formulaire de connexion : pas encore fonctionnel.
    // On revient sur la page de connexion avec un message d'information.
    // Au Sprint 2, Spring Security gérera la connexion et cette méthode sera supprimée.
    @PostMapping("/connexion")
    fun connexionPasEncoreDisponible(): String {
        return "redirect:/connexion?bientot=1"
    }
}