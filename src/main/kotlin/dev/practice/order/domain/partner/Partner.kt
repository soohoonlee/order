package dev.practice.order.domain.partner

import dev.practice.order.common.util.TokenGenerator
import dev.practice.order.domain.AbstractEntity
import org.springframework.util.StringUtils
import javax.persistence.*

private const val PREFIX_PARTNER = "ptn_"

@Entity
@Table(name = "partners")
class Partner(partnerName: String?, businessNo: String?, email: String?) : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var partnerToken: String
        private set
    var partnerName: String?
        private set
    var businessNo: String?
        private set
    var email: String?
        private set

    @Enumerated(EnumType.STRING)
    private var status: Status? = null

    enum class Status(val description: String) {
        ENABLE("활성화"), DISABLE("비활성화")
    }

    fun enable() {
        status = Status.ENABLE
    }

    fun disable() {
        status = Status.DISABLE
    }

    init {
        if (!StringUtils.hasText(partnerName)) throw RuntimeException("empty partnerName")
        if (!StringUtils.hasText(businessNo)) throw RuntimeException("empty businessNo")
        if (!StringUtils.hasText(email)) throw RuntimeException("empty email")

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER)
        this.partnerName = partnerName
        this.businessNo = businessNo
        this.email = email
        this.status = Status.ENABLE
    }
}