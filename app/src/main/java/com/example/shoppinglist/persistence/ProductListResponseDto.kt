package com.example.shoppinglist.persistence

data class ProductListResponseDto(val success: Boolean, val body: Array<ProductDto>) {
    // Generated methods
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductListResponseDto

        if (success != other.success) return false
        if (!body.contentEquals(other.body)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = success.hashCode()
        result = 31 * result + body.contentHashCode()
        return result
    }
}