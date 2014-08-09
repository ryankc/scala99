package problems


object S1LastElementInList extends App {

  def lastElementOne(items:List[Int]) = {
    var index = 0
    items.zipWithIndex foreach { case (e, i) => index = i}
    (items(index))
  }

  def lastElementTwo(items:List[Int]) = {
    val totalItems:Int = items.size
    (items(totalItems - 1))
  }

  def lastElementThree(items:List[Int]):Int = items match {
      case item::Nil => item
      case _ :: item => lastElementThree(item)
      case _ => throw new NoSuchElementException
  }

  def lastElementFour(items:List[Int]) = {
    items.last
  }

  def timing(label:String, f: List[Int]=>Int, question:List[Int]) = {
    val startOne:Long = System.nanoTime()
    for(i<- 1 to 100000){
      f(question)
    }
    val endOne:Long = System.nanoTime()
    println("%s %s ms".format(label, ((endOne-startOne)/(1000*1000))))
  }

  val question = List(1, 1, 2, 3, 5, 8)
  timing("S1", lastElementOne, question)
  timing("S2", lastElementTwo, question)
  timing("S3", lastElementThree, question)
  timing("S4", lastElementFour, question)

}
