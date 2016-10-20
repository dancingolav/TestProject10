# TestProject

Тесты: Login и RadioButtons с использованием PageObject Pattern

Test RadioButtons считается пройденным, если в окне логов отображаются  правильные названия radio buttons.

Для запуска теста можно указать желаемый тип браузера и путь и имя файла драйвера в файле testng.xml.
В настоящий момент можно использовать FireFox, IE, Opera, Chrome.
Данные о типе браузера, путь и имя файла драйвера будут взяты тестом через @Parameters из файла testng.xml,
и их можно менять. Примеры настройки приведены в данном файле (см. ниже) и в файле testng.xml. Данные для тестирования
тестовые методы получают через @Dataprovider.

ЗАПУСК И НАСТРОЙКА ТЕСТА<br />

    I. СБОРКА ТЕСТА: НАСТРОЙКА POM.XML
    1.1 ЗАВИСИМОСТИ
    1.2 ПЛАГИНЫ

    II. ЗАПУСК ТЕСТА: НАСТРОЙКА TESTNG.XML
    2.1 ТИП БРАУЗЕРА В TESTING.XML
    2.2 ПУТЬ И ИМЯ ФАЙЛА ДРАЙВЕРА В ФАЙЛЕ TESTNG.XML
    2.3 ПРИМЕРЫ

ЗАПУСК И НАСТРОЙКА ТЕСТА<br />

I. СБОРКА ТЕСТА: НАСТРОЙКА POM.XML
1.1 ЗАВИСИМОСТИ (dependencies)

Следующие описания зависимостей должны присутствовать в файле POM.XML для сборки теста. Они добавят новые или перепишут<br />
зависимости используемые по умолчанию. Для справки см. в IntelliJ Idea: Maven -> Maven Effective POM


```xml
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
       <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.8</version>
            <scope>test</scope>
        </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.0.0-beta4</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-lang3</artifactId>
        <version>3.4</version>
    </dependency>
```

1.2 ПЛАГИНЫ

Следующие настройки должны присутствовать в файле POM.XML для сборки и запуска теста. Будут добавлены новые
настройки или переписаны существующие по умолчанию. Используется JDK 1.8.
Для справки см. в IntelliJ Idea: Maven -> Maven Effective POM <br />


```xml
<build>
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.3.2</version>
        <configuration>
            <source>1.8</source>
            <target>1.8</target>
        </configuration>
    </plugin>

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.10</version>
        <configuration>
            <suiteXmlFiles>
               <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
            </suiteXmlFiles>
        </configuration>
    </plugin>
</plugins>
</build>
```

II. ЗАПУСК ТЕСТА: НАСТРОЙКА TESTNG.XML<br />
2.1 ТИП БРАУЗЕРА В TESTING.XML

Для запуска теста можно указать желаемый тип браузера в testng.xml По умолчанию будет использовано значение "chrome".

2.2 ПУТЬ И ИМЯ ФАЙЛА ДРАЙВЕРА В ФАЙЛЕ TESTNG.XML

Если указан желаемый тип браузера, то небходимо указать путь и имя файла драйвера в testng.xml <br />
По умолчанию будет использовано значение: "D:\PersonalDrivers\chromedriver.exe"

2.3 ПРИМЕРЫ
Примеры также можно посмотреть в файле testng.xml

Для FireFox:
```xml
 <parameter name="browser"  value="firefox"/>
 <parameter name="pathToDriver"  value="D:\PersonalDrivers\geckodriver.exe"/>
```
Для Chrome:
```xml
<parameter name="browser"  value="chrome"/>
<parameter name="pathToDriver"  value="D:\PersonalDrivers\chromedriver.exe"/>
```

Для Internet Explorer:
```xml
 <parameter name="browser"  value="ie"/>
 <parameter name="pathToDriver"  value="D:\PersonalDrivers\IEDriverServer.exe"/>
```
Для Opera:
```xml
<parameter name="browser"  value="opera"/>
<parameter name="pathToDriver"  value="D:\PersonalDrivers\operadriver.exe"/>
```