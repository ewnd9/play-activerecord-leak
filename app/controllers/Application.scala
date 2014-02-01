package controllers

import play.api.mvc._
import com.jolbox.bonecp.BoneCPDataSource
import com.github.aselab.activerecord.dsl._
import models.Person
import play.api.Play.current

object Application extends Controller {
  
  def index = Action {
    import play.api.db._
    val ds = DB.getDataSource("activerecord").asInstanceOf[BoneCPDataSource]
    val pool = ds.getPool

    (1 to 100).map { i =>
      Person.toList
      println(pool.getTotalFree + " " + pool.getTotalLeased)

      if (i % 10 == 0) println(i + "===")
    }

    Ok(views.html.index("Your new application is ready."))
  }
  
}