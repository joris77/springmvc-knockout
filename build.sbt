import com.github.siasia.PluginKeys._
import com.github.bigtoast.sbtliquibase.LiquibasePlugin

seq(webSettings :_*)

name := "spring"

version := "1.0"

scalaVersion := "2.10.0"

seq(LiquibasePlugin.liquibaseSettings: _*)

liquibaseUsername := "root"

liquibasePassword := "root"

liquibaseDriver := "com.mysql.jdbc.Driver"

liquibaseUrl := "jdbc:mysql://localhost/mvc"

liquibaseChangelog := "src/main/resources/changelog.xml"

resolvers ++= Seq(
  "releases" at "https://oss.sonatype.org/content/groups/scala-tools/"
 )

libraryDependencies ++= Seq(
  "org.springframework" % "spring-webmvc" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-web" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-tx" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-jdbc" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-orm" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-aspects" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-aop" % "3.2.1.RELEASE" exclude("commons-logging", "commons-logging"),
  "org.springframework" % "spring-test" % "3.2.1.RELEASE" % "test" exclude("commons-logging", "commons-logging"),
  "com.google.guava" % "guava" % "14.0.1",
  "org.hibernate" % "hibernate-validator" % "4.2.0.Final",
  "org.hibernate" % "hibernate-search" % "4.2.0.Final",
  "org.hibernate" % "hibernate-entitymanager" % "4.2.0.Final",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "javax.servlet" % "servlet-api" % "2.5",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.2",
  "org.slf4j" % "slf4j-api" % "1.7.2",
  "ch.qos.logback" % "logback-classic" % "1.0.9",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.0.4",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.0.4",
  "mysql" % "mysql-connector-java" % "5.1.13",
  "commons-dbcp" % "commons-dbcp" % "1.4"
)