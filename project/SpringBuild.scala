import sbt._
import classpath.ClasspathUtilities
import Keys._
import com.github.siasia._
import PluginKeys._


object SpringBuild extends Build {

  lazy val root = Project(id = "spring",
                            base = file("."),
                            settings = Project.defaultSettings)

}
