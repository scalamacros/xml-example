import scala.language.experimental.macros
import scala.reflect.macros.blackbox.Context
import scala.xml.Elem
import org.scalamacros.xml.MacroLiftables

object Macros {
  def manipulate(elem: Elem): Elem = macro Bundle.impl
}

class Bundle(val c: Context) extends MacroLiftables {
  import c.universe._
  def impl(elem: Tree): Tree = {
    // For more examples see test cases in:
    // https://github.com/scalamacros/xml/tree/master/tests/src/test/scala
    val q"${result: scala.xml.Elem}" = elem
    q"$result"
  }
}