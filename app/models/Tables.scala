package models

/**
 * User: ewnd9
 * Date: 2/2/14 : 1:04 AM
 */
import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

object Tables extends ActiveRecordTables with PlaySupport {
  val people = table[Person]
}
