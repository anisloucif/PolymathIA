package org.ldv.polymathia.model.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class FournisseurIA (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null,
    var nom: String,
    var description: String,
    var cheminLogo: String,

    //Association avec ModeleIA
    @OneToMany(mappedBy = "fournisseurIA", cascade = [CascadeType.ALL], orphanRemoval = true)
    var modeles: MutableList<ModeleIA> = mutableListOf(),
){
}