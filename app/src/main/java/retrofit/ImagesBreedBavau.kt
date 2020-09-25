package retrofit


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "bavaus_images_table")
data class ImagesBreedBavau(
    @PrimaryKey (autoGenerate = true)
    @NonNull
    val id: Int = 0,
    val dog:  String,
    val imageUrl: String,
    val status: Boolean
)