package org.ldv.polymathia.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class ModeleIA (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    var nom: String,
    var identifiantApi: String,
    var urlApi: String,
    var description: String,
    var cheminLogo: String,

    //Association avec FournisseurIA (ModeleIA est le maitre de l'association)
    @ManyToOne
    @JoinColumn(name = "fournisseur_ia_id")
    var fournisseurIA: FournisseurIA? = null,

    //Association avec Conversation
    @OneToMany(mappedBy = "modeleIA", cascade = [CascadeType.ALL], orphanRemoval = true)
    var conversations: MutableList<Conversation> = mutableListOf(),
){
}