# TestProject10

Тестируется поиск отелей  *** на сайте ***<br />
Проверяется поиск при корректных данных (страна и город), неполных данных (указана страна или город), частично верных данных,
(указана страна, несуществующий город и vice versa ) и полностью некорректных данных. Для некорректных данных тест считается пройденным,
если выдается сообщение об ошибке, для корректных или частично верных данных, если выдается список отелей для страны или города в стране,
если город указан верно.<br />
Используются PageObject pattern, PageFactory и аннотациями @FindBy, Allure и FailureListener для отчетов и скриншотов.<br />
Данные для тестирования MainBookingTest получает через @Dataprovider<br />
Для запуска теста можно указать желаемый тип браузера и путь и имя файла драйвера в файле testng.xml.<br />
В настоящий момент можно использовать FireFox, IE, Opera, Chrome, PhantomJS<br />
Данные о типе браузера, путь и имя файла драйвера будут взяты тестом через @Parameters из файла testng.xml,<br />
и их можно менять. Примеры настройки приведены в файле testng.xml<br />
