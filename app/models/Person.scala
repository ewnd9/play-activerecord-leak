package models

/**
 * User: ewnd9
 * Date: 2/2/14 : 1:05 AM
 */
import com.github.aselab.activerecord._
import com.github.aselab.activerecord.dsl._

case class Person(name: String, age: Int) extends ActiveRecord
object Person extends ActiveRecordCompanion[Person]
