package com.example.model

data class EmsRestrictedArea(
    val id: String,
    val name: String,
    val icon: String,
    val note: String,
    val articleRef: String = "13.1"
)

data class EmsWarningStep(
    val stepNumber: Int,
    val title: String,
    val description: String,
    val badge: String? = null,
    val icon: String
)

data class EmsCommonCrime(
    val articleId: String,
    val icon: String,
    val violation: String,
    val levelCode: String,
    val stars: Int
)

data class EmsMelamunStep(
    val stepNumber: Int,
    val title: String,
    val description: String,
    val tag: String? = null,
    val isWarning: Boolean = false,
    val isSuccess: Boolean = false
)

data class UupRule(
    val code: String,
    val fullName: String,
    val category: String,
    val description: String,
    val penaltyMinutes: Int,
    val icon: String
)
