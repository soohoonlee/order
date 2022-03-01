package dev.practice.order.domain.partner

import javax.persistence.*

@Entity
@Table(name = "partners")
class Partner(partnerName: String?, businessNo: String?, email: String?) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    private var partmerToken: String? = null

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
        if (partnerName == null) throw RuntimeException("empty partnerName")
        if (businessNo == null) throw RuntimeException("empty businessNo")
        if (email == null) throw RuntimeException("empty email")

        status = Status.ENABLE
    }
}