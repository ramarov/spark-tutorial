package org.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext



object WordCount {
  System.setProperty("hadoop.home.dir","c://winutils")
  
   def main(args: Array[String]) = {
     
     val conf = new SparkConf()
       .setAppName("WordCount")
       .setMaster("local")
     val sc = new SparkContext(conf)
     
     val test = sc.textFile("food.txt")
     test.flatMap { line =>
       line.split(" ")
     }
     .map { word =>
       (word,1)
     }
     .reduceByKey(_ + _)
     .saveAsTextFile("food.count.txt")
     
     
    
     
   }
}