## Проект по автоматизации тестовых сценариев для сайта компании E-dostavka

### E-dostavka - это белорусский интернет-гипермаркет, входящий в состав холдинга "Евроопт". Он предоставляет услуги бесплатной доставки продуктов питания и промышленных товаров на дом и в офис.

**Автор:** Максим Тимошенко  
**Email:** maksim-timoshenko-97@mail.ru  
**Год:** 2025

---

## 🎯 Цель проекта

Целью проекта стало создание **универсального фреймворка**, позволяющего:
- Проверять корректность функционирования приложения через **UI и API**.
- Снижать количество ручных тестов за счёт **автоматизации**.
- Обеспечивать высокую **стабильность и воспроизводимость** результатов тестирования.

## 🛠️ Использованные технологии

| Инструмент             | Назначение                                                         |
|------------------------|--------------------------------------------------------------------|
| **Java**               | Язык программирования                                              |
| **Selenium WebDriver** | Для автоматизации UI                                               |
| **JUnit**              | Библиотека для написания и запуска тестов                          |
| **Allure Report**      | Для генерации отчётов                                              |
| **REST Assured**       | Для API-тестирования                                               |
| **Java Faker**         | Для генерации случайных данных                                     |
| **Postman**            | Это HTTP-клиент для тестирования API                               |
| **Jenkins**            | Обеспечение последовательного и автоматизированного способа сборки |
| **Log4j**              | Библиотека логирования (журналирования)                            |
| **Maven**              | Это инструмент для автоматической сборки проектов на Java          |

---

## 🧪 Тестовые сценарии

### 🔹 UI-тестирование

- Авторизация пользователя
- Регистрация нового пользователя
- Восстановление пароля
- Поиск по сайту

### 🔹 API-тестирование

- Авторизация без ввода телефона
- Восстановление пароля с неверными данными
- Регистрация с корректными и некорректными данными
- Поиск по сайту

---

## 💡 Утилитарные методы

### 1. Генерация случайного номера телефона

```java
public static String generateRandomPhoneNumber() {
    Random random = new Random();
    String[] operatorCodes = {"25", "29", "33", "44"};
    String operatorCode = operatorCodes[random.nextInt(operatorCodes.length)];
    int uniquePart = random.nextInt(1_000_000, 10_000_000);
    return String.format("%s%03d-%02d-%02d", operatorCode, uniquePart / 10000, (uniquePart / 100) % 100, uniquePart % 100);
}

✅ Пример вывода: 33123-45-67 
```
### 2. Ожидание кликабельности элемента

```java
public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    return wait.until(ExpectedConditions.elementToBeClickable(element));
}
```
### 3. Удаление атрибута 'disabled' через JS

```java 
public static void enableElement(WebDriver driver, WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled');", element);
}
```

### 4. Ожидание видимости элемента

```java 
public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
```
# 🌐 Интеграция с системой

Фреймворк интегрирован с реальной системой — [edostavka.by](https://edostavka.by )

🔗 [GitHub репозиторий](https://github.com/mtsimashenka/taf-edostavka/tree/ui-edostavka )

---

## 🚀 Результаты

| До автоматизации        | После автоматизации         |
|-------------------------|----------------------------|
| Ручное тестирование      | Автоматическое тестирование |
| Медленное выполнение    | Быстрое выполнение          |
| Человеческие ошибки      | Минимизация ошибок          |
| Сложное масштабирование  | Легкое расширение тестов    |

---

## 🧩 Интересные технические моменты

### Использование XPath оси `following-sibling`

Пример:
```xpath
//label[text()='Пароль']/following-sibling::input