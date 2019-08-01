package other

object Account {

  val TypeAnonymous = "5"
  val TypeCommon = "1"
  val TypeService = "4"
  val TypeDelete = "-1"
  val PRIVACY_AGREEMENT = 1 //同意隐私政策
  object Status {
    val ACTIVE0: Int = 0
    val ACTIVE1: Int = 1
    val INACTIVE: Int = 2
  }

}

case class Account(
                    id: Long = 0,
                    clientId: Option[String] = None,
                    ip: Option[String] = None,
                    nickname: Option[String] = None,
                    typ: String = "1",
                    status: Option[Int] = None,
                    step: Option[String] = None,
                    avatar: Option[String] = None,
                    email: Option[String] = None,
                    snow: Option[String] = None,
                    password: Option[String] = None,
                    domain: Option[String] = None,
                    createdAt: Long = System.currentTimeMillis(),
                    lastRecordAt: Long = System.currentTimeMillis(),
                    telBindAt: Option[Long] = None) {

  def isAnonymous = typ == Account.TypeAnonymous

}
