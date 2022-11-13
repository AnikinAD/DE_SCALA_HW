import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    var string = "Hello, Scala!"
    println(string)
    string = string.toLowerCase()
    println(string)
    string = string.dropRight(1)
    println(string)
    string = string + " and goodbye python!"
    println(string)

//    println("Расчет годового дохода")
//    println("Ввести годовой доход, размер премии  в процентах, компенсации питания")
//    val salary = StdIn.readLine().toInt
//    println("Ввести размер премии  в процентах")
//    val bonus = StdIn.readLine().toFloat / 100
//    println("Ввести размер компенсации питания")
//    val meal = StdIn.readLine().toInt
//    val tax = 0.13
//    val sum = (salary + salary * bonus + meal) * (1 - tax)
//    println(sum)

    println("Вычисление отклонения зарплаты")
    val salaryList = List(100, 150, 200, 80, 120, 75)
    val avgSalary = salaryList.sum.toFloat / salaryList.size
    println("Средняя зарплата= " + avgSalary)
    val diffAvgSalary = salaryList.map( x => (x - avgSalary)/avgSalary*100)
    println("Отклонение от средней зарплаты " )
    println(diffAvgSalary)


    println("Апдейт зарплаты")
    val updatedSalary =(salaryList,diffAvgSalary).zipped.map(_ - _)
    println(updatedSalary)
    println("Минимальная зарплата= " + updatedSalary.min )
    println("Максимальная зарплата= " + updatedSalary.max )

    println("Добавили новичков")
    val newEmp = (90F :: 350F :: updatedSalary).sortWith(_ < _)
    println(newEmp)

    println("Добавили новичка не нарушая сортировку")
    def insert[T](list: List[T], i: Int, value: T) = {
      list.take(i) ++ List(value) ++ list.drop(i)
    }
    val newSortedEmp = insert(newEmp, newEmp.indexWhere(element => element > 130F),130F)
    println(newSortedEmp)

    println("Выделяем миддлов")
    val middleEmp = newSortedEmp.zipWithIndex.filter(pair =>  pair._1 < 130F && 115F < pair._1 ).map(pair => pair._2)
    println(middleEmp)

    println("Индексация")
    val indexEmpSal = newSortedEmp.map( x => x * 1.07)
    println(indexEmpSal)
  }
}