package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._
import play.api.test.{WithServer, WithApplication}
import com.jolbox.bonecp.BoneCPDataSource
import models.Person
import play.api.db._
import com.github.aselab.activerecord.dsl._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification {

  "select" in new WithApplication {
    val pool = DB.getDataSource("activerecord").asInstanceOf[BoneCPDataSource].getPool

    var i = 0

    (1 to 100).map { i =>
      Person.toList
      println(pool.getTotalFree + " " + pool.getTotalLeased)

      if (i % 10 == 0) println(i + "===")
    }
  }

  "count" in new WithApplication {
    val pool = DB.getDataSource("activerecord").asInstanceOf[BoneCPDataSource].getPool

    (1 to 100).map { i =>
      Person.count
      println(pool.getTotalFree + " " + pool.getTotalLeased)

      if (i % 10 == 0) println(i + "===")
    }
  }

  "max" in new WithApplication {
    val pool = DB.getDataSource("activerecord").asInstanceOf[BoneCPDataSource].getPool

    (1 to 100).map { i =>
      Person.compute(p => max(p.age))
      println(pool.getTotalFree + " " + pool.getTotalLeased)

      if (i % 10 == 0) println(i + "===")
    }
  }
}