# 1. Create Maven Project
Select Java version
# 2. Add Scala Frameworks Support
Project, Add Frameworks Support
Download the proper framework
# 3. Update scala folder structure
Refact java to scala under both main and test
# 4. Copy the maven dependency
Reference https://mvnrepository.com/artifact/org.apache.spark/spark-core
# 5. Write scala code
create package com.henryjiang.spark, create SparkDemo Object
# 6. Generate Artifact
Project Structure, Artifacts, +, Jar, From modules with dependencies
Main Class: com.henryjiang.spark, extract to target JAR: src/main/resources
Rebuild the Artifact
# 7. Submit the job
spark-submit --executor-memory 1g --class com.emr602.spark.SparkFileDemo s3://henryjiang-nrt-0605/spark/jars/jar_emr602.jar s3://henryjiang-nrt-0605/spark/jars/sample.txt"
spark-submit --class com.emr602.spark.SparkFileDemo s3://henryjiang-nrt-0605/spark/jars/jar_emr602.jar s3://henryjiang-nrt-0605/spark/jars/sample.txt
# 8. Check result
aws s3 sync s3://henryjiang-nrt-0605/spark/jars/result/ ./result
cat ./result/part-00000

# Reference https://www.youtube.com/watch?v=PJAN-qqq6yY&t=716s
