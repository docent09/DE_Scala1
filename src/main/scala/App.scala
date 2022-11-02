object App {
  def main(args: Array[String]): Unit = {
    /* Задание a.
    */
    val text = "Hello, Scala!"
    println(text)
    println(text.reverse)       // вывод строки в обратном порядке
    println(text.toLowerCase)   // в нижний регистр
    println(text.dropRight(1))  // удаление последнего символа
    println(text.dropRight(1) + " and goodbye python!")


    /* Задание b.
    Напишите программу, которая вычисляет ежемесячный оклад сотрудника после вычета налогов.
    На вход вашей программе подается значение годового дохода до вычета налогов,
    размер премии – в процентах от годового дохода и компенсация питания
    */
    def salary(year_income: Double, prize: Double, eating: Double): Double = {
      val tax = 0.13  // налог
      (year_income * (1 + prize / 100) + eating) * (1 - tax) / 12
    }
    println("Вычисляем месячный оклад нового сотрудника:")
    val new_employee_month_salary = salary(600, 10, 60)
    println(new_employee_month_salary)


    /* Задание с.
    Напишите программу, которая рассчитывает для каждого сотрудника отклонение (в процентах)
    от среднего значения оклада на уровне всего отдела.
    В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
    На вход вышей программе подаются все значения, аналогичные предыдущей программе,
    а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
    */
    def salary_deviation(salary: Double, salary_list: List[Double]): Double = {
      var sum_salary_list = 0: Double
      // средний оклад по отделу
      val mean_salary_list = salary_list.sum / salary_list.size: Double
      (salary - mean_salary_list) / mean_salary_list * 100
    }
    val salary_list: List[Double] = List.apply(100, 150, 200, 80, 120, 75)  // оклады сотрудников
    //val salary_list = List(100, 150, 200, 80, 120, 75)// оклады сотрудников
    println("Отклонение оклада нового сотрудника от среднего по отделу:")
    val new_employee_month_salary_deviation = salary_deviation(new_employee_month_salary, salary_list)
    println(new_employee_month_salary_deviation, "%")


    /* Задание d.
    Попробуйте рассчитать новую зарплату сотрудника, добавив (или отняв, если сотрудник плохо себя вел)
    необходимую сумму с учетом результатов прошлого задания.
    Добавьте его зарплату в список и вычислите значение самой высокой зарплаты и самой низкой.
    */
    def salary_change(salary: Double, delta_percent: Double): Double = salary * (1 - delta_percent/100)

    def add_to_list_salaries(salary_list: List[Double], new_element: Double): List[Double] = {
      salary_list :+ new_element
    }
    // Рассчитываем новый оклад нового сотрудника с учетом корректировки
    val new_new_employee_month_salary = salary_change(new_employee_month_salary, new_employee_month_salary_deviation)
    println("Новый оклад нового сотрудника:", new_new_employee_month_salary)
    // Добавляем новую зарплату нового сотрудника в список зарплат отдела
    var new_salary_list = add_to_list_salaries(salary_list, new_new_employee_month_salary)
    // Печатаем минимальную и максимальную зарплаты сотрудников отдела
    println("Список окладов сотрудников с учетом оклада новго сотрудника:")
    println(new_salary_list)
    println("Минимальный оклад сотрудников отдела:")
    println(new_salary_list.min)
    println("Максимальный оклад сотрудников отдела:")
    println(new_salary_list.max)


    /* Задание e.
    Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
    Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
    */
    new_salary_list = add_to_list_salaries(new_salary_list, 350)
    new_salary_list = add_to_list_salaries(new_salary_list, 90)
    println("Добавляем оклады двух новых сотрудников:")
    println(new_salary_list)
    println("Сортируем список окладов от меньшего к большему:")
    var sorted_salary_list = new_salary_list.sorted
    println(sorted_salary_list)


    /* Задание f.
    Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
    Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась
    и добавьте его на это место.
    */
    val new_employee_salary = 130: Double
    var i = 0: Int
    // Находим номер, на который нужно вставить оклад нового сотрудника
    while (sorted_salary_list(i) < new_employee_salary) i += 1
    // Вставляем в список окладов новый оклад в нужную позицию
    sorted_salary_list = sorted_salary_list.take(i) ++ List(new_employee_salary) ++ sorted_salary_list.drop(i)
    println(f"Обновленный список окладов с учетом нового сотрудника с окладом $new_employee_salary:")
    println(sorted_salary_list)


    /* Задание g.
    Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
    На входе программе подается «вилка» зарплаты специалистов уровня middle
    */
    def middle_calc(salary_list: List[Double], salary_from: Double, salary_to: Double): List[Int] = {
      var numbers = List[Int]()
      for (i <- salary_list.indices)
        {
          if ((salary_list(i) >= salary_from) && (salary_list(i) <= salary_to))
          {
            numbers = numbers :+ i
          }
        }
      numbers
    }
    val salary_from = 100
    val salary_to = 160
    println(f"Номера сотрудников middle с окладом между $salary_from и $salary_to :")
    println(middle_calc(sorted_salary_list, salary_from, salary_to))


    /* Задание h.
    Однако наступил кризис и ваши сотрудники требуют повысить зарплату.
    Вам необходимо проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%
    */
    val crisys_salary_list = List[Double]()
    for (s <- sorted_salary_list) crisys_salary_list :+ 1.07 * s
    println("Список окладов сотрудников после повышения на 7%:")
    println(crisys_salary_list)

  }
}
