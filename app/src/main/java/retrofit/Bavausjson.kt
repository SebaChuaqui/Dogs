package retrofit


import com.google.gson.annotations.SerializedName

data class Bavausjson(
    @SerializedName("message")
    val message: List<String>,
    @SerializedName("status")
    val status: String
)