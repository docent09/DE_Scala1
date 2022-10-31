object App {
  def main(args: Array[String]): Unit = {
    val text = "Hello, Scala!"
    println(text)
    println(text.reverse)  // вывод строки в обратном порядке
    println(text.toLowerCase) // в нижний регистр
    println(text.dropRight(1))  // удаление последнего символа
    println(text.dropRight(1) + " and goodbye python!")



  }
}
