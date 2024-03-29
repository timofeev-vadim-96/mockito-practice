## Тимофеев Вадим

### Группа: Веб-разработка на Java | Тех. специализация | 2

> `Unit-тесты. Урок 4. Зависимости в тестах`

* Написание тестов с использованием библиотеки Mockito

> Вопросы по типам заглушек для меня в определенной степени теряют смысл в Mockito, т.к. все, что мы делали
независимо от функционала, создавалась через mock() - объекты, даже если в реализации это похоже на Stub по определению.

1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?  
Ответ: использование тестовых заглушек позволяет заменить внешние зависимости с целью исключения воздействия
внешних факторов на тестируемый код. Таким образом, мы делаем предсказуемым поведение внешних зависимостей
с помощью тестовых заглушек. К тому же, одним из атрибутов качественного unit-теста является его изолированность 
от внешних зависимостей.

2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
Ответ: Mock. А на нем с помощью метода verify(mockObject, times()).someMethod(a,b) убедиться, 
что конкретный метод был вызван с конкретными параметрами определенное количество раз

3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?
Ответ: Stub. В mockito методами стаббинга являются конструкции: when(..).then(..) и т.д. Но сам объект будет создаваться
через mock() почему-то)) Возможно, просто логику мокирования обобщили...

4) Какой тип тестовой заглушки вы бы использовали для имитации  взаимодействия с внешним API или базой данных?
Ответ: Fake - т.к. с помощью него производится замена функциональности вызываемого компонента альтернативной реализацией.
Например, вместо полноценной БД MySql/PostgreSQL мы могли бы обращаться к классу на базе коллекции, содержащей аналогичные
данные, но при этом доступ к простой коллекции будет осуществляться быстрее, и нет необходимости в разворачивании
полноценной БД.

* Практическое задание выполнено в классе BookServiceTest