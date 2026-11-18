package org.ldv.polymathia.model.dao

import org.ldv.polymathia.model.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageDAO : JpaRepository<Message, Long> {
}