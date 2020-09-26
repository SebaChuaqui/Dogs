package retrofit

import com.google.gson.annotations.SerializedName

data class DataBavausList (

    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String

)