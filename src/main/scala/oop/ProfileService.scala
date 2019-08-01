package oop

trait Profile{
  def out()
}

class ProfileService(
                      val profileDao: String) {
}

class ProfileS2(implicit val s2: Profile)

object ProfileService {
  def main(args: Array[String]): Unit = {
    val profileService = new ProfileService("1111")
    println(profileService.profileDao)
  }

}


