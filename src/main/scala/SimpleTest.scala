import org.apache.spark.sql.SparkSession

object SimpleTest {
  def main(args: Array[String]): Unit = {
    // Initialize Spark session with master URL
    val spark = SparkSession.builder()
      .appName("SimpleTest")
      .master("local[*]")  // Use all available cores
      .getOrCreate()

    // Create a simple DataFrame with two columns: "id" and "name"
    val data = Seq((1, "John"), (2, "Jane"), (3, "Doe"))
    val df = spark.createDataFrame(data).toDF("id", "name")

    // Show the DataFrame content
    df.show()

    // Stop Spark session
    spark.stop()
  }
}
