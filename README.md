# SOAP Example
Based on article: https://www.baeldung.com/jax-ws

1. server 
2. once server is started a wsdl schema can be downloaded
3. from wsdl gradle generated sources 
4. client example uses generated source for accessing server

# Задача

1. Реалізувати клас Order. Цей клас зберігатиме значення: id, date, cost, products
2. Реалізувати клас Product. Цей клас зберігатиме значення: id, name, cost
3. Замовлення зберігатимуться у спеціалізованому класі-репозиторії OrderRepository. 
   - Реалізувати метод отримання замовлення за ID
   - Реалізувати метод отримання всіх замовлень
   - Реалізувати метод додавання замовлення
4. Реалізувати SOAP-сервіс для взаємодії з ресурсом Order.
5. Використання
   - Отримання конкретного замовлення
   - Отримання всіх замовлень

**ВАЖЛИВО**: Базу даних не потрібно підключати. OrderRepository буде зберігати певні дані.