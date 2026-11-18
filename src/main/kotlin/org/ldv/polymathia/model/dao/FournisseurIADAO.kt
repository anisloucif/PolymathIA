package org.ldv.polymathia.model.dao

import org.ldv.polymathia.model.entity.FournisseurIA
import org.springframework.data.jpa.repository.JpaRepository

interface FournisseurIADAO : JpaRepository<FournisseurIA, Long> {
}