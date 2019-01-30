import scala.Tuple2

val test = Array("hello")

val tuple: (Int, String) = (1, "ciao")

val startingTuple = Tuple2[Char,String]('c',"")

//the tuple char Int will represent the state that is the last char and the count

def encode(word: String): String =
  word.foldLeft(List.empty[(Char, Int)]) { (acc, e) =>
    acc match {
      case Nil => (e, 1) :: Nil
      case ((lastChar, lastCharCount) :: xs) if lastChar == e => (lastChar, lastCharCount + 1) :: xs
      case xs => (e, 1) :: xs
    }
  }.reverse.map { case (a, num) => s"$num$a" }.foldLeft("")(_ ++ _)

encode("hello")

val compressed = "hello".foldLeft(List.empty[(Char,Int)])((a: List[(Char,Int)],b: Char) => {
  a match {
    case Nil => {
      println(b)
      (b,1) :: Nil
    }
    case last :: tail =>
      val lastChar = last._1
      val lastCount = last._2
      if(lastChar == b) {
        println(lastChar.toString)
        (lastChar,lastCount+1) :: tail
      } else {
        println(lastChar.toString)
        (b,1) :: tail
      }
  }
})



List(1, 2, 4).flatMap(elem => List(elem * 2))


List(Some(1), None, Some(2)).map { case Some(x) => x
case None => 0
}

List(Some(1), None, Some(2)).flatMap(e => e)