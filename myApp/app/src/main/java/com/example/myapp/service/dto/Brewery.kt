package com.example.myapp.service.dto

import com.google.gson.annotations.SerializedName

data class Brewery(
    val id: String?,
    val name: String?,
    @SerializedName("brewery_type")
    val type: String?,
    val street: String?,
    @SerializedName("address_2")
    val add2: String?,
    @SerializedName("address_3")
    val add3: String?,
    val city: String?,
    val state: String?,
    @SerializedName("county_province")
    val countyProvince: String?,
    @SerializedName("postal_code")
    val zipCode: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    @SerializedName("website_url")
    val siteURL: String?,
    @SerializedName("updated_at")
    val lastUpdated: String?,
    @SerializedName("created_at")
    val createdAt: String?
){

}
