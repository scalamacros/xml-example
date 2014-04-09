import scala.reflect.runtime.universe._
import org.scalamacros.xml.RuntimeLiftables._

object Test extends App {
  // For more examples see test cases in:
  // https://github.com/scalamacros/xml/tree/master/tests/src/test/scala
  def example(direct: Tree, unquoted: Tree): Unit = {
    println()
    println("=======")
    println("These two should be the same:")
    println("Direct: " + direct)
    println("Unquoted: " + unquoted)
  }
  example(q"""<foo a:a="a" b:b="b"/>""", q"${<foo a:a="a" b:b="b"/>}")
  example(q"<foo>{x + y}</foo>", q"${<foo>{Unquote(q"x + y")}</foo>}")
  example(q"""<foo xmlns:pre="uri"/>""", q"${<foo xmlns:pre="uri"/>}")
  println(Macros.manipulate(<foo><bar/></foo>))
}