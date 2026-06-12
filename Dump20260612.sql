-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coding_platform
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `panic_event`
--

DROP TABLE IF EXISTS `panic_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `panic_event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `details` varchar(255) DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `problem_id` bigint DEFAULT NULL,
  `severity` int NOT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panic_event`
--

LOCK TABLES `panic_event` WRITE;
/*!40000 ALTER TABLE `panic_event` DISABLE KEYS */;
INSERT INTO `panic_event` VALUES (104,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:34:59.613310'),(105,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:00.695837'),(106,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:35:40.448096'),(107,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:41.334390'),(108,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:35:46.727493'),(109,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:47.382986'),(110,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:35:55.899806'),(111,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:56.561891'),(112,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:35:57.720069'),(113,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:58.395034'),(114,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:35:59.054981'),(115,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:35:59.955965'),(116,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:36:00.445184'),(117,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:36:01.303609'),(118,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:36:01.637901'),(119,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:36:02.399433'),(120,'User submitted solution','SUBMIT_CLICKED',2,1,'2026-06-12 09:36:03.430425'),(121,'Accepted','Accepted',2,0,'2026-06-12 09:36:03.496210'),(122,'Run Button Clicked','RUN_CLICKED',2,1,'2026-06-12 09:36:12.785405'),(123,'Compilation Error:\nMain.java:12: error: reached end of file while parsing\n    }\n     ^\n1 error\n','COMPILATION_ERROR',2,5,'2026-06-12 09:36:13.377836'),(124,'Run Button Clicked','RUN_CLICKED',13,1,'2026-06-12 09:57:05.466556'),(125,'User submitted solution','SUBMIT_CLICKED',13,1,'2026-06-12 09:57:13.952718'),(126,'Accepted','Accepted',13,0,'2026-06-12 09:57:16.671587'),(127,'Run Button Clicked','RUN_CLICKED',14,1,'2026-06-12 09:58:18.475041'),(128,'User submitted solution','SUBMIT_CLICKED',14,1,'2026-06-12 09:58:20.174280'),(129,'Accepted','Accepted',14,0,'2026-06-12 09:58:22.517019'),(130,'Run Button Clicked','RUN_CLICKED',15,1,'2026-06-12 09:58:38.270260'),(131,'User submitted solution','SUBMIT_CLICKED',15,1,'2026-06-12 09:58:40.344123'),(132,'Accepted','Accepted',15,0,'2026-06-12 09:58:40.366704'),(133,'Run Button Clicked','RUN_CLICKED',16,1,'2026-06-12 09:58:53.156947'),(134,'User submitted solution','SUBMIT_CLICKED',16,1,'2026-06-12 09:58:54.609903'),(135,'Accepted','Accepted',16,0,'2026-06-12 09:58:57.561576');
/*!40000 ALTER TABLE `panic_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `difficulty` varchar(255) DEFAULT NULL,
  `input_example` varchar(255) DEFAULT NULL,
  `output_example` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES (1,'Two Sum','Find two indices whose values add up to target','Easy','4\n2 7 11 15\n9','[0,1]'),(2,'Add Two Numbers','Given two integers, print their sum','Easy','2 3','5'),(3,'Multiply Two Numbers','Given two integers, print their product','Easy','4 5','20'),(4,'Palindrome Number','Check whether a number is palindrome','Medium','121','true'),(5,'Factorial','Find factorial of a number','Easy','5','120'),(6,'Fibonacci','Print nth Fibonacci number','Medium','7','13'),(13,'Reverse String','Print reverse of given string','Easy','hello','olleh'),(14,'Maximum of Three Numbers','Find the largest among three integers','Easy','5 8 3','8'),(15,'Count Digits','Count number of digits in a given integer','Easy','12345','5'),(16,'Prime Number','Check whether a number is prime','Medium','13','true'),(17,'Sum of Array','Find sum of all array elements','Easy','5\n1 2 3 4 5','15'),(18,'Longest Unique Substring','Find the length of the longest substring without repeating characters','Medium','abcabcbb','3'),(19,'Product Except Self','Return product of all elements except current index','Medium','4\n1 2 3 4','24 12 8 6'),(20,'Anagram Groups Count','Count how many anagram groups exist in the given list','Medium','6\neat tea tan ate nat bat','3'),(21,'Maximum Water Container','Find maximum water that can be contained','Medium','9\n1 8 6 2 5 4 8 3 7','49'),(22,'Most Frequent Element','Find the element occurring most frequently','Medium','6\n1 1 1 2 2 3','1'),(23,'Trapping Rain Water','Calculate total trapped rain water','Hard','12\n0 1 0 2 1 0 1 3 2 1 2 1','6'),(24,'Median of Two Arrays','Find median of two sorted arrays','Hard','2\n1 3\n1\n2','2'),(25,'Largest Histogram Area','Find largest rectangle area in histogram','Hard','6\n2 1 5 6 2 3','10'),(26,'Sliding Window Maximum','Find maximum in every window of size k','Hard','8\n1 3 -1 -3 5 3 6 7\n3','3 3 5 5 6 7'),(27,'Merge K Sorted Arrays','Merge multiple sorted arrays into one sorted array','Hard','3\n1 4 5\n1 3 4\n2 6','1 1 2 3 4 4 5 6');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `problem_id` bigint DEFAULT NULL,
  `code` varchar(5000) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `status` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_submission_problem` (`problem_id`),
  CONSTRAINT `fk_submission_problem` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
INSERT INTO `submission` VALUES (1,1,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int[] arr = new int[n];\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            arr[i] = sc.nextInt();\r\n        }\r\n\r\n        int target = sc.nextInt();\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            for(int j = i + 1; j < n; j++) {\r\n                if(arr[i] + arr[j] == target) {\r\n                    System.out.print(\"[\" + i + \",\" + j + \"]\");\r\n                    return;\r\n                }\r\n            }\r\n        }\r\n    }\r\n}','java','Accepted'),(2,2,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int a = sc.nextInt();\r\n        int b = sc.nextInt();\r\n\r\n        System.out.print(a + b);\r\n    }\r\n}','java','Accepted'),(3,3,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int a = sc.nextInt();\r\n        int b = sc.nextInt();\r\n\r\n        System.out.print(a * b);\r\n    }\r\n}','java','Accepted'),(4,4,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int num = sc.nextInt();\r\n        int original = num;\r\n        int reverse = 0;\r\n\r\n        while(num > 0) {\r\n            int digit = num % 10;\r\n            reverse = reverse * 10 + digit;\r\n            num = num / 10;\r\n        }\r\n\r\n        System.out.print(original == reverse);\r\n    }\r\n}','java','Accepted'),(5,5,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        long fact = 1;\r\n\r\n        for(int i = 1; i <= n; i++) {\r\n            fact *= i;\r\n        }\r\n\r\n        System.out.print(fact);\r\n    }\r\n}','java','Accepted'),(6,6,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        if(n == 0) {\r\n            System.out.print(0);\r\n            return;\r\n        }\r\n\r\n        if(n == 1) {\r\n            System.out.print(1);\r\n            return;\r\n        }\r\n\r\n        int a = 0;\r\n        int b = 1;\r\n\r\n        for(int i = 2; i <= n; i++) {\r\n            int c = a + b;\r\n            a = b;\r\n            b = c;\r\n        }\r\n\r\n        System.out.print(b);\r\n    }\r\n}','java','Accepted'),(7,1,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int[] arr = new int[n];\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            arr[i] = sc.nextInt();\r\n        }\r\n\r\n        int target = sc.nextInt();\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            for(int j = i + 1; j < n; j++) {\r\n                if(arr[i] + arr[j] == target) {\r\n                    System.out.print(\"[\" + i + \",\" + j + \"]\");\r\n                    return;\r\n                }\r\n            }\r\n        }\r\n    }\r\n','java','Accepted'),(8,1,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int[] arr = new int[n];\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            arr[i] = sc.nextInt();\r\n        }\r\n\r\n        int target = sc.nextInt();\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            for(int j = i + 1; j < n; j++) {\r\n                if(arr[i] + arr[j] == target) {\r\n                    System.out.print(\"[\" + i + \",\" + j + \"]\");\r\n                    return;\r\n                }\r\n            }\r\n        }\r\n    }\r\n','java','Accepted'),(9,1,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int[] arr = new int[n];\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            arr[i] = sc.nextInt();\r\n        }\r\n\r\n        int target = sc.nextInt();\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            for(int j = i + 1; j < n; j++) {\r\n                if(arr[i] + arr[j] == target) {\r\n                    System.out.print(\"[\" + i + \",\" + j + \"]\");\r\n                    return;\r\n                }\r\n            }\r\n        }\r\n    }\r\n','java','Accepted'),(10,1,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int[] arr = new int[n];\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            arr[i] = sc.nextInt();\r\n        }\r\n\r\n        int target = sc.nextInt();\r\n\r\n        for(int i = 0; i < n; i++) {\r\n            for(int j = i + 1; j < n; j++) {\r\n                if(arr[i] + arr[j] == target) {\r\n                    System.out.print(\"[\" + i + \",\" + j + \"]\");\r\n                    return;\r\n                }\r\n            }\r\n        }\r\n    }\r\n','java','Accepted'),(11,2,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int a = sc.nextInt();\r\n        int b = sc.nextInt();\r\n\r\n        System.out.print(a + b);\r\n    }\r\n','java','Accepted'),(12,13,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        String str = sc.nextLine();\r\n\r\n        StringBuilder sb = new StringBuilder(str);\r\n\r\n        System.out.print(sb.reverse());\r\n    }\r\n}','java','Accepted'),(13,14,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int a = sc.nextInt();\r\n        int b = sc.nextInt();\r\n        int c = sc.nextInt();\r\n\r\n        System.out.print(Math.max(a, Math.max(b, c)));\r\n    }\r\n}','java','Accepted'),(14,15,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int num = sc.nextInt();\r\n\r\n        int count = 0;\r\n\r\n        while (num > 0) {\r\n            count++;\r\n            num /= 10;\r\n        }\r\n\r\n        System.out.print(count);\r\n    }\r\n}','java','Accepted'),(15,16,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        if (n <= 1) {\r\n            System.out.print(false);\r\n            return;\r\n        }\r\n\r\n        for (int i = 2; i * i <= n; i++) {\r\n            if (n % i == 0) {\r\n                System.out.print(false);\r\n                return;\r\n            }\r\n        }\r\n\r\n        System.out.print(true);\r\n    }\r\n}','java','Accepted'),(16,17,'import java.util.*;\r\n\r\npublic class Main {\r\n    public static void main(String[] args) {\r\n\r\n        Scanner sc = new Scanner(System.in);\r\n\r\n        int n = sc.nextInt();\r\n\r\n        int sum = 0;\r\n\r\n        for (int i = 0; i < n; i++) {\r\n            sum += sc.nextInt();\r\n        }\r\n\r\n        System.out.print(sum);\r\n    }\r\n}','java','Accepted'),(17,17,'s = input()\r\nprint(s[::-1])','python','Accepted');
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_case`
--

DROP TABLE IF EXISTS `test_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_case` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `problem_id` bigint DEFAULT NULL,
  `input` varchar(1000) DEFAULT NULL,
  `expected_output` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_testcase_problem` (`problem_id`),
  CONSTRAINT `fk_testcase_problem` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_case`
--

LOCK TABLES `test_case` WRITE;
/*!40000 ALTER TABLE `test_case` DISABLE KEYS */;
INSERT INTO `test_case` VALUES (1,6,'7','13'),(2,6,'10','55'),(3,13,'hello','olleh'),(4,13,'java','avaj'),(5,13,'coding','gnidoc'),(6,14,'5 8 3','8'),(7,14,'10 20 30','30'),(8,14,'50 40 20','50'),(9,16,'13','true'),(10,16,'15','false'),(11,16,'2','true'),(12,16,'21','false'),(13,27,'3\n1 4 5\n1 3 4\n2 6','1 1 2 3 4 4 5 6');
/*!40000 ALTER TABLE `test_case` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-12 12:14:50
