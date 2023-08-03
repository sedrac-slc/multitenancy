package com.example.multitenancy.config

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.io.IOException


@Component
internal class TenantFilter : Filter {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse?, chain: FilterChain) {
        val req = request as HttpServletRequest
        val tenantName = req.getHeader("X-TenantID")
        TenantContext.setCurrentTenant(tenantName ?: "tenant_1" )
        try {
            chain.doFilter(request, response)
        } finally {
            TenantContext.setCurrentTenant("")
        }
    }
}