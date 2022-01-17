# test_task
Для запуска приложения выполните следующую последовательность действий: 
1. Откройте консоль
2. Введите git clone https://github.com/MaximusDraganoid/test_task.git
3. Введите cd test_task/
4. Введите docker build -t alfa_test_task:latest .
5. Введите docker run -d -p 8080:8080 alfa_test_task
6. Подождите некоторое время, пока сервис не будет запущен (на моем ноутбуке это около 1 минуты и 30 секунд).
7. Congratulations! Вы запустили данный сервис. Посмотрите его здесь http://localhost:8080/gif_by_currency 

В отличии от main ветки здесь приведен небольшой функционал для работы с кафкой. 
Написан небольшой клиент для того, чтобы получать значения валют за 2 указанных дня. Работает так: веб-клиенту приходит запрос вида GET http://localhost:10101/statistic?start_date=2012-01-01&end_date=2012-01-31&currency=RUB, обработчик кладет информацию о запросе в топик "statistic". После этого, сервер обрабатывает приходящие сообщения и кладет ответ в топик "answers". Ответ приходит и отображается на клиенте. 

В конфиге для consumer написан пример того каким образом можно получать и дессириализовывать объекты из вне.
