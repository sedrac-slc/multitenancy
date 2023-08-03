package com.example.multitenancy.config

class TenantContext {
    companion object {
        private val CURRENT_TENANT: ThreadLocal<String> =  ThreadLocal();

        fun getCurrentTenant() =CURRENT_TENANT.get()

        fun setCurrentTenant(tenant: String = "tenant_1" ) = CURRENT_TENANT.set(tenant)

        fun clear() = CURRENT_TENANT.remove()

    }
}