package org.ldv.polymathia.model.dao

import org.ldv.polymathia.model.entity.ModeleIA
import org.springframework.data.jpa.repository.JpaRepository

interface ModeleIADAO : JpaRepository<ModeleIA, Long> {
}