package org.ldv.polymathia.service

import org.ldv.polymathia.model.entity.ModeleIA

interface IAService {
    // Identifie le fournisseur pris en charge
    fun getFournisseur(): String

    // Envoie un prompt au modèle choisi
    fun envoyerPrompt(prompt: String, modele: ModeleIA): String
}