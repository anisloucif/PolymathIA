package org.ldv.polymathia.model.dao

import org.ldv.polymathia.model.entity.Conversation
import org.springframework.data.jpa.repository.JpaRepository

interface ConversationDAO : JpaRepository<Conversation, Long> {
    fun findAllByOrderByDateModificationDesc(): List<Conversation>
}