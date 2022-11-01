object App {
  def main(args: Array[String]): Unit = {
    /* Задание a.
    */
    val text = "Hello, Scala!"
    println(text)
    println(text.reverse)  // вывод строки в обратном порядке
    println(text.toLowerCase) // в нижний регистр
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
    println("Вычисляем месячный оклад сотрудника:")
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
      // Находим сумму элементов списка
      for (n <- salary_list) {
        sum_salary_list = sum_salary_list + n
      }
      // средний оклад по отделу
      val mean_salary_list = sum_salary_list / salary_list.size: Double
      (salary - mean_salary_list) / mean_salary_list * 100
    }
    val salary_list: List[Double] = List.apply(100, 150, 200, 80, 120, 75)  // оклады сотрудников
    println("Отклонение оклада нового сотрудника от среднего по отделу:")
    val new_employee_month_salary_deviation = salary_deviation(new_employee_month_salary, salary_list)
    println(new_employee_month_salary_deviation, "%")


    /* Задание d.
    Попробуйте рассчитать новую зарплату сотрудника, добавив (или отняв, если сотрудник плохо себя вел)
    необходимую сумму с учетом результатов прошлого задания.
    Добавьте его зарплату в список и вычислите значение самой высокой зарплаты и самой низкой.
    */
    def salary_change(salary: Double, delta_percent: Double): Double = salary * (1 + delta_percent/100)

    def min_max_salary(salary_list: List[Double]): List[Double] = {
      var min = 1000000: Double
      var max = 0: Double
      for (n <- salary_list) {
        if (n > max) max = n
        if (n < min) min = n
      }
      List.apply(min, max)
    }

    def add_to_list_salaries(salary_list: List[Double], new_element: Double): List[Double] = {
      salary_list :+ new_element
    }
    // Рассчитываем новую зарплату нового сотрудника
    val new_new_employee_month_salary = salary_change(new_employee_month_salary, new_employee_month_salary_deviation)
    // Добавляем новую зарплату нового сотрудника в список зарплат отдела
    val new_salary_list = add_to_list_salaries(salary_list, new_new_employee_month_salary)
    // Печатаем минимальную и максимальную зарплаты сотрудников отдела
    println("Минимальная и максимальная зарплаты сотрудников отдела:")
    println(min_max_salary(new_salary_list))


    /* Задание e.
    Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
    Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
    */


    /* Задание f.
    Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
    Вычислите самостоятельно номер сотрудника в списке так, чтобы сортировка не нарушилась
    и добавьте его на это место.
    */


    /* Задание g.
    Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
    На входе программе подается «вилка» зарплаты специалистов уровня middle
    */


    /* Задание h.
    Однако наступил кризис и ваши сотрудники требуют повысить зарплату.
    Вам необходимо проиндексировать зарплату каждого сотрудника на уровень инфляции – 7%
    */

  }
}
