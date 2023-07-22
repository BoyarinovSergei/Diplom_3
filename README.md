README.md
В данном проекте написаны UI автотесты на сервис яндекса - Stellar Burgers.

Проверки написаны под два браузера: Yandex и Chrome.

Используются библиотеки:

1. junit4 - для тестов
2. rest-assured - фреймворк для тестирования api
3. io.qameta.allure - отчеты
4. gson - для сериализации/десериализации
5. lombok - для добавления setters/getters и constructors
6. org.aspectj - слушалка для отчетов
7. Selenide - для работы с браузерами
   
Для генерации allure-report можно использовать allure serve target/allure-results --host localhost --port 9999
