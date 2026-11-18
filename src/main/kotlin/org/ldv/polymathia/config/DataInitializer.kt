package org.ldv.polymathia.config

import org.ldv.polymathia.model.dao.FournisseurIADAO
import org.ldv.polymathia.model.dao.ModeleIADAO
import org.ldv.polymathia.model.entity.FournisseurIA
import org.ldv.polymathia.model.entity.ModeleIA
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer(
    private val fournisseurIADAO: FournisseurIADAO,
    private val modeleIADAO: ModeleIADAO
) {

    @Bean
    fun initData() = CommandLineRunner {

        // Vérifier si le fournisseur Mistral existe déjà
        val mistral = fournisseurIADAO.findAll()
            .firstOrNull { it.nom == "Mistral" }
            ?: fournisseurIADAO.save(
                FournisseurIA(
                    nom = "Mistral",
                    cheminLogo = "/img/mistral.png",
                    description = "Fournisseur français de modèles d'intelligence artificielle."
                )
            )
        val gemini = fournisseurIADAO.findAll()
            .firstOrNull { it.nom == "Gemini" }
            ?: fournisseurIADAO.save(
                FournisseurIA(
                    nom = "Gemini",
                    cheminLogo = "/img/gemini.png",
                    description = "Modèles d'intelligence artificielle de Google."
                )
            )

        // Modèles à initialiser
        val modeles = listOf(
            ModeleIA(
                nom = "gemini-3.8-flash",
                identifiantApi = "gemini-3.8-flash",
                urlApi = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.8-flash:generateContent",
                description = "Modèle rapide et polyvalent.",
                cheminLogo = "/img/gemini.png",
                fournisseurIA = gemini
            ),

            ModeleIA(
                nom = "gemini-3.5-flash-lite",
                identifiantApi = "gemini-3.5-flash-lite",
                urlApi = "https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash-lite:generateContent",
                description = "Modèle rapide pour les tâches simples.",
                cheminLogo = "/img/gemini.png",
                fournisseurIA = gemini
            ),
            ModeleIA(
                nom = "mistral-small-latest",
                identifiantApi = "mistral-small-latest",
                urlApi = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle léger pour les conversations et les tâches courantes.",
                cheminLogo = "/img/mistral.png",
                fournisseurIA = mistral
            ),

            ModeleIA(
                nom = "mistral-medium-latest",
                identifiantApi = "mistral-medium-latest",
                urlApi = "https://api.mistral.ai/v1/chat/completions",
                description = "Modèle plus avancé pour les tâches complexes.",
                cheminLogo = "/img/mistral.png",
                fournisseurIA = mistral
            )
        )

        // Éviter de recréer les modèles à chaque démarrage
        for (modele in modeles) {
            val existe = modeleIADAO.findAll()
                .any { it.nom == modele.nom }

            if (!existe) {
                modeleIADAO.save(modele)
            }
        }
    }
}