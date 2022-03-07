package dev.practice.order.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.ZonedDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class AbstractEntity {

    @CreationTimestamp
    var createdAt: ZonedDateTime = ZonedDateTime.now()
        private set

    @UpdateTimestamp
    var updatedAt: ZonedDateTime = ZonedDateTime.now()
        private set
}